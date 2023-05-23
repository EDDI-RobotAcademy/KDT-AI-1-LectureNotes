# python 문제 은행 [ 1 ]
# 주유소 문제를 python 버전으로 확장해 보겠습니다.
# 현재 사용자가 있는 좌표를 랜덤으로 생성합니다.
# 주유소 좌표를 랜덤으로 3개 정도 만듭니다.

import random

def makeRandomPoint():
    PointX = random.randrange(-100, 100)
    PointY = random.randrange(-100, 100)
    print("({},{})".format(PointX, PointY))


if __name__ == '__main__':
    print("현재 사용자의 위치", end=':')
    makeRandomPoint()
    for i in range(3) :
        print("{i}번 주유소의 위치".format(i=i), end=':')
        makeRandomPoint()