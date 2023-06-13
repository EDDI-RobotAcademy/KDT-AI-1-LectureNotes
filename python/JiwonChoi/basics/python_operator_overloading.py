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

def op_overloading_test_function():
    obj1 = OpOverload(10)
    obj2 = OpOverload(33)

    print(obj1 + obj2)
    print(obj1 - obj2)

if __name__ == '__main__':
    op_overloading_test_function()