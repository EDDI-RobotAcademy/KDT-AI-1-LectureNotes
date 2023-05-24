import math
import random


def coordinate(num):
    distance, coordinates = [], []

    for _ in range(num):
        coordinates.append({random.randrange(100), random.randrange(100)})

    print("주유소의 좌표: ", coordinates)

    for x, y in coordinates:
        distance.append(math.sqrt((x ** 2) + (y ** 2)))

    print("각 주유소까지의 거리: ", distance)

    distance.sort()
    print("최단거리: ", distance[0])
