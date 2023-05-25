import random
from typing import Final

POSITIONMAX: Final = 10
POSITIONMIN: Final = -10

gasStations = []
print("position of gas station")


def getDistance(gasStations, myPosition):
    return ((gasStations[i][0] - myPosition[0]) ** 2 +
            (gasStations[i][1] - myPosition[1]) ** 2) ** (1 / 2)


def generateRandomPosition(min, max):
    return random.random() * (max - min) + min, random.random() * (max - min) + min


for i in range(3):
    gasStation = generateRandomPosition(POSITIONMIN, POSITIONMAX)
    gasStations.append(gasStation)
    print("gas station", i + 1, ": ", gasStation)
print()
print("my position: ")
myPosition = generateRandomPosition(POSITIONMIN, POSITIONMAX)
print(myPosition)
print()
print("distanct 2 gas station:")
minValue = 0
minIndex = 0
for i in range(3):
    distance2gasStation = getDistance(gasStations[i], myPosition)
    print("gas station", i + 1, ": ", distance2gasStation)
    if (minValue == 0):
        minValue = distance2gasStation
        minIndex = i
    if (minValue > distance2gasStation):
        minValue = distance2gasStation
        minIndex = i
print()
print("nearest gas station: ", minIndex + 1)
print("shrtest distance to gas station: ", minValue)
