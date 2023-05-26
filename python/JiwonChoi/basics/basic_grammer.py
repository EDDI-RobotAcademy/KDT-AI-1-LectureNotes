def python_basics():
    print("Hello Pytion!")

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
               내일도 간다~
                   모레도 간다~
                       올해도 간다~
       """

    print(fixStr)
    print(type(fixStr))

    print("탭\t탭")
    print("다음라인\n다음라인")
    print("원 표시 : \\")
    print("홀 따옴표 : \'")
    print("쌍 따옴표 : \"")
    # 파이썬의 장점 : 그냥 막 던져도 됩니다.

    test_str = 'test' + 'python'
    print(test_str)

    can_add_str = "문자열" + '이것도 됨'
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
    inStr = int("77")
    floatStr = float("33.3")

    print(makeStr, inStr, floatStr)
    print(type(makeStr), type(inStr), type(floatStr))

    colors = ['red', 'blue', 'green']
    print(colors)
    print(type(colors))

    colors.append('purple')
    print(colors)

    extend_colors = ['orange', 'white']
    colors.extend(extend_colors)  # 리스트끼리 합칠 때
    print(colors)

    colors.insert(1, 'black')  # 인덱싱해서 추가
    print(colors)

    colors += ['yellow']
    colors += ['blue']  # 리스트는 중복 허용
    print(colors)

    print(colors.index('blue'))  # 첫번째 블루
    print(colors.index('blue', 3))  # 3이후의 블루

    print(colors.count('blue'))

    print(colors.pop())  # 뒤에서 하나씩 빼줌
    print(colors.pop())
    print(colors.pop())
    print(colors)

    colors.remove('green')
    print(colors)

    colors.sort()
    print(colors)

    colors.reverse()
    print(colors)

    a = {1, 2, 3}  # set
    b = [3, 4, 5]  # list
    c = (7, 7, 7)  # tuple
    print(a)
    print(b)
    print(c)
    print(type(a))
    print(type(b))
    print(type(c))

    # set과 list의 차이점은 무엇인가?
    # - 순서
    # - 중복 허용 여부(list는 허용, set(집합)은 비허용)
    # - 그렇다면 tuple(튜플)은 무엇인가?
    # - immutable(불변성) (python 스타일의 final list)
    # - 불변 특성을 가지고 있는 리스트
    # 그럼 tuple(튜플)은 보통 어디서 사용될까?
    # python에서 리턴하면 무조건 tuple이 떨어지게 됩니다.

    (a, b) = (3, 7)
    print(a, b)

    a, b = b, a
    print(a, b)

    d = dict(a=1, b=3, c=5)
    print(d)
    print(type(d))

    fruits = {"apple": "red", "grape": "green"}
    print(fruits)
    print(type(fruits))

    print(fruits["apple"])  # 자바에선 못함
    print(fruits["grape"])

    # 파이썬의 장점 : 그냥 막 던져도 됩니다.
    # 그래도 가독성은 중요 => 도메인 분리 필요

    print("for fruit in fruits.keys():")
    for fruit in fruits.keys():
        print(fruit)

    print("for fruit_color in fruits.values():")
    for fruit_color in fruits.values():
        print(fruit_color)

    print("for fruit in fruits.items():")
    for fruit in fruits.items():
        print(fruit)

    print("for name, color in fruits.items():")
    for name, color in fruits.items():
        print(name, color)

    print("hash_in_hash :")
    hash_in_hash = {'age': 1, 'job': 'baby', 'test': {'a': 1, 'b': 2}}
    print(hash_in_hash)

    print("리스트 안에 여러 타입 넣기 =>")
    add_everything = [1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6]]
    print(add_everything)
    print(type(add_everything))

    print("튜플 안에 여러 타입 넣기 =>")
    add_everything = (1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6])
    print(add_everything)
    print(type(add_everything))

    # print("셋 안에 여러 타입 넣기 =>") #이건 안 됨
    # add_everything = {1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6]}
    # print(add_everything)
    # print(type(add_everything))

    value = 10
    # 괄호 대신 들여쓰기를 사용하므로
    # 들여쓰기 주의
    if value > 5:
        print("10은 5보다 크다")
        print("10은 5보다 크다")
        print("10은 5보다 크다")
    else:
        print("10은 5보다 작다")
        print("10은 5보다 작다")
        print("10은 5보다 작다")

    # score = int(input('점수 입력:'))
    # if 90 <= score <= 100:
    #     grade = 'A'
    # elif 80 <= score <= 90:
    #     grade = 'B'
    # else:
    #     grade = 'C'
    #
    # print('grade : ', grade)

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
    print(list(range(10, 0, -1)))  # 10부터 0까지 -1씩
    print(list(range(10, 20, 2)))  # 10부터 20까지 +2씩

    for i in range(0, 11, 2):
        print(i)

    print([res ** 2 for res in range(1, 6)])
    numList = [res ** 2 for res in range(1, 6)]
    print(numList)  # [1, 4, 9, 16, 25]

    numList = [res for res in range(10, 31, 5)]
    print(numList)