def python_basics():
    print('Hello Python!')

    num = 3
    Num = 7

    print(num, Num)

    z = 3 + 4j
    print(z)
    print(type(z))

    print(z.imag)
    print(z.real)
    print(z.conjugate())

    res = 3 ** 3
    print(res)

    num1 = 7 // 3
    num2 = 3333 // 10
    num3 = 7 / 3
    num4 = 3333 / 10

    print(num1, num2, num3, num4)

    str1 = "test string"
    print(str1)
    print(type(str1))

    fixStr = """
        오늘도 간다 ~
            내일도 간다 ~
                모레도 간다 ~
                    올해도 간다 ~
    """

    print(fixStr)
    print(type(fixStr))

    print("\t탭")
    print("\n다음라인")
    print("원 표시: \\")
    print("홀 따옴표: \'")
    print("쌍 따옴표: \"")
    # 파이썬의 장점 : 그냥 막 던져도 됩니다

    test_str = 'test' + ' python'
    print(test_str)

    can_add_str = "문자열 " + '이것도 됨'
    print(can_add_str)

    test_str = "pointer index"
    print(test_str)

    print("[0]:", test_str[0])
    print("[3]:", test_str[3])

    print("[0:1]:", test_str[0:1])
    print("[0:4]:", test_str[0:4])
    print("[:2]:", test_str[:2])
    print("[-2:]:", test_str[-2:])
    print("[:]:", test_str[:])
    print("[::2]:", test_str[::2])

    makeStr = str(3.14)
    intStr = int("77")
    floatStr = float("33.3")

    print(makeStr, intStr, floatStr)
    print(type(makeStr), type(intStr), type(floatStr))

    colors = ['red', 'blue', 'green']
    print(colors)
    print(type(colors))

    colors.append('purple')
    print(colors)

    extend_colors = ['orange', 'white']
    colors.extend(extend_colors)
    print(colors)

    colors.insert(1, 'black')
    print(colors)

    colors += ['yellow']
    colors += ['blue']
    print(colors)

    print(colors.index('blue'))
    print(colors.index('blue', 3))  # 시작 지점 설정

    print(colors.count('blue'))

    print(colors.pop())
    print(colors.pop())
    print(colors.pop())
    print(colors)

    colors.remove('green')
    print(colors)

    colors.sort()
    print(colors)

    colors.reverse()
    print(colors)

    a = {1, 2, 3}
    b = [3, 4, 5]
    c = (7, 7, 7)

    print(a)
    print(b)
    print(c)

    print(type(a))  # 중괄호 = set
    print(type(b))  # 대괄호 = list
    print(type(c))  # 소괄호 = tuple

    # set과 list의 차이점은 무엇인가?
    # - 순서
    # - 중복 허용 여부

    # 그럼 tuple은 뭐지?
    # - 순서 없이 중복 허용
    # - immutable(불변성) = python 스타일의 final list
    # - 불변 특성을 가지고 있는 리스트
    # 그럼 이 녀석은 보통 어디서 마주하게 될까?
    # python에서 리턴하면 무조건 tuple이 떨어지게 됩니다.

    (a, b) = (3, 7)
    print(a, b)

    a, b = b, a
    print(a, b)

    d = dict(a = 1, b = 3, c = 5)       # 키 : 밸류
    print(d)
    print(type(d))

    fruits = {"apple": "red", "grape": "green"}
    print(fruits)
    print(type(fruits))         # JSON 스타일로 적어도 dict가 된다

    print(fruits["apple"])
    print(fruits["grape"])

    for fruit in fruits.keys():
        print(fruit)

    for fruit_color in fruits.values():
        print(fruit_color)

    for fruit in fruits.items():        # 키와 밸류 모두 출력
        print(fruit)

    for name, color in fruits.items():
        print(name, color)

    # 해쉬 안의 해쉬
    hash_in_hash = {'age': 1, 'job': 'baby', 'test': {'a': 1, 'b': 2}}
    print(hash_in_hash)

    add_everything = [1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6]]
    print(add_everything)
    print(type(add_everything))

    add_everything = (1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6])
    print(add_everything)
    print(type(add_everything))

    #add_everything = {1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6]}
    #print(add_everything)
    #print(type(add_everything))

    value = 10
    if value > 5:
        print("10은 5보다 크다")
        print("들여쓰기")
        print("응")
    else:
        print("10은 5보다 작다")

    #score = int(input('점수 입력: '))
    #if 90 <= score <= 100:
        #grade = 'A'
    #elif 80 <= score <= 90:
        #grade = 'B'
    #else:
        #grade = 'C'

    #print('grade:', grade)

    for i in range(10):
        print(i)

    print(range(10))

    for i in range(7):
        for j in range(3):
            if (i == 3):
                continue

            print("i: {0}, j: {1}".format(i, j))

    print(list(range(10)))
    print(list(range(5, 10)))
    print(list(range(10, 0, -1)))
    print(list(range(10, 20, 2)))

    for i in range(1, 11, 2):
        print(i)

    print([res ** 2 for res in range(1, 6)])
    numList = [res ** 2 for res in range(1, 6)]
    print(numList)

    numList = [res for res in range(10, 31, 5)]
    print(numList)

