class Person:
    name = "기본값"

    def print_info(self):
        print("내 이름은 {0}".format(self.name))

test_str = "나는 클래스 멤버 변수가 아니야!"

class NonSelfTest:
    test_str = ""

    def set_test_str(self, msg):
        self.test_str = msg

    def print_info(self):
        print(test_str)
        print(self.test_str)

class Vehicles:
    # def __init__(self):
    #     print("나는 기본 생성자야!")

    def __init__(self, speed):
        self.speed = speed
        print("나는 파라메터를 가진 생성자야! ->", self.speed)

    def __del__(self):
        print("처음 들어봤지 ? 난 소멸자야!")

class AccessControllerTest:
    def __init__(self):
        self.public_value = 3
        self.__private_value = 7

    def print_info(self):
        print("나는 private도 출력할 수 있어: ", self.__private_value)

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

from datetime import date

def class_test_function():
    p = Person()
    p.print_info()

    p.name = "이거 된다"
    p.print_info()

    Person.title = "이거도 된다"
    print('이게 되네 ?', p.title)

    test = NonSelfTest()
    test.set_test_str("내가 간드앗!")
    test.print_info()

    v = Vehicles(70)
    print("응 아직 소멸자 호출 안돼!")

    access_test = AccessControllerTest()
    print(access_test.public_value)
    #print(access_test.__private_value)
    access_test.print_info()

    obj1 = OpOverload(10)
    obj2 = OpOverload(33)

    print(obj1 + obj2)
    print(obj1 - obj2)

    remain_date = date.today()
    changeable_date = date(2023, 5, 26)
    print(changeable_date - remain_date)