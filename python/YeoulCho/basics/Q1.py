# 주유소 좌표 3개 랜덤, 내 위치 랜덤
# 최단거리의 주유소는 현재 위치로 부터 얼마나 떨어져 있는지?
import math
import random

def radomLocation(Min,Max):
    location = random.randrange(Min,Max)
    return location

def distance_calculation(A,B):
    distanceX=math.pow((A[0]-B[0]),2)+math.pow((A[1]-B[1]),2)
    return distanceX

myLocation = [radomLocation(1,10), radomLocation(1,10)]
gas1Location = [radomLocation(1,10), radomLocation(1,10)]
gas2Location = [radomLocation(1,10), radomLocation(1,10)]
gas3Location = [radomLocation(1,10), radomLocation(1,10)]

print("myLocation: ", myLocation)
print("gas1Location: ", gas1Location)
print("gas2Location: ", gas2Location)
print("gas3Location: ", gas3Location)

gas1Distance = distance_calculation(myLocation,gas1Location) ** 1/2
gas2Distance = distance_calculation(myLocation,gas2Location) ** 1/2
gas3Distance = distance_calculation(myLocation,gas3Location) ** 1/2

print("gas1Distance: ", gas1Distance)
print("gas2Distance: ", gas2Distance)
print("gas3Distance: ", gas3Distance)
Distance = [gas1Distance, gas2Distance, gas3Distance]


print(Distance)
Distance.sort()
print("nearGasStation: ", Distance[0])