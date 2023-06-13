import random

# 현재 사용자가 있는 좌표를 랜덤으로 생성
# 주유소 좌표를 3곳을 생성합니다.
# 가장 가까운 주유소가 현재 위치로 부터 얼마나 떨어져 있는 지 확인합니다.

# 현재 사용자 좌표 : [3, 2]
# 주유소 좌표 3곳 : [[5, 3], [2, 7], [6, 5]] -> 리스트 형태로 리스트에 들어가기 ?

# (3, 2) 좌표와 가장 가까운 주유소는 (2, 7)이므로,
# (3, 2) - (2, 7) = 1 + 5 = (6칸)

# 다른 주유소들의 거리도 구해보자면
# (3, 2) - (5, 3) = 2 + 1 = (3칸)
# (3, 2) - (6, 5) = 3 + 3 = (6칸)

# 내가 푼 코드 (칸으로)
def gas_prob():
    gasStation = []
    for i in range(3):
        num = []
        for j in range(2):
            gas_station = random.randrange(0, 10)
            num.append(gas_station)
        gasStation.append(num)
    print("주유소 3곳의 위치: ", gasStation)

    humanStation = []
    for i in range(2):
        human_station = random.randrange(0, 10)
        humanStation.append(human_station)
    print("나의 위치: ", humanStation)

    print()

    min_distance = 999999999999999999
    for num in gasStation:
        x = num[0]
        y = num[1]
        print(x, y)

        # 나의 위치와 주유소 위치를 계산하고 싶어
        distance_x = abs(humanStation[0] - x)
        distance_y = abs(humanStation[1] - y)

        distance_res = distance_x + distance_y
        print("계산된 거리 :", distance_res)

        if distance_res < min_distance:
            min_distance = distance_res
    print(min_distance)


# 아래는 강사님 코드 (대각선)
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

