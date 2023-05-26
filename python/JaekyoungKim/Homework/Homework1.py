import math
import random

def  where_is_close(num1,num2,num3):
    if num1 < num2 < num3:
        print("1번 주유소가 제일 가깝다")

    if num2 < num3 and num2 < num1:
        print("2번 주유소가 제일 가깝다")

    if num3 < num1 and num3 < num2:
        print("3번 주유소가 제일 가깝다")

def random_place():
    x = random.randrange(100)
    y = random.randrange(100)
    return (x, y)


def point_range(preList, postList):
    aList = preList
    bList = postList
    x = math.pow(aList[0] - bList[0], 2)
    y = math.pow(aList[1] - bList[1], 2)
    length = math.sqrt(x + y)
    return length


def Homework1():
    my = random_place()

    oil1 = random_place()
    oil2 = random_place()
    oil3 = random_place()
    print(my)
    print(oil1)
    print(oil2)
    print(oil3)
    length1 = point_range(my, oil1)
    length2 = point_range(my, oil2)
    length3 = point_range(my, oil3)
    print(length1, length2, length3)

    where_is_close(length1,length2,length3)
    