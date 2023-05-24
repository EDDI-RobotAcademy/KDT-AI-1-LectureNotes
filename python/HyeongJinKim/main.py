from basics.basic_grammer import python_basics
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from problem.python_problem import coordinate


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    python_basics()
    functions_test()

    coordinate(3)

    class_test_function()