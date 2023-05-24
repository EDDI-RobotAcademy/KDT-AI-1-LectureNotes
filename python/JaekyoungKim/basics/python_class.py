class Person:
    name= "기본값"

    def print_info(self):
        print("내 이름은 {0}".format(self.name))

test_str="나는 클래스 멤버 변수가 아니야!"


class Vehicles:
    #def __init__(self):
     #   print("나는 기본 생성자야")
    def __init__(self,speed):
        self.speed=speed
        print("나는 파라매터를 가진 생성자야!->", self.speed)

    def __del__(self):
        print("나는 소멸자야")
        #소멸자란 무엇인가? 필요없을때 힙의 메모리를 날려버린다.
        # 그걸 언제 판다하지?

class NonSelfTest:
    test_str=""

    def set_test_str(self,msg):
        print(test_str)
        print(self.test_str)
    def print_info(self):
        print(test_str)
        print(self.test_str)
def class_test_function():
    p = Person()
    p.print_info()

    p.name="국도"
    p.print_info()

    test=NonSelfTest()
    test.set_test_str("내가 간다")
    test.print_info()

    v=Vehicles(70)
    print("응 아직 안돼!")