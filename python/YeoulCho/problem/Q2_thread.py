import logging
import time

def add3(number):
    for _ in range(20):
        number.value += 3
        time.sleep(3)
        logging.debug('Running1 : %s', number.value)

def add5(number):
    for _ in range(12):
        number.value += 5
        time.sleep(5)
        logging.debug('Running2 : %s', number.value)
def add6(number):
    for _ in range(10):
        number.value += 6
        time.sleep(6)
        logging.debug('Running3 : %s', number.value)

import multiprocessing as mp

def perform_add_process():
    number = mp.Value('i', 0)

    number1 = mp.Process(target=add3, args=(number,))
    number2 = mp.Process(target=add5, args=(number,))
    number3 = mp.Process(target=add6, args=(number,))

    number1.start()
    number2.start()
    number3.start()

    number1.join()
    number2.join()
    number3.join()

    print("최종 결과 = {}".format(number.value))

def add3_lock(number, lock):
    for _ in range(20):
        lock.acquire()
        number.value += 3
        logging.debug('Running1 : %s', number.value)
        lock.release()
        time.sleep(3)


def add5_lock(number, lock):

    for _ in range(12):
        lock.acquire()
        number.value += 5
        logging.debug('Running2 : %s', number.value)
        lock.release()
        time.sleep(5)


def add6_lock(number, lock):
    for _ in range(10):
        lock.acquire()
        number.value += 6
        logging.debug('Running3 : %s', number.value)
        lock.release()
        time.sleep(6)


def perform_add_process_lock():
    number = mp.Value('i', 0)
    lock = mp.Lock()

    number1 = mp.Process(target=add3_lock, args=(number, lock, ))
    number2 = mp.Process(target=add5_lock, args=(number, lock, ))
    number3 = mp.Process(target=add6_lock, args=(number, lock, ))

    number1.start()
    number2.start()
    number3.start()

    number1.join()
    number2.join()
    number3.join()

    print("최종 결과 = {}".format(number.value))
