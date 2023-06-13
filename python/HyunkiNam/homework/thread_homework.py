import time
import multiprocessing as mp


def thread_3(money, lock):
    start = time.time()

    while time.time() - start < 60:
        lock.acquire()
        money.value += 3
        lock.release()

        print("3 : {}".format(money.value))
        time.sleep(3)


def thread_5(money, lock):
    start = time.time()

    while time.time() - start < 60:
        lock.acquire()
        money.value += 5
        lock.release()

        print("5 : {}".format(money.value))
        time.sleep(5)


def thread_6(money, lock):
    start = time.time()

    while time.time() - start < 60:
        lock.acquire()
        money.value += 6
        lock.release()

        print("6 : {}".format(money.value))
        time.sleep(6)


def thread_60():
    lock = mp.Lock()
    money = mp.Value('i', 0)

    p1 = mp.Process(target=thread_3, args=(money, lock,))
    p2 = mp.Process(target=thread_5, args=(money, lock,))
    p3 = mp.Process(target=thread_6, args=(money, lock,))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()
    print("thread_60 최종 결과 = {}".format(money.value))


def thread_test(money, lock, increase):
    start = time.time()
    while time.time() - start < 60:
        lock.acquire()
        money.value += increase
        lock.release()

        print('{0} : {1}'.format(increase, money.value))
        time.sleep(increase)




def thread_60_2():
    lock = mp.Lock()
    money2 = mp.Value('i', 0)

    p4 = mp.Process(target=thread_test, args=(money2, lock, 3,))
    p5 = mp.Process(target=thread_test, args=(money2, lock, 5,))
    p6 = mp.Process(target=thread_test, args=(money2, lock, 6,))

    p4.start()
    p5.start()
    p6.start()

    p4.join()
    p5.join()
    p6.join()
    print("thread_60_2 최종 결과 = {}".format(money2.value))


def thread_homework():
    thread_60()
    thread_60_2()
