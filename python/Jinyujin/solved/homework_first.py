import math
import random


def get_random_range(start, end):
    return random.randrange(0, 11), random.randrange(0, 11)
# def: 파이썬에서 함수 정의할 때 사용하는 키워드
# 자바의 customRandom처럼 활용하기 위해 만들어 준것 같음


def calc_distance(current_location, target_locations):
    distances = []
    # distances를 빈 배열로 초기화하고 뒤에 append를 이용해서 배열에 추가
    for station_idx in range(3):
        # 파이썬의 for문
        # for i range(얼마만큼 돌꺼니)
        distances.append(
            math.sqrt(
                math.pow(current_location[0] - target_locations[station_idx][0], 2) +
                math.pow(current_location[1] - target_locations[station_idx][1], 2)))
                # math.pow(x,y)함수는 x의 y거듭제곱(x의 y승)을 반환

    return distances


def gas_station_problem_solve():
    # 현재 좌표
    # 랜덤 주유소 좌표 3개
    # 최단 거리
    #myCoordinateX = random.randrange(0, 11)
    #myCoordinateY = random.randrange(0, 11)
    #print(myCoordinateX, myCoordinateY)

    my_coordinate = get_random_range(0, 11)
    print(my_coordinate)
    #print(my_coordinate[0])

    gas_station_coordinate = []
    for _ in range(3):
        gas_station_coordinate.append(get_random_range(0, 11))

    print(gas_station_coordinate)

    distances = calc_distance(my_coordinate, gas_station_coordinate)
    print(distances)

    distances.sort()
    print('최단거리 =', distances[0])
