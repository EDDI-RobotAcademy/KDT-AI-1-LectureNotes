# def 함수명(매개변수):
    # <수행할 문장1>
    # <수행할 문장2>
def bigger_than_20(num):
    return num > 20 # 20보다 큰 수만

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

#원본 파괴하지 않을때 사용하면 된다 (+영상 처리할때도 가능)
# 두개의 x 주소가 다름 (복사),
# x[:] 는 데이터만 복사하는데 별개의 데이터가 만들어진다. 별도의 객체를 만들어줌 (new를 만든거랑 같음)
def change(x):
    x = x[:]
    x[0] = 'H'
    print("in function =", x)

def change2(x):
    x[0] = 'H'

glob = 1

def xChgScope(num):
    global glob
    glob = 7
    return glob + num

import random # random 라이브러리
import math # math 라이브러리

def functions_test():
    numList = [res for res in range(10, 31, 5)]
    filteredNumList = filter(bigger_than_20, numList)

    for num in filteredNumList:
        print("element: {0}".format(num))

    print(filteredNumList)
    print(type(filteredNumList))

    # 여러개의 데이터에서 특정 조건 일부 데이터를 추려낼 때 사용
    # numList에 들어온 값을 bigger_than_20에 하나 하나 넣고 참인지, 거짓인지에 따라 포함할지 말지 결정 한다.
    print(list(filter(bigger_than_20, numList)))
    print(list(filter(lambda i: i > 20, numList)))

    for i in map(add_10, numList):
        print("num: {0}".format(i))

    print(list(map((lambda i: i + 10), numList)))
    print(times)
    print(times(10, 10))

    functions_address = times
    print(functions_address(10, 10))

    list1 = "apple"
    list2 = "grape"
    list3 = "banana"

    print(intersect(list1, list2))
    print(intersect(list1, list3))

    wordList = ['J', 'A', 'M']
    print(wordList)

    change(wordList)
    print(wordList)

    change2(wordList)
    print(wordList)

    print(glob)
    print(xChgScope(3))
    print(glob) # 전역 변수 값을 7로 바꿈

    # range() 함수는 말 그대로 정수로 이뤄진 “범위”를 만들 때 사용하는 함수
    # range() 내장 함수는 최대 3개의 인자를 받음
    # range(<시작값>, <종료값>, <증분>)
    for _ in range(10): # 10번
        print(random.randrange(3, 7)) # 3 ~ 6까지

    # math.pow 함수는 x의 y 거듭제곱 (x의 y승)을 반환
    # 이 함수의 반환형은 언제나 float 타입 (정수 타입 계산을 원한다면 내장 함수 pow 혹은 ** 을 사용)
    # math.pow(1.0, y)는 항상 1.0입니다. 당연한 거겠죠 이건? 1의 n 제곱은 무조건 1 이라서
    print(math.pow(3, 4))
    print(3 ** 4)

    # math.sqrt(x) 함수는 x의 제곱근을 반환
    # 이 함수의 반환형 또한 float 타입
    print(math.sqrt(9))