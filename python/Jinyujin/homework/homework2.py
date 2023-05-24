def three_seconds(number, lock):
    lock.acquire()

    for _ in range(20):
        number.value += 3

    lock.release()

def five_seconds(number, lock):
    lock.acquire()

    for _ in range(12):
        number.value += 5

    lock.release()

def six_seconds(number, lock):
    lock.acquire()

    for _ in range(10):
        number.value += 6

    lock.release()

import multiprocessing as mp

def after_sixty_seconds():
    lock = mp.Lock()

    number = mp.Value('i', 0)
    # 여기서 'i'는 number 변수의 데이터 타입으로 integer를 의미
    # 오른쪽에 들어갈 숫자는 초기값

    p1 = mp.Process(target=three_seconds, args=(number, lock,))
    p2 = mp.Process(target=five_seconds, args=(number, lock,))
    p3 = mp.Process(target=six_seconds, args=(number, lock,))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()

    print("최종 결과 = {}".format(number.value))


def homework2():
    # for _ in range(10):
        after_sixty_seconds()