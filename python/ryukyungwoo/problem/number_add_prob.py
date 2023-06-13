import threading
import multiprocessing as mp
import time

lock = mp.Lock()

def every3s(number):

    number_time = 0

    for _ in range(60):

        if number_time < 60:

            lock.acquire()
            time.sleep(3)
            number.value += 3
            number_time += 3
            lock.release()

            print("진행 3s = {}".format(number.value))

def every5s(number):

    number_time = 0

    for _ in range(60):

        if number_time < 60:

            lock.acquire()
            time.sleep(5)
            number.value += 5
            number_time += 5
            lock.release()

            print("진행 5s = {}".format(number.value))
def every6s(number):

    number_time = 0

    for _ in range(60):

        if number_time < 60:

            lock.acquire()
            time.sleep(6)
            number.value += 6
            number_time += 6
            lock.release()

            print("진행 6s = {}".format(number.value))
def number_add_prob_process():


    number = mp.Value('i', 0)

    p3 = mp.Process(target=every3s, args=(number,))
    p5 = mp.Process(target=every5s, args=(number,))
    p6 = mp.Process(target=every6s, args=(number,))

    p3.start()
    p5.start()
    p6.start()

    p3.join()
    p5.join()
    p6.join()

    print("최종 결과 = {}".format(number.value))
