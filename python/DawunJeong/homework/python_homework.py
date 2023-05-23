import random
import math
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