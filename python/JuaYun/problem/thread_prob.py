# 3초마다 데이터를 처리하는 스레드가 존재합니다.
# 이 스레드는 number 변수에 값을 3씩 더합니다.
import time
import multiprocessing as mp

def add_three(number, lock):
    start_time = time.time()

    while time.time() - start_time < 60:
        lock.acquire()

        number.value += 3
        print("3더하기:",number.value)
        lock.release()
        time.sleep(3)

def add_five(number, lock):
    start_time = time.time()

    while time.time() - start_time < 60:
        lock.acquire()

        number.value += 5
        print("5더하기:",number.value)
        lock.release()
        time.sleep(5)

def add_six(number, lock):
    start_time = time.time()

    while time.time() - start_time < 60:
        lock.acquire()

        number.value += 6
        print("6더하기:",number.value)
        lock.release()
        time.sleep(6)

def perform_process():
    lock = mp.Lock()

    number = mp.Value('i', 0)

    p1 = mp.Process(target=add_three, args=(number, lock))
    p2 = mp.Process(target=add_five, args=(number, lock))
    p3 = mp.Process(target=add_six, args=(number, lock))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()

    print("결과 = {}".format(number.value))

def All_add_process():

    perform_process()