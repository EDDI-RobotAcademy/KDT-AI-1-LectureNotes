def python_basics():
    num = 3
    Num = 7
    print(num, Num)

    # See PyCharm help at https://www.jetbrains.com/help/pycharm/

    z = 3 + 4j
    print(z)  # (3+4j)
    print(type(z))  # <class 'complex'>

    print(z.imag)  # 4.0
    print(z.real)  # 3.0
    print(z.conjugate())  # (3-4j)

    res = 3 ** 3
    print(res)

    num1 = 7 // 3
    num2 = 3333 // 10
    num3 = 7 / 3
    num4 = 3333 / 10

    print(num1, " , ", num2, " , ", num3, " , ", num4)  # 2  ,  333  ,  2.3333333333333335  ,  333.3

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
    print("\n다음 라인")
    print(" 원 표시 : \\")
    print("홀 따옴표 : \'")
    print("쌍 따옴표 : \"")

    test_str = 'test ' + ' python'
    print(test_str)

    can_add_str = "문자열 " + ' 이것도 됨'  # " , ' 이거 두개 구분 없음 ㅇㅇ
    print(can_add_str)

    test_str = 'pointer index'
    print(test_str)

    print("[0] : ", test_str[0])
    print("[3] : ", test_str[3])
    print("[0:1] : ", test_str[0:1])
    print("[0:4] : ", test_str[0:4])
    print("[:2] : ", test_str[:2])  # 앞에서 두개 출력
    print("[-2:] : ", test_str[-2:])  # 뒤에서 두개 출력
    print("[:] : ", test_str[:])  # 전부 출력
    print("[::2] : ", test_str[::2])  # 두칸 씩 띄어서 출력

    nakeStr = str(3.14)
    intStr = int("77")
    floatStr = float("33.3")

    print(nakeStr, " , ", intStr, " , ", floatStr)
    print(type(nakeStr), " , ", type(intStr), " , ", type(floatStr))

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
    print(colors.index('blue', 3))
    print(colors.count('blue'))

    print(colors.pop())
    print(colors.pop())
    print(colors.pop())
    print(colors)

    colors.remove('green')
    print(colors)

    colors.sort()  # 알파벳 순서로
    print(colors)

    colors.reverse()  # 거꾸로
    print(colors)

    a = {1, 2, 3}  # set
    b = [4, 5, 6]  # list
    c = (7, 7, 7)  # tuple

    print(a)
    print(b)
    print(c)

    print(type(a))
    print(type(b))
    print(type(c))

    # Set과 List의 차이점은 무엇인가 ?
    # - 순서
    # - 중복 허용 여부
    # 그럼 Tuple(튜플)은 뭐지 ?
    # - 순서 없이 중복 허용
    # - immutable(불변성) - python 스타일의 final List
    # - 불변 특성을 가지고 있는 리스트
    # 그럼 이 녀석은 보통 어디서 마주하게 될까 ?
    # python에서 리턴하면 무조건 tuple이 떨어지게 됩니다.

    (a, b) = (3, 7)
    print(a, b)

    a, b = b, a
    print(a, b)

    d = dict(a=1, b=3, c=5)  # json이랑 비슷하다. # JSON에 대해서 궁금해지는걸?
    print(d)
    print(type(d))

    fruits = {"apple": "red", "grape": "green"}
    print(fruits)
    print(type(fruits))

    print(fruits["apple"])
    print(fruits["grape"])

    for fruit in fruits.keys():  # 키만
        print(fruit)

    for fruit in fruits.values():  # 값만
        print(fruit)

    for fruit in fruits.items():  # 키 값 둘다
        print(fruit)

    for name, color in fruits.items():
        print(name, color)

    hash_in_hash = {'age': 1, 'job': 'baby', 'test': {'a': 1, 'b': 2}}
    print(hash_in_hash)  # list 안에 hash 가능
    print(type(hash_in_hash))

    add_everything = (1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6])
    print(add_everything)  # tuple 안에 hash 가능
    print(type(add_everything))

    # add_everything = {1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6]}
    # print(add_everything) # set 안에는 불가능
    # print(type(add_everything))

    value = 10
    if value > 5:
        print("10은 5보다 크다")
        print("들여쓰기")
        print("응")
    else:
        print("이거")

        # score = int(input('점수 입력: '))
    score = 30
    if 90 <= score <= 100:
        grade = 'A'
    elif 80 <= score <= 90:
        grade = 'B'
    else:
        grade = 'C'

    print('grade:', grade)

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

    # List<Integer> numList = new ArrayList<>();
    # for (int i = 1; i < 6; i++) {
    #   numList.add(i * i);
    #   System.out.println(numList.get(i));
    # }

    numList = [res for res in range(10, 31, 5)]
    print(numList)
