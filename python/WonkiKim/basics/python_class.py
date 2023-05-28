class Person:
    name = "default"

    def print_info(self):
        print("my name is {0}".format(self.name))

test_str = "나는 클래스 멤버 변수가 아니야!"

class NonSelfTest:
    test_str = ""

    def set_test_str(self, msg):
        self.test_str = msg

    def print_info(self):
        print(test_str)
        print(self.test_str)

class Vehicles:

    def __init__(self, value):
        print("나는 기본 생성자야!")
    # def __init__(self, value):
        self.value = value
        print("나는 파라메터를 가진 생성자야! -> ", self.value)

    def __del__(self):
        print("this is destructor")

class AccessControleTest:
    def __init__(self):
        self.public_value = 3
        self.__private_value = 7
    def getPrivate_value(self):
        return self.__private_value

class OpOverload(object):
    def __init__(self, number):
        self.__number = number

    def __repr__(self):
        print("__repr__이 호출됨")
        return str(self.__number)

    def __add__(self, other):
        print("__add__가 호출 됨")
        return OpOverload(self.__number + other.get_number())

    def __sub__(self, other):
        print("__sub__")
        return OpOverload(self.__number - other.get_number())

    def get_number(self):
        return self.__number

from datetime import date
def class_testfunction():
    p = Person()
    p.print_info()

    p.name = "do it"
    p.print_info()

    pp = Person()
    pp.print_info()

    Person.title = "new title"
    print(p.title)

    test = NonSelfTest()
    test.set_test_str("내가 간다")
    test.print_info()

    v = Vehicles(123)
    print("아직 소멸자는 호출 안됨")

    ac = AccessControleTest();
    print(ac.public_value)
    print(ac.getPrivate_value())

    obj1 = OpOverload(10)
    obj2 = OpOverload(32)

    print(obj1 + obj2)
    print(obj1 - obj2)

    remain_date  = date.today()
    changeable_date = date(2023, 5, 26)
    print( changeable_date-remain_date)
