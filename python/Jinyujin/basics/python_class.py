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
        print(test_str)
        print(self.test_str)
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

# 우리가 자바에서 생성자를 가지고 한 것은?
# 초기값 세팅
# 지금도 생성자에서 초기값을 세팅함

    def __del__(self):
        print("처음 들어봤지? 난 소멸자야!")
# 소멸자가 뭘까?
# 지금 우리가 생성자를 통해 만들어진 객체를 v에 대입함
# 지금은 v로 만들어진 지역변수가 만들어짐
# 이 지역 변수가 쓸모없어질 때 -> 날려버릴 수 있는 소멸자


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
    print("응 아직 소멸자 호출 안돼!")
    # 얘가 먼저 출력되고 막판에 소멸자가 호출됨
    # 소멸자 호출하면서 이런 객체들 정리해주세요 하고 요청하는 것