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

# 사용자가 사업자(business)라면 상품 등록 버튼을 활성화한다
#
# 사용자가 상품을 등록할 수 있는 페이지를 출력한다
# 등록 버튼을 누르면 사용자가 입력한 상품 정보를 backend로 보낸다
#
# 입력받은 상품 정보를 Db에 저장한다