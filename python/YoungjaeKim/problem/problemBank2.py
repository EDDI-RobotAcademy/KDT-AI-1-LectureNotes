import threading
import time
import multiprocessing as mp
import datetime
import logging

number = 0


def num_timer(time):
    global number

    print("===========================")
    print(datetime.datetime.now())
    print("===========================")

    timer = threading.Timer(time, num_plus)
    timer.start()

    print(number)

    number += time


def num_plus():
    global number

    p1 = mp.Process(target=num_timer(3), args=(number, ))
    p2 = mp.Process(target=num_timer(5), args=(number, ))

    p1.start()
    p2.start()

    p1.join()
    p2.join()
    # num_timer(3)
    # num_timer(5)
    # num_timer(6)
