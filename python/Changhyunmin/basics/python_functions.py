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
    print("in function =", x)

glob =1

def xChgScope(num):
    global glob
    glob = 7
    return glob + num

def change2(x):
    x[0] = 'H'
    print("in function =", x)



def functions_test():
    numList = [res for res in range(10,31,5)]
    filteredNumList = filter(bigger_than_20,numList)


    for num in filteredNumList:
        print("element: {0}".format(num))

    print(filteredNumList)
    print(type(filteredNumList))

    print(list(filter(bigger_than_20, numList)))
    # lambda 식 으로도 표현할 수 있다.
    print(list(filter(lambda i: i >20, numList)))

    for i in map (add_10, numList):
        print("num: {0}".format(i))

    #lambda 식 으로도 표현할 수 있다.
    print(list(map((lambda i: i+10), numList)))
    print(times)
    print(times(10,10))

    function_address = times
    print(function_address(10,10))

    list1 = "apple"
    list2 = "grape"
    list3 = "banana"

    #키워드가 필요한 직종에서 사용됨/ 주식 분석 /
    print(intersect(list1, list2))
    print(intersect(list3, list2))
    print(intersect(list1, list3))

    wordList = ['J','A','M']
    print(wordList)
    #원본을 파괴하지 않게하기 위해서 사용한다/
    change(wordList)
    print(wordList)
    #원본을 유지 하고싶지 않을 때 사용한다/
    change2(wordList)
    print(wordList)

    #
    print(glob)
    print(xChgScope(3))
    print(glob)

    print('')

    for _ in range(5):
        #3~6까지 랜덤한 숫자를 준다.
        print(random.randrange(3, 7))

    print(math.pow(3, 4))
    print(3**4)

    print(math.sqrt(9))
    print()

    for i in range(3):
        print (random.randrange(0,10))

    print(i)