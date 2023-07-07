import multiprocessing as mp
import time


def three_times_process(number, lock):
    lock.acquire()

    process_shared_data(number, 6, 3)

    lock.release()


def process_shared_data(number, total_time, consume_time):

    # len(list(range(60, 0, -3)))
    for _ in range(total_time, 1, -consume_time):
        number.value += consume_time
        print(number.value)
        time.sleep(consume_time)


def five_times_process(number, lock):
    lock.acquire()

    process_shared_data(number, 6, 5)

    lock.release()

def six_times_process(number, lock):
    lock.acquire()

    process_shared_data(number, 6, 6)

    lock.release()


def parallel_process_problem():
    lock = mp.Lock()

    number = mp.Value('i', 0)

    p1 = mp.Process(target=three_times_process, args=(number, lock,))
    p2 = mp.Process(target=five_times_process, args=(number, lock,))
    p3 = mp.Process(target=six_times_process, args=(number, lock,))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()

    print("최종 결과 = {}".format(number.value))