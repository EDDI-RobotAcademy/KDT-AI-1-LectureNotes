class Person:
    name = "기본값"

    def print_info(self):
        print("내 이름은 {0}".format(self.name))


# 전역변수
test_str = "나는 클래스 멤버 변수가 아니야!"

class NonSelfTest:
    test_str = ""

    def set_test_str(self, msg):
        self.test_str = msg

    def print_info(self):
        print(test_str) # "나는 클래스 멤버 변수가 아니야!" 출력
        print(self.test_str) # msg에 넣는 값 출력
        # self가 몰까?
        # 자바의 this랑 같음

        # self를 붙이지 않으면 전역변수가 출력
        # self를 붙이면 멤버변수가 출력됨


# 생성자
class Vehicles:
    # def __init__(self):
    #     print("나는 기본 생성자야!")

    def __init__(self, speed):
        self.speed = speed
        print("나는 파라메터를 가진 생성자야! ->", self.speed)
        # 파이썬은 띄어쓰기를 안해줘도 , 붙이면 자동으로 띄어쓰기 되네

# 우리가 자바에서 생성자를 가지고 한 것은?
# 초기값 세팅
# 지금도 생성자에서 초기값을 세팅함

    def __del__(self):
        print("처음 들어봤지? 난 소멸자야!")
# 소멸자가 뭘까?
# 지금 우리가 생성자를 통해 만들어진 객체를 v에 대입함
# 지금은 v로 만들어진 지역변수가 만들어짐
# 이 지역 변수가 쓸모없어질 때 -> 날려버릴 수 있는 소멸자

# 그리고 생성자나 소멸자와 같이 앞뒤에 __ 는 특별한 용도로 사용하기 위해
# 미리 정의해 둔 것이라고 생각하면 된대


class AccessControlTest:
    def __init__(self):
        self.public_value = 3
        self.__private_value = 7

    def print_info(self):
        print("나는 private도 출력할 수 있어:", self.__private_value)


class OpOverload(object):
    def __init__(self, number):
        self.__number  = number

    def __repr__(self):
        print("__repr__이 호출됨")
        return str(self.__number)

    def __add__(self, other):
        print("__add__가 호출됨")
        return OpOverload(self.__number + other.get_number())

    def __sub__(self, other):
        print("__sub__이 호출됨")
        return OpOverload(self.__number - other.get_number())

    def get_number(self):
        return self.__number


from datetime import date
# 예약을 걸어놓고 2-3일 전에 취소가 가능하다 하면 시간계산이 필요


def class_test_function():
    p = Person()
    p.print_info()

    p.name = "이거 된다"
    p.print_info()

    # 이딴 것도 되는데 쓰면 안됩니다
    # - 협업할 때 혼동될 우려가 큼
    Person.title = "이것도 된다"
    print('이게 되네?', p.title)

    test = NonSelfTest()
    test.set_test_str("내가 간드악!")
    test.print_info()

    v = Vehicles(70)
    # 소멸자 첫번째꺼는 () 빈칸이어야 호출되는데
    # 두번째꺼는 () 안에 숫자를 넣어줘야 호출됨

    print("응 아직 소멸자 호출 안돼!")
    # 얘가 먼저 출력되고 막판에 소멸자가 호출됨
    # 소멸자 호출하면서 이런 객체들 정리해주세요 하고 요청하는 것
    # 프로젝트가 커지면 쓸 일이 생길 수 있다고는 하는데
    # 지금은 딱히 쓸 일이 없어보임

    access_test = AccessControlTest()
    print(access_test.public_value)
    # print(access_test.__private_value)
    # public은 호출되는데 private는 오류
    # private이기 때문
    # private에 접근하려면 어떻게 해줬는가?
    # method 자체에서 출력하는걸 만들어줬어야 함
    access_test.print_info()

    obj1 = OpOverload(10)
    obj2 = OpOverload(33)

    print(obj1 + obj2)
    print(obj1 - obj2)
    # 이걸 가지고 할 수 있는건?
    # 이 클래스에 어떤 사용자들의 정보가 있음
    # 그룹 전체가 가진 금액을 계산할 수 있겠다

    # 이런걸 서포트하는게 OpOverload 오버로딩
    # 객체의 연산을 도와줌

    remain_date = date.today()
    changeable_date = date(2023, 5, 26)
    print(changeable_date - remain_date)
