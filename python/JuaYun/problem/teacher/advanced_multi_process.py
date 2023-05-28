import multiprocessing as mp
import time

required_total_time = 6

def adv_process_shared_data(recv_number, total_time, consume_time):
    for _ in range(total_time, 1, -consume_time):
        recv_number.value += consume_time
        print(recv_number.value)
        time.sleep(consume_time)

def adv_three_times_process(first):
    adv_process_shared_data(first, required_total_time, 3)

def adv_five_times_process(second):
    adv_process_shared_data(second, required_total_time, 5)

def adv_six_times_process(third):
    adv_process_shared_data(third, required_total_time, 6)


def adv_parallel_process_problem():
    first = mp.Value('i', 0)
    second = mp.Value('i', 0)
    third = mp.Value('i', 0)

    p1 = mp.Process(target=adv_three_times_process, args=(first,))
    p2 = mp.Process(target=adv_five_times_process, args=(second,))
    p3 = mp.Process(target=adv_six_times_process, args=(third,))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()

    print("최종 결과 = {}".format(first.value + second.value + third.value))