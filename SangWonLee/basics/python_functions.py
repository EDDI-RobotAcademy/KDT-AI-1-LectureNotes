import random
import math


def bigger_than_20(num):
    return num > 20


def add_10(num):
    return num + 10


def times(num1, num2):
    return num1 * num2


def intersect(preList, postList):
    retList = []
    for x in preList:
        if x in postList:
            retList.append(x)

    return retList


def change(x):
    x = x[:]
    x[0] = 'H'
    print("in function = ", x)


def change2(x):
    x[0] = 'H'


glob = 1


def xChgScope(num):
    global glob
    glob = 7
    return glob + num


def functions_test():
    numList = [res for res in range(10, 31, 5)]
    print(numList)  # [10, 15, 20, 25, 30]
    filteredNumList = filter(bigger_than_20, numList)
    # numList의 각 요소에 대해 bigger_than_20 함수 호출

    for num in filteredNumList:
        print("element: {0}".format(num))  # element: 25 element: 30
        # {0}은 문자열 형식 지정자임 format() 메소드의 첫번째 인수로 전달된 값을 문자열에 삽입 하는데 사용

    print(filteredNumList)  # filteredNumList 메모리의 특정 위치에 있는 filter 객체를 나타냄
    print(type(filteredNumList))  # filter class임

    print(list(filter(bigger_than_20, numList)))
    # numList의 각 요소에 대해 bigger_than_20 메소드가 적용된 것들의 list를 출력

    print(list(filter(lambda i: i > 20, numList)))
    # numList의 각 요소에 대해 lambda i: i > 20을 호출하여 Trur를 반환하는 요소만 반환하는
    # filter 객체를 생성한다.

    for i in map(add_10, numList):
        print("num: {0}".format(i))

    print(list(map((lambda i: i + 10), numList)))

    # filter는 특정 조건을 만족하는 요소만 선택하는데 사용
    # map은 반복 가능한 객체의 각 요소에 대해 특정 작업을 수행하는데 사용

    print(times)
    print(type(times))
    print(times(10, 10))

    list1 = "apple"
    list2 = "grape"
    list3 = "banana"

    print(intersect(list1, list2))
    print(intersect(list1, list3))

    wordList = ['J', 'A', "H"]

    print(wordList)
    change(wordList)  # 복사본이 생성되서 할당되므로
    print(wordList)  # 값이 변경되지 않음

    change2(wordList)  # 원래의 x가 변경됨
    print(wordList)

    print(glob)
    print(xChgScope(3))
    print(glob)  # 전역변수가 바뀐다.

    for _ in range(5):
        print(random.randrange(3, 7))  # 3 ~ 6 랜덤 숫자

    print(math.pow(3, 4))  # 3의 4제곱
    print(3 ** 4)

    print(math.sqrt(9))  # 3의 루트
