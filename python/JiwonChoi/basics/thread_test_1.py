import logging
import threading
import time
logging.basicConfig(level=logging.DEBUG,
                    format='(%(threadName)-8s) %(message)s',)
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

    p1 = mp.Process(target=withdraw, args=(money, ))
    p2 = mp.Process(target=deposit, args=(money, ))
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


def thread_test_sequence_lock():
    for _ in range(10):
        perform_process_lock()

def thread_test_sequence():
    for _ in range(10):
        perform_process()

if __name__ == '__main__':
    #thread_test_sequence_lock()
    thread_test_sequence()