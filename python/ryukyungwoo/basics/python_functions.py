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
    print("in function =", x)

def change2(x):
    x[0] = 'H'

glob = 1

def xChgScope(num):
    global glob
    glob = 7
    return glob + num

import random
import math

def functions_test():
    numList = [res for res in range(10, 31, 5)]
    filterdNumList = filter(bigger_than_20, numList)

    for num in filterdNumList:
        print("element: {0}".format(num))

    print(filterdNumList)
    print(type(filterdNumList))

    print(list(filter(bigger_than_20, numList)))
    print(list(filter(lambda i: i > 20, numList)))

    for i in map(add_10, numList):
        print("num: {0}".format(i))

    print(list(map((lambda i: i + 10), numList)))
    print(times)
    print(times(10, 10))

    function_address = times
    print(function_address(10, 10))

    list1 = "apple"
    list2 = "grape"
    list3 = "banana"

    print(intersect(list1, list2))
    print(intersect(list1, list3))

    wordList = ['J', 'A', "M"]
    print(wordList)

    change(wordList)
    print(wordList)
    change2(wordList)
    print(wordList)

    print(glob)
    print(xChgScope(3))
    print(glob)

    for _ in range(5):
        print(random.randrange(3, 7))

    print(math.pow(3, 4))
    print(3 ** 4)

    print(math.sqrt(9))

    print("----------------------------------")

    gas_station1 = random_generate_xy()
    gas_station2 = random_generate_xy()
    gas_station3 = random_generate_xy()

    person = random_generate_xy()

    print(gas_station1, gas_station2, gas_station3, person)


    print(calculate_xy(gas_station1, person))

    print(shortest_xy(gas_station1, gas_station2, gas_station3, person))

def random_generate_xy():
    retList = []

    for x in range(2):
        retList.append(random.randrange(1, 100))

    return retList

def calculate_xy(gas, person):
    retList = []

    retList.append(gas[0] - person[0])
    retList.append(gas[1] - person[1])

    straight = math.sqrt(((retList[0]) ** 2) + ((retList[1]) ** 2))

    return straight

def shortest_xy(gas1, gas2, gas3 ,person):
    retList = []

    retList.append(calculate_xy(gas1, person))
    retList.append(calculate_xy(gas2, person))
    retList.append(calculate_xy(gas3, person))

    retList.sort()

    return retList