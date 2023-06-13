# python 문제 은행 [ 1 ]
# 주유소 문제를 python 버전으로 확장해 보겠습니다.
# 현재 사용자가 있는 좌표를 랜덤으로 생성합니다.
# 주유소 좌표를 랜덤으로 3개 정도 만듭니다.
# 최단 거리의 주유소는 현재 위치로부터 얼마나 떨어져 있는지 확인해봅시다.

import random
import math
px = random.randrange(-100, 100)
py = random.randrange(-100, 100)
personCoordinate = {"X": px, "Y": py}
GSList = []

def GSRandomPoint():
    GSCoordinate = {"X": random.randrange(-100, 100), "Y": random.randrange(-100, 100)}
    a = (px - GSCoordinate["X"]) ** 2 + (py - GSCoordinate["Y"])
    b = math.sqrt(a)
    GSCoordinate["F"] = b

    print(GSCoordinate)
    GSList.append(b)

if __name__ == '__main__':
    print(personCoordinate)
    GSRandomPoint()
    GSRandomPoint()
    GSRandomPoint()
    print(GSList)
    GSList.sort()
    print(GSList)
    print('최단거리 :',GSList[0])




    # for i in range(3) :
    #     print("{i}번 주유소의 위치".format(i=i), end=':')
    #     personRandomPoint()