class Person:
    name = "기본값"

    def print_info(self):
        print("내 이름은 {0}".format(self.name))


test_str = "나는 클래스 멤버 변수가 아니야!"

from datetime import date

class Vehicles:
    # def __init__(self):
    #   print("나는 기본 생성자야")
    def __init__(self, speed):
        self.speed = speed
        print("나는 파라매터를 가진 생성자야!->", self.speed)

    def __del__(self):
        print("나는 소멸자야")
        # 소멸자란 무엇인가? 필요없을때 힙의 메모리를 날려버린다.
        # 그걸 언제 판다하지?


class OpOverload(object):
    def __init__(self, number):
        self.__number = number

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

class AccessControlTest:
    def __init__(self):
        self.public_value = 3
        self.__value = 7

    def print_info(self):
        print(self.__value)


class NonSelfTest:
    test_str = ""

    def set_test_str(self, msg):
        print(test_str)
        print(self.test_str)

    def print_info(self):
        print(test_str)
        print(self.test_str)


def class_test_function():
    p = Person()
    p.print_info()

    p.name = "국도"
    p.print_info()

    test = NonSelfTest()
    test.set_test_str("내가 간다")
    test.print_info()

    v = Vehicles(70)
    print("응 아직 안돼!")

    access_test = AccessControlTest()
    print(access_test.public_value)
    # print(access_test.__value)
    # __를 붙여주면 PRIVATE이다.
    access_test.print_info()

    obj1 = OpOverload(10)
    obj2 = OpOverload(33)

    print(obj1 + obj2)
    print(obj1 - obj2)

    remain_date = date.today()
    changeable_date=date(2023,5,26)
    print(changeable_date-remain_date)
    print(remain_date)