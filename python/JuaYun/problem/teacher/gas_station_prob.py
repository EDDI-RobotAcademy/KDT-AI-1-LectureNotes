import math
import random

def get_random_range(start, end):
    return random.randrange(0, 11), random.randrange(0, 11)

def calc_distance(current_location, target_locations):
    distances = []
    for station_idx in range(3):
        distances.append(
            math.sqrt(
                math.pow(current_location[0] - target_locations[station_idx][0], 2) +
                math.pow(current_location[1] - target_locations[station_idx][1], 2)))

    return distances

def gas_station_problem_solve():
    # 현재 좌표
    # 랜덤 주유소 좌표 3개
    # 최단 거리

    my_coordinate = get_random_range(0, 11)
    print(my_coordinate)
    # print(my_coordinate[0])
    # 내 위치

    gas_station_coordinate = []
    for _ in range(3):
        gas_station_coordinate.append(get_random_range(0, 11))

    print(gas_station_coordinate)
    # append 는 list 형태로 출력 [여기에 들어감]
    # 세 개의 주유소 위치

    distances = calc_distance(my_coordinate, gas_station_coordinate)
    print(distances)

    distances.sort()
    print('최단거리 =', distances[0])

