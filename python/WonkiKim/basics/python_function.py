import random
import math


def bigger_than_20(num):
    return num > 20


def functions_test():
    numList = [res for res in range(10, 31, 5)]
    filteredNumList = filter(bigger_than_20, numList)

    for num in filteredNumList:
        print("element: {0}".format(num))
    print(filteredNumList)
    print(type(filteredNumList))

    print(list(filter(bigger_than_20, numList)))
    print(list(filter(lambda i: i > 20, numList)))

    for i in map(add_10, numList):
        print("num: {0}".format(i))

    print(list(map((lambda i: i + 10), numList)))

    print(times)
    print(times(10, 10))

    function_address = times
    print(function_address(10, 10))
    print("intersect()")
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
    print(xChgscope(3))
    print(glob)

    for _ in range(5):
        print(random.randrange(3, 7))

    print(math.pow(3, 4))
    print(3 ** 4)
    print(math.sqrt(9))
    print(9 ** (1/2))


def xChgscope(num):
    global glob
    glob = 3;


global glob
glob = 1;


def change2(x):
    x[0] = 'H'


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
