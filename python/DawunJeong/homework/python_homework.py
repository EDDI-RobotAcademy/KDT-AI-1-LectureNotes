import random
import math
import time
import logging

logging.basicConfig(level=logging.DEBUG,
                    format='(%(threadName)-8s) %(message)s', )


def generateCoordinate():
    coordinate_x = random.randrange(1, 10)
    coordinate_y = random.randrange(1, 10)

    coordinateList = [coordinate_x, coordinate_y]

    print(coordinateList)

    return coordinateList


def calculate_xy(gasStation_coordinate, my_coordinate):
    dx = gasStation_coordinate[0] - my_coordinate[0]
    dy = gasStation_coordinate[1] - my_coordinate[1]

    straight = math.sqrt(dx ** 2 + dy ** 2)

    return straight


def homework_problem1():
    gasStationList = [generateCoordinate() for _ in range(3)]
    my_coordinate = generateCoordinate()

    distanceList = []
    distanceList.append(calculate_xy(gasStationList[0], my_coordinate))
    distanceList.append(calculate_xy(gasStationList[1], my_coordinate))
    distanceList.append(calculate_xy(gasStationList[2], my_coordinate))

    distanceList.sort()
    print(distanceList)

    print(min(distanceList))

    return distanceList


import multiprocessing as mp


def advanced_add3(num, lock):
    start = 0
    for _ in range(1000):
        if start >= 60:
            break
        num.value += 3
        time.sleep(3)
        start += 3
        logging.debug('Running1')


def advanced_add5(num, lock):
    start = 0
    for _ in range(1000):
        if start >= 60:
            break
        num.value += 5
        time.sleep(5)
        start += 5
        logging.debug('Running2')


def advanced_add6(num, lock):
    start = 0
    for _ in range(1000):
        if start >= 60:
            break
        num.value += 6
        time.sleep(6)
        start += 6
        logging.debug('Running3')


def advanced_add_process():
    lock = mp.Lock()

    num = mp.Value('i', 0)

    p1 = mp.Process(target=advanced_add3, args=(num, lock,))
    p2 = mp.Process(target=advanced_add5, args=(num, lock,))
    p3 = mp.Process(target=advanced_add6, args=(num, lock,))

    p1.start()
    p2.start()
    p3.start()

    p1.join()
    p2.join()
    p3.join()

    print("1분 후 결과 = {}".format(num.value))


def homework_test_sequence():
    advanced_add_process()
