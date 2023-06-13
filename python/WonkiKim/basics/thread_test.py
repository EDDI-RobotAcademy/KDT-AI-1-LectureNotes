import logging
import threading
import time
import multiprocessing as mp

logging.basicConfig(level=logging.DEBUG,
                    format='%(threadName)-9s %(message)s')


# 프로세스와 스레드
# OS마다 Process 및 memory관리 메커니즘이 상이하여 일부 차이점이 존재함
# 대표적으로 windows vs Linux, Unix 형태를 띔
# 윈도우는 프로세스 및 스레드 모델이 상당이 좋지 못함
# 그래서 대부분 서버를 운영하는 경우 윈도우 서버를 사용한다 하면 의문을 띄는 경우가 많음
# 반면 리눅스와 그의 형인 유닉스는 유사한 메터니즘을 사용하고 있음.
# 실직적으로 윈도우즈에서는 프로세스 내부에 스레드가 존재하는 것으로 표현함
# 리눅스 유닉스의 경우엔 프로세스와 스레드를 모두 별개의 테스크로 분류함.
# 다만 차이가 있다면 프로세스는 그룹 대장의 역할을 의미함
# 과거 S사가 휘황찬란 했던 시절을 생각해보면 S사 하는 순가 떠오르는 인물이 있음
# 그것이 S사는 Thread Group ID에 해당하며 S사 회장은 Process에 해당함
# S사의 모든 직원들과 자기 자신의 프로세스가 있지만 소속은 S사였음
# 그러므로 스레드 그룹 아이디는 동일하되 프로세스 아이디가 다른 형태임
# 이것은 AWS에서도 살펴볼 수 있는 내용인데
# 우리는 리눅스 인스턴스를 사용하고 있으므로 ps 명령으로 이 내용의 일부를 살펴볼 수 있음
# ps -ef

# 이 명령어를 입력 했을 때 나나타는 PID가 바로 Process Id이며
# 사람에게 있어서는 고유한 주민들록 번호 같은 것

# ps -eLf라고 입력하면 스레드 정보도 확보가 가능함
# 부가적으로 ps -ef에서 TTY에 ? 로 나오는 것은 데몬 프로세스라고 부름
# 실질적으로 서비스 구동되는 애들은 전부 ?로 표기됨
# 또한 java 명령을 통해 jar파일을 실행하여 구동되는 서비스 또한 ? 로 표기되는 것을 볼 수 있음
# 마찬가지로 docker 또한 서비스로 구동되고 있으므로 ?로 표기됨

# 입력한 결과 아래와 같은 것들을 볼 수 있음
# root 1309 1 1309 0 3 Apr24 ? 00:00:00 /usr/sbin/rngd
# 501  4770  4627   0 11:33AM ttys000    0:00.00 grep docker
# ps -ef| grep docker

#  같은 PID를 같고 있는 결과들을 볼 수 있음

# 리눅스 커널 상 tgid를 사용한다는 부분

# 근본적으로 스레드를 사용하는 이유가 무엇인가?
# 작업을 병렬처리한다.
# - 동시 처리를 하고 싶어서

# CPU는 오로지 한 순간에 한가지 일을 한다.
# 실제로는 아주 빠른 속도로 Multi-Tasking을 하는 것 뿐

# 컴퓨터는 요즘 나오는 것들은 최소 2~3GHz
# f = 1/T -> T = 1/f
# GHz = 10^9 Hz
# 현 시대 가장 안 좋은 컴퓨터도 1초에 최소 10^9억번 연산을 할 수 있다는 뜻

# 예로 프로그램 1개다 0.001초를 할당해준다고 가정했을 때.
# 10^6개의 명령을 처리할 수 있습니다.
# 실제 운체에서는 이렇게 모두,에게 동일하게 0.001초씩 할당하는 방식을 Round Robin이라고 부른다.
# 보다 더 중요한 사항(우선순위)에 시간을 좀 더 할당해줌
# 예로 가장 중요한 것은  0.002초 사용, 별로 중요하지 않은 것은 0.0005초 형태로 구별함
# 우선순위에 따라 이 사이의 숫자값이 적절하게 조정됨

# Context Switching
# 여러 프로그램이 동시에 돌고 있는 상황에서
# zoom 이나 게임 같은 경우에는 지속적으로 켜져서 동작해야 합니다.
# 그런데 네트워크 이슈등이 없다면 끊김없이 동작하는 것을 볼 수 있늡니다.
# 그리고 서로 다른 프로그ㅐㅁ들이 순차적으로 실행되지만
# 기존 프로그램에게 제어권이 넘어 왔을 때도 여전히 잘 동작하는 것을 볼 수 있스비낟.
# 해답은 Context Switching

# 아래와 같은 상황을 생각해 봅지사.
# A Thread는 아래와 같은 작업을 합니다.

# mov 3, eax -> 숫자3을 eax에 넣기
# add eax, ebx -> eax + ebx -> ebx
# add ecx, eax

# B Thread 는 아래와 같습니다
# mov 7, eax
# mov ecx, 15
# add ecx, eax

# 하드웨어 자원은 물지적 제약 사항으로 어쩔 수 없이 모든 프로세스들이 공유해서 사용하게 됨
# 또한 프로세스들은 주어진 시간동안 동작을 하다가 제어권을 뺏겨 다른 프로세스가 동작하게 됨.
# 그러다 보니 위와 같이 eax및 ecx를 공유해서ㅗ 사용하다가 잘못된 값을 갖고 계산할 수 있음.
# 이것을 방지하기 위한 개념으로 사용되는 것이 context Switchin.

# 하드웨어 레지스터 정보를 메모리 스택에 저장한다는 것이 주된 관점
# Context Switching은 메모리 계층 구조상
# 레지스터 -> 메모리, 메모리 -> 레지스터 연산이므로 성능상 좋지는 못함
# 그럼에도 불구하고 데이터 무결성을 보장하기 위해 반드시 필요함
# 프로그래머가 코드를 어떻게 작성하느냐에 따라서도 어느정도는 조정할 수 있는 요소임

# 결론적으로 이런 문제가 발생하는 영역은 모두 어디?
# 공유메모리에 접근하기 때문
# 자원이 공유되기 때문
#


class ThreadPool(object):

    def __init__(self):
        super(ThreadPool, self).__init__()
        self.__active = []
        self.__lock = threading.Lock()

    def make_active(self, name):
        with self.__lock:
            self.__active.append(name)

            time.sleep(5)
            logging.debug("Running: %s", self.__active)

    def make_inactive(self, name):
        with self.__lock:
            self.__active.remove(name)
            logging.debug("Running: %s", self.__active)


def thread_test_function(semaphore, pool):
    logging.debug('풀에 조인하기까지 대기중...')

    with semaphore:
        name = threading.currentThread().getName()
        pool.make_active(name)
        time.sleep(1)
        pool.make_inactive(name)

def thread_test_sequence():
    pool = ThreadPool()
    semaphore = threading.Semaphore(3)

    for i in range(10):
        thread = threading.Thread(target=thread_test_function,
                                  name='thread_' + str(i),
                                  args=(semaphore, pool))
        thread.start()


def withdraw(money):
    for _ in range(20000):
        money.value -= 1


def deposit(money):
    for _ in range(20000):
        money.value += 1


def perform_process():
    # mp로 만든 값은 여러 프로세스가 공유해서 사용가능

    money = mp.Value('i', 20000)
    p1 = mp.Process(target=withdraw, args=(money,))
    p2 = mp.Process(target=deposit, args=(money,))
    # p1이 더하려고 하는 순간
    # p2가 들어가서 더하고
    # 혹은
    # p2가 더하려고 하는 순간
    # p1이 들어가서 빼면서 값이 꼬임

    # p2
    # mov money, eax
    # add 1, eax
    # mov eax, money

    # p1
    # mov money, eax
    # sub 1, eax
    # mov eax, money

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print(money.value)

def withdraw_lock(money, lock):
    for _ in range(20000):
        lock.acquire()
        money.value -= 1
        lock.release()

def deposit_lock(money, lock):
    for _ in range(20000):
        lock.acquire()
        money.value += 1
        lock.release()

def perform_process_lock():
    lock = mp.Lock()

    money = mp.Value('i', 20000)
    p1 = mp.Process(target=withdraw_lock, args=(money, lock))
    p2 = mp.Process(target=deposit_lock, args=(money, lock))

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print(money.value)

def advanced_perform_process():
    lock = mp.Lock()

    money = mp.Value('i', 20000)
    p1 = mp.Process(target=advanced_withdraw, args=(money, lock))
    p2 = mp.Process(target=advanced_deposit, args=(money, lock))

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print(money.value)

def advanced_withdraw(money, lock):
    lock.acquire()

    for _ in range(20000):
        money.value -= 1
    lock.release()

def advanced_deposit(money, lock):
    lock.acquire()

    for _ in range(20000):
        money.value += 1
    lock.release()


