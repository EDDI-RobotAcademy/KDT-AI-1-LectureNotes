import multiprocessing as mp
import time

required_total_time = 60


# lock없이!
def adv_process_shared_data(recv_number, total_time, consume_time):
    for _ in range(total_time, 1, -consume_time):
        # total_time으로 시작해서 1까지 consume_time만큼 감소하는 시퀀스를 반복한다(-붙으면 감소, 안붙으면 증가)
        # for (int i = total_time; i <= 1 ; i -= consume_time)
        # 이것과 같은 느낌
        recv_number.value += consume_time
        print(recv_number.value)
        time.sleep(consume_time)


def adv_three_times_process(first):
    adv_process_shared_data(first, required_total_time, 3)
    # 근데 왜 60까지 더하는거지? 계산을 이상하게 했나


def adv_five_times_process(second):
    adv_process_shared_data(second, required_total_time, 5)


def adv_six_times_process(third):
    adv_process_shared_data(third, required_total_time, 6)


def adv_parallel_process_problem():
    lock = mp.Lock()
    first = mp.Value('i', 0)
    # first 변수에 정수형 데이터 0을 할당한다
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


'''
    여기는 왜 lock이 필요하지 않은가?
    계산하는 구간을 나눠주고 너만 처리할게요 하면 되는 것
    
    advanced 전에는 number라는 공유변수를 사용
    advanced에서는 first/second/third로 변수를 따로 만들어줌
    
    즉, 100개의 데이터를 처리해야 할 때
    A - 25개
    B - 25개
    C - 25개
    D - 25개
    다 계산하고 합산

    8개 (1, 2, 3, 4, 5, 6, 7, 8)
    A - (1, 2) = 3
    B - (3, 4) = 7
    C - (5, 6) = 11
    D - (7, 8) = 15
    합은 36
    
    이것과 같은 개념
    
    그럼에도 lock이 필요한 경우가 있다 
    -> 복합적인 계산이 필요한 경우
    따라서 어떤 경우에 걸어야 하고 어떤 경우에는 안 걸어도 되는지 파악할 수 있어야 한다!
'''
