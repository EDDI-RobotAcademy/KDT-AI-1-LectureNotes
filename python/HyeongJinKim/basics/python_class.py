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
    #def __init__(self):
    #    print("나는 기본 생성자야!")

    def __init__(self, speed):
        self.speed = speed
        print("나는 파라메터를 가진 생성자야! ->", self.speed)


    def __del__(self):
        print("처음 들어봤지 ? 난 소멸자야!")


class AccessControlTest:
    def __init__(self):
        self.public_value = 3
        self.__private_value = 7

    def print_info(self):
        print("나는 private도 출력할 수 있어:", self.__private_value)


def class_test_function():
    p = Person()
    p.print_info()

    p.name = "이거 된다"
    p.print_info()

    # 이딴 것도 되는데 쓰면 안됩니다
    Person.title = "이것도 된다"
    print('이게 되네 ?', p.title)

    test = NonSelfTest()
    test.set_test_str("내가 간드앗!")
    test.print_info()

    v = Vehicles(70)
    print("응 아직 소멸자 호출 안돼!")

    access_test = AccessControlTest()
    print(access_test.public_value)
    # print(access_test.__private_value)
    access_test.print_info()
