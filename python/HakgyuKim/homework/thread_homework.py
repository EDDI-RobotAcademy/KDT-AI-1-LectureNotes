import time
import logging
import multiprocessing as mp


def add_3(number, lock):
    start = 0
    while start < 60:
        time.sleep(3)
        lock.acquire()
        number.value += 3
        logging.debug(number)
        lock.release()
        start += 3

def add_5(number, lock):
    start = 0
    while start < 60:
        time.sleep(5)
        lock.acquire()
        number.value += 5
        logging.debug(number)
        lock.release()
        start += 5

def add_6(number, lock):
    start = 0
    while start < 60:
        time.sleep(6)
        lock.acquire()
        number.value += 6
        logging.debug(number)
        lock.release()
        start += 6

def homework():
    lock = mp.Lock()
    number = mp.Value('i', 0)

    p1 = mp.Process(target=add_3, args=(number, lock, ))
    p2 = mp.Process(target=add_5, args=(number, lock, ))
    p3 = mp.Process(target=add_6, args=(number, lock, ))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()

    print("최종 결과 = {}".format(number.value))