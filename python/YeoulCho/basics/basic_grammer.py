def python_basics():

    print("hello python")
    num = 3
    Num =7
    print(num,Num)
    z= 3 +4j
    print(z)
    print(type(z))

    print(z.imag) #허수
    print(z.real) #실수
    print(z.conjugate()) #켤레 복소수 허수가 마이너스로 치환

    res = 3 ** 3 #3의 3승 (Math.POW)
    print(res)

    num1 = 7 // 3 # // 몫
    num2 = 3333 // 10
    num3 = 7 / 3 # / 그냥 나누기, 타입이 지정되지 않아서, int/int -> float 형태로 바뀜
    num4 = 3333 / 10

    print(num1,num2,num3,num4)
    print(type(num3))


    str1="test string"
    print(str1)
    print(type(str1))

    fixStr = """
        오늘도 간다~
            내일도 간다~
                모레도 간다~
                    올해도 간다~  
    """
    print(fixStr)
    print(type(fixStr))

    print("\t 탭")
    print("\n 다음라인")
    print("원표시: \\")
    print("홀 따옴표: \'")
    print("쌍 따옴표: \"")

    # 파이썬의 장점: 그냥 막 던져도 됩니다

    test_str = 'test' + 'python'
    print(test_str)

    can_add_str = "문자열" + "이것도 됨"
    print(can_add_str)
    # 쌍따옴표 홀따옴표 구분 없음

    test_str = "pointer index"
    print(test_str)

    print("[0]", test_str[0])
    print("[3]", test_str[3])

    print("[0:1]", test_str[0:1]) # 0~1미만
    print("[0:4]", test_str[0:4]) # 0~4미만
    print("[:2]", test_str[:2])   # 생략이면 무조건 0
    print("[-2:]", test_str[-2:]) # 뒤에서 부터 2개 가져오기
    print("[:]", test_str[:])     # 아무것도 없으면 복사
    print("[::2]", test_str[::2]) # 2칸씩 뛰기


    makeStr = str(3.14)
    intStr = int("77")
    floatStr = float("33.3")

    print(makeStr, intStr, floatStr)
    print(type(makeStr), type(intStr), type(floatStr))

    colors = ['red', 'blue', 'yellow']
    print(colors)
    print(type(colors))

    colors.append('purple') # list.add
    print(colors)

    extend_colors = ['orange', 'white']
    colors.extend(extend_colors)
    print(colors)

    colors.insert(1, 'black') #인덱싱하여 추가 가능
    print(colors)

    colors += ['green'] #덧셈으로도 추가 가능
    print(colors)
    colors += ['blue'] #리스트라 중복허용
    print(colors)

    print(colors.index('blue'))
    print(colors.index('blue', 3)) #인덱스 3번 이후부터 찾아라

    print(colors.count('blue'))

    print(colors.pop())
    print(colors.pop())
    print(colors.pop())
    print(colors)

    colors.remove('orange')
    print(colors)

    colors.sort()    #정렬
    print(colors)

    colors.reverse() #거꾸로 정렬
    print(colors)

    a = {1, 2, 3}
    b= [3, 4, 5]
    c = (7,7,7)
    print(a)
    print(b)
    print(c)

    print(type(a))
    print(type(b))
    print(type(c))

    # Set 과 List의 차이점은?
    # 중복을 허용하느냐
    # 순서

    # 그럼 Typle(튜플)은 뭐지?
    # 순서없이 중복허용
    # immutable(불변성)- python의 final list
    # 불변 특성을 가지고 있는 리스트, 데이터 변경 불가능
    # 어디서 보통 사용하게 될까?
    # python에서 return하면 무조건 튜플

    (a, b) =(3, 7)
    print(a, b)

    a, b = b, a
    print(a, b);

    d = dict(a = 1, b =3, c = 5) #hash랑 유사 key, value
    print(d)
    print(type(d))

    fruits = {"apple" : "red", "grape" : "green"}
    print(fruits)
    print(type(fruits))

    print(fruits["apple"])
    print(fruits["grape"]) # key로 단순하게 value뽑을 수 있음

    for fruit in fruits.keys():
        print(fruit)

    for fruit_color in fruits.values():
        print(fruit_color)

    for fruit in fruits.items():
        print(fruit)

    for name, color in fruits.items():
        print(name, color)

    hash_in_hash ={'age':1, 'job': 'baby', 'test':{'a': 1, 'b':2}}
    print(hash_in_hash)

    add_everything = [1,2,3, ('green'), {'apple':'green'}, [4,5,6]]
    print(add_everything)
    print(type(add_everything))

    add_everything = (1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6])
    print(add_everything)
    print(type(add_everything))

    # add_everything = {1, 2, 3, ('green'), {'apple': 'green'}, [4, 5, 6]} #set 타입은 처리 불가
    # print(add_everything)
    # print(type(add_everything))

    value = 10
    if value > 5:
        print("10은 5보다 크다")
        print("들여쓰기")
        print("응")
    else:
        print("10은 5보다 작다")

    score = int(input('점수입력: '))
    if 90 <= score <=100:
        grade = 'A'
    elif 80 <= score <=90:
        grade = 'B'
    else:
        grade = 'C'
    print('grade: ', grade)

    for i in range(10):
        print(i)  #0~9까지

    print(range(10))

    for i in range(7):
        for j in range(3):
            if(i==3):
                continue # pass 넘겨라

            print("i: {0}, j:{1}".format(i,j))

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
    # for(int i=0; i< 6; i++){
    #   numList.add(i * i );
    #   System.out.println(numList.get(i));
    # }

    numList = [res for res in range(10, 31, 5)]
    print(numList)