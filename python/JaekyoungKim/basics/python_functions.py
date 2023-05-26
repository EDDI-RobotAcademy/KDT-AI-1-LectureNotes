import random
import math

def bigger_than_20(num):
    return num>20

def add_10(num):
    return num+10
def times(num1,num2):
    return num1*num2

def intersect(preList,postList):
    retList=[]
    for x in preList:
        if x in postList:
            retList.append(x)

    return retList

# 원본을 파괴하지 않을때 사용하는 방법
def change(x):
    x =x[:]
    x[0]='H'
    print("in function=",x)

def change2(x):
    x[0] = 'H'
    print("in function=", x)

glob=1
# 전역 변수
def xChgScope(num):
    global glob
    glob=7
    return glob+num
def functions_test():
    numList=[res for res in range(10,31,5)]
    filteredNumList= filter(bigger_than_20,numList)

    for num in filteredNumList:
        print("element: {0}".format(num))

    print(filteredNumList)
    print(type(filteredNumList))

    print(list(filter(bigger_than_20,numList)))
    print(list(filter(lambda i:i>20,numList)))

    for i in map(add_10,numList):
        print("num: {0}".format(i))

    print(list(map((lambda i:i+10),numList)))
    print(times)
    # 람다는 잠깐쓰고 버린다
    print(times(10,10))


    function_address=times
    print(function_address(10,10))
    list1="apple"
    list2="banana"
    list3="grape"
    print(intersect(list1,list2))
    print(intersect(list2,list3))
    print(intersect(list1,list3))


    wordList=['J','A','M']
    print(wordList)
    change(wordList)

    print(wordList)
    # 원본 파괴 여부에 따라 복사할지 말지 정한다.
    change2(wordList)
    print(wordList)

    print(glob)
    print(xChgScope(3))
    print(glob)

    for _ in range(5):
        print(random.randrange(3,7))

    print(math.pow(3,4))
    # 뒤에 숫자만큼 제곱
    print(3**4)

    # 루트 씌우는 것
    print(math.sqrt(9))

    