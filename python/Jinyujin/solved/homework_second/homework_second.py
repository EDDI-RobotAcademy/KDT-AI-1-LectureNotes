"""
주아언니 while문도 가져와서 봐보기 - 직접 해보자!

지금까지 lock을 썼는데 계산할 때는 lock이 없어도 됨
왜?
계산하는 구간 나눠주고 계산할 때 너만 처리할게요 하면 된대

처음에는 number라는 공유변수 하나 만들어놨고 lcodk을 검
두번째꺼에는 공유변수 없이 fisrt/second/third로 분리시키고 lock을 안검
이거는 무슨 개념이냐면 # 100개의 데이터를 처리해야함의 개념

그럼에도 lock을 걸어야 하는 경우 - 복합적인 계산이 필요할 경우

그래서 어떤 경우에는 걸고 어떤 경우에는 안 걸어도 될지 적절하게 파악할 것
"""

import multiprocessing as mp
import time


def process_shared_data(number, total_time, consume_time):
    # len(list(range(60, 0, -3)))
    # 이렇게 하면 리스트 길이 반환(length같음)
    for _ in range(total_time, 1, -consume_time):
        # 이렇게 하면 total_time 에서 consume_time 한 만큼씩 줄어들음
        number.value += consume_time
        print(number.value)
        time.sleep(consume_time)

        # logging.debug 아니고 print를 써도됨
        # print를 어떤 것을 어떤 이유로 할 것인지 파악하는 연습하기
        # 쌤처럼 왜 이러는지 알기 위해 나중에 print(number.value)를 추가해준 것과 같은 연습!!!
        # 근데 logging.debug는 터미널에 출력이 안되는데 (빨간색으로 떠서 로그인걸 알 수 있는데)
        # print()는 터미널에 다 출력이 되어 버릴 수도..


def three_times_process(number, lock):
    lock.acquire()

    process_shared_data(number, 6, 3)

    lock.release()


def five_times_process(number, lock):
    lock.acquire()

    process_shared_data(number, 6, 5)

    lock.release()


def six_times_process(number, lock):
    lock.acquire()

    process_shared_data(number, 6, 6)

    lock.release()


def parallel_process_problem():
    lock = mp.Lock()

    number = mp.Value('i', 0)

    p1 = mp.Process(target=three_times_process, args=(number, lock,))
    p2 = mp.Process(target=five_times_process, args=(number, lock,))
    p3 = mp.Process(target=six_times_process, args=(number, lock,))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()

    print("최종 결과 = {}".format(number.value))
