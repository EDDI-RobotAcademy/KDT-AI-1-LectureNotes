class AccessControlTest:
    def __init__(self):
        self.public_value = 3
        self.__private_value = 7

    def print_info(self):
        print("나는 private도 출력할 수 있어:", self.__private_value)

def access_modifier_test_function():
    access_test = AccessControlTest()
    print(access_test.public_value)
    #print(access_test.__private_value) <<동작안됨
    access_test.print_info()

if __name__ == '__main__':
    access_modifier_test_function()