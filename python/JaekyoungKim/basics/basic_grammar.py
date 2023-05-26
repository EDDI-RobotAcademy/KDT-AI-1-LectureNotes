def python_basics():

    num=3
    Num=7
    print(num,Num)

    z=3+4j
    print(z)
    print(type(z))
    print(z.imag)
    print(z.real)
    print(z.conjugate())

    res =3 ** 3
    print(res)

    num1=7//3
    num2= 3333//10
    num3=7/3
    num4= 3333/10
    print(num1,num2,num3,num4)

    str1= "test String"
    print(str1)
    print(type(str1))

    fixStr="""
    오늘도 간다
        내일도 간다
            모레도 간다
                올해도 간다
    """
    print(fixStr)

    print("\t탭")
    print("\n다음라인")
    print("원 표시: \\")
    print("홑 따옴표: \'")
    print("쌍 따옴표: \"")
    #파이썬의 장점: 그냥 막 더져도 됩니다.

    test_str='test'+'str'
    print(test_str)

    can_add_str="문자열"+' 이것도 됨'
    print(can_add_str)

    test="pointer index"
    print("[0}:", test[2])

    print(test[0:1])
    print(test[0:4])
    print(test[:2])
    #생략된 부분은 0임
    print(test[:])
    print(test[::2])

    makeStr=str(3.14)
    intStr=int("77")
    floatStr=float("33.3")
    print(makeStr,intStr,floatStr)

    colors=['red','blue','green']
    print(type(colors))
    print(colors)

    colors.append('purple')
    print(colors)
    extendColor=['yellow','sky']
    colors.extend(extendColor)
    print(colors)

    colors.insert(1,'black')
    print(colors)
    colors+=['cyan','blue']
    print(colors)

    print(colors.index('blue'))
    print(colors.index('blue',3))
    print(colors.count('blue'))
    #colors.pop 맨 뒤에거 부터 빠짐
    colors.remove('yellow')
    print(colors)
    colors.sort()
    print(colors)

    colors.reverse()
    print(colors)


    a={1,2,3}
    b=[4,5,6]
    c=(7,7,7)
    print(a)
    print(b)
    print(c)
    print(type(a))
    print(type(b))
    print(type(c))
    # Set과 List의 차이점은?
    # set 중복허용하지 않고 순서 없음
    # list 중복허용하고 순서 있음
    # - 순서
    # - 중복 허용 여부
    # - 그럼 Tuple은 무엇인가?
    # - immuntable(불변성)
    # - 불변 특성을 가지고 있는 리스트
    # - 파이썬의 final list 이라고 보면 된다.
    # - Pythom에서 리턴하면 무조건 tuple 이 떨어진다.
    (a,b)=(3,7)
    print(a,b)
    a,b=b,a
    print(a,b)

    d= dict(a=1,b=2,c=3)
    print(d)
    print(type(d))

    fruits={"apple":"red","banana":"yellow","grape":"green"}
    print(type(fruits))
    # dict의 장점 프린트에 키 값 넣어 밸류 값 뽑기 힘듬
    print(fruits["apple"])
    print(fruits["banana"])
    # 파이썬을 다룰 때도 도메인 분리가 중요하다.
    # 키 값 가져오기
    for fruit in fruits.keys():
        print(fruit)
    #밸류 가져오기
    for colors in fruits.values():
        print(colors)
    # 튜플 가져오기
    for fruit in fruits.items():
        print(fruit)

    for name,color in fruits.items():
        print(name,color)

    hash_in_hash={'age':1,'job':'baby','test':{'a':1,'b':2}}
    print(hash_in_hash)

    add_everything= [1,2,3,('green'),{'apple':'green'},[4,5,6]]

    print(add_everything)
    print(type(add_everything))
    add_everything = (1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6])

    print(add_everything)
    print(type(add_everything))
    # List Tuple 다른 타입을 처리 가능하지만
    # Set 다른 타입 처리가 불가능하다.

    value =10
    if value>5:
        print("10은 5보다 크다")
    else:
        print("10은 5보다 작다")

    score= 80
    if 90<=score<=100:
        grade='A'
    elif 80<=score<=90:
        grade='B'
    else:
        grade='C'
    print(grade)

    for i in range(10):
        print(i)

    print(range(10))

    for i in range(7):
        for j in range(3):
            if(i==3):
                continue

            print("i: {0}, j: {1}".format(i, j))

    print(list(range(10)))
    print(list(range(5,10)))
    print(list(range(10,0,-1)))
    print(list(range(10,20,2)))

    for i in range(1,11,2):
        print(i)

    print([res ** 2 for res in range(1,6)])
    numList=[res ** 2 for res in range(1, 6)]
    print(numList)

    numList= [res for res in range(1,31,5)]
    print(numList)

