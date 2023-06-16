import logging
import threading
import time

logging.basicConfig(level=logging.DEBUG,
                    format='(%(threadName)-8s) %(message)s', )

number = 0
def thread1():
    global number
    number += 3
    time.sleep(3)

def thread2():
    global number
    number += 5
    time.sleep(5)

def thread3():
    global number
    number += 6
    time.sleep(6)

def thread_test1():
    thread_1 = threading.Thread(target=thread1, args=())
    thread_2 = threading.Thread(target=thread2, args=())
    thread_3 = threading.Thread(target=thread3, args=())
    thread_1.start()
    thread_2.start()
    thread_3.start()

def thread_test2():
    thread_test1()
    print("최종 결과 = {}".format(number))

if __name__ == '__main__':
    thread_test2()