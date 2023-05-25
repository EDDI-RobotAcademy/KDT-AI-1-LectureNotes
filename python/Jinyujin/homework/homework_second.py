import multiprocessing as mp
import time
import logging


def three_seconds(number, lock):
    for _ in range(60 // 3):
        lock.acquire()
        number.value += 3

        logging.debug('3초마다: %s', number.value)

        lock.release()

        time.sleep(3)


def five_seconds(number, lock):
    for _ in range(60 // 5):
        lock.acquire()
        number.value += 5

        logging.debug('5초마다: %s', number.value)

        lock.release()

        time.sleep(5)


def six_seconds(number, lock):
    for _ in range(60 // 6):
        lock.acquire()
        number.value += 6

        logging.debug('6초마다: %s', number.value)

        lock.release()

        time.sleep(6)


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
