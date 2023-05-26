# This is a sample Python script.

# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press ⌘F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
def python_basics():
    print_hi('PyCharm')

    print("hello Python!")

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

    fixStr = """
    오늗도 간다 ~
        내일도 간다~
            모레도 간다~
    """
    print(fixStr)
    print(type(fixStr))

    print("\t탭")
    print("\nnext line")
    print("\\ Won sign")
    print("single quote ' ")
    print('double quote " ')
    # 파이썬의 장점 : 그냥 막 던져도 됩니다.

    test_str = 'test' + ' python'
    print(test_str)

    can_add_str = "str " + "can do it"
    print(can_add_str)

    print("[0]: ", test_str[0])
    print("[3]: ", test_str[3])
    print("[0:1]: ", test_str[0:1])
    print("[0:4]: ", test_str[0:4])
    print("[:2]: ", test_str[:2])
    print("[-2:]: ", test_str[-2:])
    print("[:]: ", test_str[:])
    print("[::2]: ", test_str[::2])

    makeStr = str(3.14)
    intStr = int("77")
    floatStr = float("33.3")
    print(makeStr, intStr, floatStr)
    print(type(makeStr), type(intStr), type(floatStr))

    colors = ['res', 'blue', 'green']
    print(colors)
    print(type(colors))

    colors.append('purple')
    print(colors)

    extend_colors = ['orange', 'black']
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

    print(type(a))
    print(type(b))
    print(type(c))
    print(c)

    (a, b) = (3, 7)
    print(a, b)

    a, b, = b, a
    print(a, b)

    d = dict(a=1, b=2, c=3)
    print(d)
    print(type(d))

    fruits = {"apple": "red", "grape": "green"}
    print(fruits)
    print(type(fruits))

    print(fruits["apple"])

    for fruit in fruits.items():
        print(fruit)

    for name, color in fruits.items():
        print(name, color)

    hash_in_hash = {'age': 1, 'job': 'baby', 'test': {'a': 1, 'b': 2}}
    print(hash_in_hash)

    add_everything = [1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6]]
    print(add_everything)
    print(type(add_everything))

    # score = int(input('점수 입력: '))
    # if 90 <= score <= 100:
    #     grade = 'A'
    # elif 80 <= score < 90:
    #     grade = 'B'
    # else:
    #     grade = 'C'
    # print(grade)

    for i in range(10):
        print(i)

    print(range(10))
    iter = range(10, 100, 2).step
    print(iter)

    for i in range(7):
        for j in range(3):
            if (i == 3):
                continue
            print("i:{0}, j:{1}".format(i, j))

    print(list(range(10)))
    print(list(range(5, 10)))
    print(list(range(5, -10, -1)))
    print(list(range(10, 20, 2)))

    for i in range(1, 10, 2):
        print(i)

    print([res ** 2 for res in range(1, 6)])

    numList = [res ** 2 for res in range(1, 6)]
    print(numList)

    # List<Integer> numList = new ArrayList<>();
    # for (int i=0; i<5; i++0 {
    #   numList.add(i * i);
    # }

    numList = [res for res in range(10, 31, 5)]
    print(numList)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
