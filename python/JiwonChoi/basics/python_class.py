class Person:
    name = "기본값"

    def print_info(self):
        print("내 이름은 {0}".format(self.name))


test_str = "나는 클래스 멤버 변수가 아니야!"

class NonSelfTest:
    test_str = "-"

    def set_test_str(self, msg):
        self.test_str = msg

    def print_info(self):
        print(test_str) #나는 클래스 멤버 변수가 아니야!
        print(self.test_str) #내가 간드앗!


class Vehicles:
    #def __init__(self):
    #    print("나는 기본 생성자야!")

    def __init__(self, speed):
        self.speed = speed
        print("나는 파라메터를 가진 생성자야! ->", self.speed)


    def __del__(self):
        print("처음 들어봤지 ? 난 소멸자야!")


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


    v0 = Vehicles(70)
    print("응 아직 소멸자 호출 안돼!")

    v1 = Vehicles(71)
    print("응 아직 소멸자 호출 안돼!")

    v2 = Vehicles(72)
    print("응 아직 소멸자 호출 안돼!")
# 나는 파라메터를 가진 생성자야! -> 70
# 응 아직 소멸자 호출 안돼!
# 나는 파라메터를 가진 생성자야! -> 71
# 응 아직 소멸자 호출 안돼!
# 나는 파라메터를 가진 생성자야! -> 72
# 응 아직 소멸자 호출 안돼!
# 처음 들어봤지 ? 난 소멸자야!     <<<<왜 소멸자는 마지막에 몰아서 동작함??
# 처음 들어봤지 ? 난 소멸자야!
# 처음 들어봤지 ? 난 소멸자야!


if __name__ == '__main__':
    class_test_function()