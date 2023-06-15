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


def thread_test_sequence():
    pool = ThreadPool()
    semaphore = threading.Semaphore(3)

    for i in range(10):
        thread = threading.Thread(target=thread_test_function,
                                  name='thread_' + str(i),
                                  args=(semaphore, pool))
        thread.start()

if __name__ == '__main__':
    thread_test_sequence()
