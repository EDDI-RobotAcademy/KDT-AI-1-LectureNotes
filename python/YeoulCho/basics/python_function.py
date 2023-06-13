import math
import random


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

def change(x): # x
    x = x[:] # x, 위아래 x 가 다름, 얉은 복사, 데이터를 복사하는데 별개의 객체가 되는것
    x[0] = 'H'
    print("in function=", x)
 #원본을 파괴하지 않을 때 사용하는 것이 좋다


def change2(x):
    x[0] = 'H' # 복사하지 않고 바로 바꾸기
##


glob = 1



def xchgScope(num):
    global glob
    glob = 7
    return glob + num


def functions_test():
    numList = [res for res in range(10, 31, 5)]
    filteredNumList = filter(bigger_than_20, numList)

    for num in filteredNumList:
        print("element: {0}".format(num))

    print("1: ", filteredNumList)
    print("2: ", type(filteredNumList))

    print("3: ", list(filter(bigger_than_20, numList)))
    print("4: ", list(filter( lambda i: i > 20, numList)))

    for i in map(add_10, numList):
        print("num: {0}".format(i))

    print(list(map((lambda i: i+10), numList)))
    print(times)
    print(times(10, 10))

    function_address = times
    print(function_address(10,10))

    list1 = "apple"
    list2 = "grape"
    list3 = "banana"

    print(intersect(list1, list2)) # 키워드 분석에 이용
    print(intersect(list1, list3))


    wordList = ['J', 'A', 'M']
    print(wordList)

    change(wordList)
    print(wordList)

    change2(wordList)
    print(wordList)

    print(glob)
    print(xchgScope(3))
    print(glob)

    for _ in range(5): # 5번반복
        print(random.randrange(3, 7))

    print(math.pow(3,4))
    print( 3 ** 4)

    print(math.sqrt(9))
