import logging
import threading

# 여긴 좀 어렵다고 하심

logging.basicConfig(level=logging.DEBUG,
                    format='%(threadName)-9s) %(message)s', )

# 프로세스(Procedd)와 스레드(Thread)
# OS 마다 Process 및 Memory 관리 메커니즘이 상이하여 일부 차이점이 존재함
# 대표적으로 Windows vs Linux, Unix(macOS) 형태를 띔
# Windows는 프로세스 및 스레드 모델이 상당히 좋지 못함
# 그래서 대부분 서버를 운영하는 경우 Windows 서버를 사용한다 하면 '?' 때리는 경우가 많음

# 반면 Linux와 그의 형인 Unix는 유사한 메커니즘을 사용하고 있음
# 실질적으로 Windows 에서는 Process 배우베 Thread가 존재하는 것으로 표현함(똥)
# 반면 Linux, Unix의 경우엔 Process와 Thread를 모두 별개의 Task로 분류함
# 다만 차이가 있다면 Process는 그룹의 대장의 역할을 의미함
# 과거 S사가 휘황찬란했던 시절을 생각해보면 S사 하는 순간 떠오르는 인물이 있었음
# 그것이 S사는 Thread Group ID에 해당하며 S사 회장은 Process에 해당함
# S사의 모든 직원들과 자기 자신의 Process가 있지만 소속은 S사였음
# 그러므로 Thread Group ID는 동일하되 Process ID가 다른 형태임
# 이것은 AWS에서도 살펴볼 수 있는 내용인데 우리는 Linux Instance 형태를 사용하고 있으므로
# ps 명령으로 이 내용의 일부를 살펴볼 수 있음
# ps -ef
# 깃 배쉬에서 확인 가능(서버로)

# 이 명령어를 입력 했을 때 나타나는 PID가 바로 Process ID이며
# 사람에게 있어서는 고유한 주민등록번호 같은 것임
# (근데 바이두라는 중국 구글 같은 사이트에 가서 한국인 주민등록번호 검색하면
# 이름이랑 주민등록번호 리스트가 스크롤 끝도 없이 검색되서 나오는 것은 덤)

# 부가적으로 ps -ef에서 TTY에 '?'로 나오는 것은 데몬 프로세스라고 부름
# 실질적으로 서비스 구동되는 애들은 전부 '?'로 표기됨
# 대표적으로 우리가 사용하는 nginix 서버도 '?'로 표기되는 것을 볼 수 있음
# 또한 java 명령을 통해서 jar 파일을 실행하여 구동되는 서비스 또한 '?'로 표기되는 것을 볼 수 있음
# 마찬가지로 docker 또한 서비스로 구동되고 있으므로 '?'로 표기됨

# ps -eLf | grep docker 라고 입력하면 docker 관련 thread 정보도 확보가 가능함
# 입력한 결과 아래와 같은 것들을 볼 수 있음
# 첫 번째 라인에서 같은 PID를 가지고 있는 13개의 결과를 확인할 수 있음
# 이들은 모두 같은 PID를 가지고 구동되는 Thread라 보면 됨
# 아래가 뭔지는 쌤꺼 보면됨

# Linux Kernel 상 tgid를 사용한다는 부분
# https://elixir.bootlin.com/linux/latest/source/include/linux/sched.h#L962

# 근본적으로 Thread를 사용하는 이유가 무엇인가?
# - 작업을 병렬처리한다
# - 동시 처리를 하고 싶어서

# 사람들도 5인분의 일을 하게 하면 도망감
# 컴퓨터 세계에서도 마찬가지 예전 90년대에 cpu가 녹아버릴 정도(발열, 탱크 소리)
# 지금은 cpu를 다발로 쓰도록 알아서 분산시켜 주는 엔지니어들이 돌고 있음(axios같은 - 비동기 처리)
# thread는 다 비동기 처리
# 처리하지 못하고 제끼는 것에 보장하기 위해 async-await를 걸어줬던 것과 같음
# 그런데 여기서도 문제가 발생

# CPU는 오로지 한 순간에 한 가지 일을 합니다
# 실제로는 정말 한 가지를 하는데 아주 빠른 속도로 Multi-Tasking을 하는 것 뿐입니다
# 컴퓨터는 요즘 나오는 것들 최소 2 ~ 3GHz
# f = 1 / T -> T = 1 / f
# GHz = 10^9 Hz
# 현재 구동되는 가장 똥컴도 최소 1초에 최소 프로그램 명령 자체를 20억번 실행 할 수 있다는 뜻

# Hz(헤르츠)
# 헤르츠의 정의는? 주파수, 진동수 -> 1초에 몇 번 진동하는지의 척도
# 3GHz면 이 컴퓨터의 CPU는 1초에 30억번 진동한다는 뜻
# = 1초에 30억 개의 명령을 처리할 수 있다는 뜻

# 작업관리자를 보면 앱 + 백그라운드 프로세스 까지 내꺼는 65개가 돌고 있음
# 실제로 CPU가 이 모든 동작들을 실행하는데 하나 실행하는데 0.03초 걸리고 바로 다음꺼 실행하고 하는 것

# 예로 프로그램 1당 0.001초를 할당해준다고 가정합시다.
# 10^6 = 1000000(백만개)의 명령을 처리할 수 있습니다
# 실제 운영체제 과목에서는 이렇게 모두에게 동일하게 0.001초씩 할당하는 방식을 Round Robin이라고 부릅니다
# 보다 더 중요한 사항(우선순위)에 시간을 좀 더 할당해줌
# 예로 가장 중요한 것은 0.002초 사용, 별로 중요하지 않은 것은 0.0005초 형태로 구별함
# 우선순위에 따라 이 사이의 숫자값이 적절하게 조정됨

# Context Switching(컨텍스트 스위칭)
# 만약 0.001초가 지나갔는데도 프로그램이 끝나지 않았다면?
# 여러 프로그램이 동시에 돌고 있는 상황입니다
# 그런데 zoom이나 게임 같은 경우에는 지속적으로 켜져서 동작해야 합니다
# 그런데 우리는 네트워크 이슈 등이 없다면 끊김 없이 동작하는 것을 볼 수 있습니다
# 그리고 서로 다른 프로그램들이 순차적으로 실행되지만
# 기존 프로그램에게 제어권이 넘어왔을 때도 여전히 잘 동작하는 것을 볼 수 있습니다
# 왜 그럴까요? 에 대한 해답이 바로 Context Switching에 해당합니다

# CPU가 Task를 바꿔가며 실행하는거래
# 현재 진행하고 있는 Task(Process, Thread)의 상태를 저장하고 -> 레지스터 정보값을 저장한다는 것
# 다음 진행할 Task의 상태값을 읽어 적용하는 과정

# 아래와 같은 상황을 생각해봅시다
# A Thread는 아래와 같은 작업을 합니다
#
# mov 3, eax -> 숫자 3 eax 레지스터에 넣기
# add eax, ebx -> eax 레지스터와 ebs 레지스터 더해서 ebx 레지스터 갱신하기
# add ecx, eax -> 이하 동문(ecx 레지스터와 ebs 레지스터 더해서 eax 레지스터 갱신하기)

# B Thread는 아래와 같습니다
#
# mov 7, eax
# mov ecx, 15
# add ecx, eax

# mov 3, eax를 하다가 제어권이 mov 7, eax로 넘어갈 수 있음
# 그런데 거기서 제어권이 또 A의 add eax, ebx로 넘어가면? eax는 7인 상태로 조짐
# 어떻게 해결해야 할까?
# stack에 레지스터 정보값을 저장하고 제어권이 돌아올 때 저장된 정보값 줘 함

# mov 3, eax으로 stack에 저장하고 mov 7, eax도 stack에 저장
# stack은 각각 달라서 문제가 없어짐

# 하드웨어 자원은 물리적 제약 사항으로
# 어쩔 수 없이 모든 프로세스들이 공유해서 사용하게 됩니다
# 또한 프로세스들은 주어진 시간 동안 동작을 하다가 제어권을 뺏겨 다른 프로세스가 동작하게 됩니다
# 그러다보니 위와 같이 eax 및 ecx를 공유해서 사용하다가 잘못된 값을 가지고 계산할 수 있습니다
# 이것을 방지하기 위한 개념으로 사용되는 것이 Context Switching 입니다
# 하드웨어 레지스터 정보를 메모리인 스택에 저장한다는 것이 주된 관점
# 그럼 이것은 과연 좋을까?

# Context Switching을 많이 하게 되면 비용이 많이 들게 된다
# 그리고 응답속도도 줄어들 수 있음 (메모리계층, 레지스터로 올라올수록 용량은 적고 속도는 빨라짐)
# Context Switching은 메모리 계층 구조상
# 레지스터 -> 메모리, 메모리 -> 레지스터 연산이므로 성능상 좋지는 못함
# 그럼에도 불구하고 데이터 무결성을 보장하기 위해 반드시 필요함 (CPU레벨에서 무결성 보장)
# 즉 Context Switching으로 CPU 레벨에서는 무결성이 보장되는 것
# 프로그래머가 코드를 어떻게 작성하느냐에 따라서도 어느정도는 조정할 수 있는 요소임
# (또 다른 무결성 문제가 있음)

# 결론적으로 이런 문제가 발생하는 영역은 전부 어디인가요?
# 근본적으로 이런 문제들이 발생하는 이유는 자원이 공유되기 때문

# perform.process()에서 문제가 발생하는 이유는 money가 공유되기 때문
# 따라서 무결성을 보장할 수 있는 메커니즘이 필요


class ThreadPool(object):
    def __init__(self):
        super(ThreadPool, self).__init__()
        self.__active = []
        self.__lock = threading.Lock()


    def make_active(self, name):
        with self.__lock:
            self.__active.append(name)

            time.sleep(5)
            logging.debug('Running: %s', self.__active)

    def make_inactive(self, name):
        with self.__lock:
            self.__active.remove(name)
            logging.debug(('Running: %s', self.__active))


def thread_test_function(semaphore, pool):
    logging.debug('풀에 조인하기까지 대기중')

    with semaphore:
        name = threading.currentThread().getName()
        pool.make_active(name)
        time.sleep(1)
        pool.make_inactive(name)


import multiprocessing as mp
# multiprocessing은 파이썬에서 멀티프로세싱을 구현하기 위한 모듈
# 스레드와 마찬가지로 병렬 처리를 가능하게 함

def withdraw(money):
    for _ in range(20000):
        money.value -= 1
        # -20000

def deposit(money):
    for _ in range(20000):
        money.value += 1
        # +20000

def perform_process():
    # mp(multiprocessing으로 만든 값은 여러 프로세스가 공유해서 사용 가능)
    money = mp.Value('i', 20000)

    p1 = mp.Process(target=withdraw, args=(money, ))
    p2 = mp.Process(target=deposit, args=(money, ))
    # p1이 빼려고 하는 순간
    # p2가 들어가서 더하고
    # 혹은
    # p2가 더하려고 하는 순간
    # p1이 들어가서 빼면서 값이 꼬임

    # p1
    # A1. mov money, eax
    # A2. add 1, eax
    # A3. mov eax, money

    # p2
    # B1. mov money, eax
    # B2. sub 1, eax
    # B3. mov eax, money

    # 시나리오
    # A1이 실행되고 제어권이 넘어가서 B1 ~ B3이 실행됨
    # 이후 다시 제어권이 넘어가서 A2부터 시작함

    # money = 20000
    # mov money, eax로 인해 eax에 20000이 저장됨
    # 제어권이 넘어가면서 stack에 p1 프로세스의 하드웨어 레지스터(eax) 정보가 저장됨

    # B1을 진행하면서 역시 eax에는 20000이 저장됨
    # B2를 진행하면서 eax값은 19999가 되었음
    # B3을 진행하면서 money에 19999를 저장함
    # 제어권이 넘어가면서 stack에 p2 프로세스의  하드웨어 레지스터(eax) 정보가 저장됨

    # 다시 제어권이 넘어오면서 p1의 정보를 복원하여 eax는 20000인 상태
    # A2를 진행하면서 eax의 값은 20001이 되었음
    # A3을 진행하면서 money 값은 20001이 되어버림
    # p2에서 진행했던 뺄셈이 씹힘

    # => 실행을 보장해줘야함 = 데이터 무결성을 보장
    # 뺄셈 혹은 덧셈이 끝날 때까진 아무것도 하지마!
    # 이것의 다른 표현이 바로 Lock()입니다 [ 락 ]

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print("최종 결과 = {}".format(money.value))


def withdraw_lock(money, lock):
    for _ in range(200000):
        lock.acquire()
        money.value -= 1
        lock.release()

def deposit_lock(money, lock):
    for _ in range(200000):
        lock.acquire()
        money.value += 1
        lock.release()

# withdraw와 deposit을 200000으로 늘리면 속도가 상당히 느려짐
# 연산마다 lock을 거니까 매순간 Context Switching이 발생

def perform_process_lock():

    lock = mp.Lock()

    money = mp.Value('i', 20000)

    p1 = mp.Process(target=withdraw_lock, args=(money, lock))
    p2 = mp.Process(target=deposit_lock, args=(money, lock))

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print("최종 결과 = {}".format(money.value))


def advanced_withdraw(money, lock):
    lock.acquire()

    for _ in range(200000):
        money.value -= 1

    lock.release()

def advanced_deposit(money, lock):
    lock.acquire()

    for _ in range(200000):
        money.value += 1

    lock.release()
    # lock을 어디에 걸어주냐에 따라 결과가 달라질 수 있다
    # 시스템 관련사항 - 스레드 검색해서 이슈 확인해볼 것

def advanced_perform_process():
    lock = mp.Lock()
    # mp.Lock() 메서드를 이용하여 lock객체 생성

    money = mp.Value('i', 20000)
    # money까지 200000으로 늘리면 더더 느려짐
    # mp.Value 메서드를 사용하여 (i는 integer로) 정수형 변수 money를 생성하고 초기값으로 20000을 부여

    p1 = mp.Process(target=advanced_withdraw, args=(money, lock,))
    p2 = mp.Process(target=advanced_deposit, args=(money, lock,))
    # mp.Process 메서드를 사용하여 advanced_withdraw, advanced_deposit를
    # 각각 프로세스로 실행, 이때 money와 lock 변수를 인자로 전달

    p1.start()
    p2.start()

    p1.join()
    p2.join()
    # join: 각각의 프로세스가 종료되기를 기다리기

    print("최종 결과 = {}".format(money.value))


def thread_test_sequence():
    # pool = ThreadPool()
    # semaphore = threading.Semaphore(3)
    #
    # for i in range(10):
    #     thread = threading.Thread(target=thread_test_function,
    #                          name='thread_' + str(i),
    #                          args=(semaphore, pool))
    #
    #     thread.start()

    # for _ in range(10):
    #     perform_process()
        # 출력 결과는 20000이라고 예상했지만 10개의 결과 각각 다르게 나옴
        # 20000 이상도 있고 20000 이하도 있음
        # 이런 문제가 발생한 주원인은?

        # 여러 Process들이 CPU를 얻기 위해 싸움
        # 이 싸우는 상황을 중재해주는데 운영체제
        # 중재하고 나면 무슨 문제가 남아있냐
        # 뭐 한정적 자원 머시기... 치고박고 싸운대

    # for _ in range(10):
    #     perform_process_lock()
        # lock을 거니 20000만 10번 출력 완료!

        # 근데 여기에도 문제가 있음
        # 속도. 숫자를 늘리면 느려지는 문제
        # Context Switching이 너무 빈번해짐 -> 메모리 연산임. 여기서는 레지스터 연산이 필요
        # 그래서 Context Switching을 최소화 시켜줘야 함

    # for _ in range(10):
        advanced_perform_process()
        # 그렇게 빠른 것 같지는 않으나 이전보다는 빨라짐


