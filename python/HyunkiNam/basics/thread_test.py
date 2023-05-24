import logging
import threading
import time

logging.basicConfig(level=logging.DEBUG,
                    format='(%(threadName)-8s) %(message)s', )


# 프로세스(Process)와 스레드(Thread)
# OS 마다 Process 및 Memory 관리 메커니즘이 상이하여 일부 차이점이 존재함
# 대표적으로 Windows vs Linux, Unix(macOS) 형태를 띔
# Windows는 프로세스 및 스레드 모델이 상당히 좋지 못함
# 그래서 대부분 서버를 운영하는 경우 Windows 서버를 사용한다 하면 '?' 때리는 경우가 많음

# 반면 Linux와 그의 형인 Unix는 유사한 메커니즘을 사용하고 있음
# 실질적으로 Windows에서는 Process 내부에 Thread가 존재하는 것으로 표현함(똥)
# 반면 Linux, Unix의 경우엔 Process와 Thread를 모두 별개의 Task로 분류함
# 다만 차이가 있다면 Process는 그룹 대장의 역할을 의미함
# 과거 S사가 휘황찬란했던 시절을 생각해보면 S사 하는 순간 떠오르는 인물이 있었음
# 그것이 S사는 Thread Group ID에 해당하며 S사 회장은 Process에 해당함
# S사의 모든 직원들고 자기 자신의 Process가 있지만 소속은 S사였음
# 그러므로 Thread Group ID는 동일하되 Process ID가 다른 형태임
# 이것은 AWS에서도 살펴볼 수 있는 내용인데
# 우리는 Linux Instance를 사용하고 있으므로
# ps 명령으로 이 내용의 일부를 살펴볼 수 있음
# ps -ef

# 이 명령어를 입력 했을 때 나타나는 PID가 바로 Process ID이며
# 사람에게 있어서는 고유한 주민등록번호 같은 것임
# (근데 바이두라는 중국 구글 같은 사이트에 가서 한국인 주민등록번호 검색하면
# 이름이랑 주민등록번호 리스트가 스크롤 끝도없이 검색되서 나오는 것은 덤 ㅋㅋㅋㅋ)

# 부가적으로 ps -ef에서 TTY에 '?'로 나오는 것은 데몬 프로세스라고 부름
# 실질적으로 서비스 구동되는 애들은 전부 '?'로 표기됨
# 대표적으로 우리가 사용하는 nginx 서버도 '?'로 표기되는 것을 볼 수 있음
# 또한 java 명령을 통해서 jar 파일을 실행하여 구동되는 서비스 또한 '?'로 표기되는 것을 볼 수 있음
# 마찬가지로 docker 또한 서비스로 구동되고 있으므로 '?'로 표기됨

# ps -eLf | grep docker 라고 입력하면 docker 관련 thread 정보 확인이 가능함
# 입력한 결과 아래와 같은 것들을 볼 수 있음
# 첫 번째 라인에서 같은 PID를 가지고 있는 13개의 결과를 호가인 할 수 있음
# 이들은 모두 같은 PID를 가지고 구동되는 Thread라 보면 됨
# root       30553       1   30553  0   13 Apr24 ?        00:00:00 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   30554  0   13 Apr24 ?        00:02:37 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   30555  0   13 Apr24 ?        00:02:26 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   30556  0   13 Apr24 ?        00:00:21 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   30557  0   13 Apr24 ?        00:00:34 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   30558  0   13 Apr24 ?        00:00:00 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   30559  0   13 Apr24 ?        00:00:50 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   30683  0   13 Apr24 ?        00:00:10 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   32712  0   13 Apr24 ?        00:01:56 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   32718  0   13 Apr24 ?        00:00:31 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   32719  0   13 Apr24 ?        00:00:04 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   34202  0   13 Apr24 ?        00:01:34 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root       30553       1   89355  0   13 Apr25 ?        00:02:01 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock --default-ulimit nofile=32768:65536
# root      684454   30553  684454  0    7 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684454   30553  684455  0    7 May04 ?        00:00:01 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684454   30553  684456  0    7 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684454   30553  684457  0    7 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684454   30553  684458  0    7 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684454   30553  684459  0    7 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684454   30553  684461  0    7 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684460  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684462  0    8 May04 ?        00:00:01 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684463  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684464  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684465  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684466  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684467  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684460   30553  684468  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 3306 -container-ip 172.24.0.2 -container-port 3306
# root      684570   30553  684570  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684570   30553  684571  0    8 May04 ?        00:00:01 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684570   30553  684572  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684570   30553  684573  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684570   30553  684574  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684570   30553  684575  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684570   30553  684577  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684570   30553  684581  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684576  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684578  0    8 May04 ?        00:00:01 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684579  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684580  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684582  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684583  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684584  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root      684576   30553  684585  0    8 May04 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 7777 -container-ip 172.24.0.3 -container-port 7777
# root     1318740   30553 1318740  0    7 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318740   30553 1318747  0    7 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318740   30553 1318748  0    7 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318740   30553 1318749  0    7 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318740   30553 1318750  0    7 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318740   30553 1318751  0    7 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318740   30553 1318753  0    7 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318752   30553 1318752  0    6 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318752   30553 1318754  0    6 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318752   30553 1318755  0    6 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318752   30553 1318756  0    6 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318752   30553 1318757  0    6 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 80 -container-ip 172.26.0.2 -container-port 80
# root     1318752   30553 1318758  0    6 May19 ?        00:00:00 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 80 -container-ip 172.26.0.2 -container-port 80

# Linux Kernel 상 tgid를 사용한다는 부분
# https://elixir.bootlin.com/linux/latest/source/include/linux/sched.h#L962

# 근본적으로 Thread를 사용하는 이유가 무엇인가 ?
# - 작업을 병렬처리한다
# - 동시 처리를 하고 싶어서

# CPU는 오로지 한 순간에 한 가지 일을 합니다.
# 실제로는 정말 한 가지를 하는데 아주 빠른 속도로 Multi-Tasking을 하는 것 뿐입니다.
# 컴퓨터는 요즘 나오는 것들 최소 2 ~ 3GHz
# f = 1 / T -> T = 1 / f
# GHz = 10^9 Hz
# 현재 구동되는 가장 똥컴도 1초에 최소 20억번 연산을 할 수 있다는 뜻
# 예로 프로그램 1개당 0.001초를 할당해준다고 가정합시다.
# 10^6 = 1000000(백만개)의 명령을 처리할 수 있습니다.
# 실제 운영체제 과목에서는 이렇게 모두에게 동일하게 0.001초씩 할당하는 방식을 Round Robin이라고 부릅니다.
# 보다 더 중요한 사항(우선순위)에 시간을 좀 더 할당해줌
# 예로 가장 중요한 것은 0.002초 사용, 별로 중요하지 않은 것은 0.0005초 형태로 구별함
# 우선순위에 따라 이 사이의 숫자값이 적절하게 조정됨

# Context Switching(컨텍스트 스위칭)
# 여러 프로그램이 동시에 돌고 있는 상황입니다.
# 그런데 zoom이나 게임 같은 경우에는 지속적으로 켜져서 동작해야 합니다.
# 그런데 우리는 네트워크 이슈 등이 없다면 끊김 없이 동작하는 것을 볼 수 있습니다.
# 그리고 서로 다른 프로그램들이 순차적으로 실행되지만
# 기존 프로그램에게 제어권이 넘어왔을 때도 여전히 잘 동작하는 것을 볼 수 있습니다.
# 왜 그럴까요 ? 에 대한 해답이 바로 Context Switching에 해당합니다.

# 아래와 같은 상황을 생각해봅시다.
# A Thread는 아래와 같은 작업을 합니다.
#
# mov 3, eax -> 숫자 3 eax 레지스터에 넣기
# add eax, ebx -> eax 레지스터와 ebx 레지스터 더해서 ebx 레지스터 갱신하기
# add ecx, eax -> 이하 동문(ecx 레지스터와 eax 레지스터 더해서 eax 레지스터 갱신하기)

# B Thread는 아래와 같습니다.
#
# mov 7, eax
# mov ecx, 15
# add ecx, eax

# 하드웨어 자원은 물리적 제약 사항으로
# 어쩔 수 없이 모든 프로세스들이 공유해서 사용하게 됩니다.
# 또한 프로세스들은 주어진 시간동안 동작을 하다가 제어권을 뺏겨 다른 프로세스가 동작하게 됩니다.
# 그러다보니 위와 같이 eax 및 ecx를 공유해서 사용하다가 잘못된 값을 가지고 계산할 수 있습니다.
# 이것을 방지하기 위한 개념으로 사용되는 것이 Context Switching 입니다.
# 하드웨어 레지스터 정보를 메모리인 스택에 저장한다는 것이 주된 관점
# 그럼 이것은 과연 좋을까 ?
# Context Switching은 메모리 계층 구조상
# 레지스터 -> 메모리, 메모리 -> 레지스터 연산이므로 성능상 좋지는 못함
# 그럼에도 불구하고 데이터 무결성을 보장하기 위해 반드시 필요함
# 프로그래머가 코드를 어떻게 작성하느냐에 따라서도 어느정도는 조정할 수 있는 요소임

# 결론적으로 이런 문제가 발생하는 영역은 전부 어디인가요 ?
# 공유되는 자원들

class ThreadPool(object):
    def __init__(self):
        super(ThreadPool, self).__init__()
        self.__active = []
        self.__lock = threading.Lock()

    def make_active(self, name):
        with self.__lock:
            self.__active.append(name)

            time.sleep(3)
            logging.debug('Running: %s', self.__active)

    def make_inactive(self, name):
        with self.__lock:
            self.__active.remove(name)
            logging.debug('Running: %s', self.__active)


def thread_test_function(semaphore, pool):
    logging.debug('풀에 조인하기까지 대기중')

    with semaphore:
        name = threading.currentThread().getName()
        pool.make_active(name)
        time.sleep(1)
        pool.make_inactive(name)


import multiprocessing as mp


def withdraw(money):
    for _ in range(20000):
        money.value -= 1


def deposit(money):
    for _ in range(20000):
        money.value += 1


def perform_process():
    # mp(multiprocessing으로 만든 값은 여러 프로세스가 공유해서 사용 가능)
    money = mp.Value('i', 20000)

    p1 = mp.Process(target=withdraw, args=(money,))
    p2 = mp.Process(target=deposit, args=(money,))
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
    # A1이 실행되고 제어권이 넘어가서 B1 ~ B3가 실행됨
    # 이후 다시 제어권이 넘어가서 A2부터 시작함

    # money = 20000
    # mov money, eax로 인해 eax에 20000이 저장됨
    # 제어권이 넘어가면서 stack에 p1 프로세스의 하드웨어 레지스터(eax) 정보가 저장됨

    # B1을 진행하면서 역시 eax에는 20000이 저장됨
    # B2를 진행하면서 eax값은 19999가 되었음
    # B3를 진행하면서 money에 19999를 저장함
    # 제어권이 넘어가면서 stack에 p2 프로세스의 하드웨어 레지스터(eax) 정보가 저장됨

    # 다시 제어권이 넘어오면서 p1의 정보를 복원하여 eax는 20000인 상태
    # A2를 진행하면서 eax값은 20001이 되었음
    # A3를 진행하면서 money 값은 20001이 되어버림
    # p2에서 진행했던 뺄셈이 씹힘

    # 뺄셈 혹은 덧셈이 끝날 때까진 아무것도 하지마!
    # 이것의 다른 표현이 바로 Lock() 입니다. [ 락 ]

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


def perform_process_lock():
    lock = mp.Lock()

    money = mp.Value('i', 20000)

    p1 = mp.Process(target=withdraw_lock, args=(money, lock,))
    p2 = mp.Process(target=deposit_lock, args=(money, lock,))

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


def advanced_perform_process():
    lock = mp.Lock()

    money = mp.Value('i', 20000)

    p1 = mp.Process(target=advanced_withdraw, args=(money, lock,))
    p2 = mp.Process(target=advanced_deposit, args=(money, lock,))

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print("최종 결과 = {}".format(money.value))


def thread_test_sequence():
    # pool = ThreadPool()
    # semaphore = threading.Semaphore(3)
    #
    # for i in range(10):
    #     thread = threading.Thread(target=thread_test_function,
    #                               name='thread_' + str(i),
    #                               args=(semaphore, pool))
    #     thread.start()
    #

    # for _ in range(10):
    #     perform_process()

    # for _ in range(10):
    #     perform_process_lock()

    for _ in range(10):
        advanced_perform_process()