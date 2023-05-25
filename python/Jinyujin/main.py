# This is a sample Python script.
from basics.basic_grammar import python_basics
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from basics.thread_test import thread_test_sequence
from router.request_receiver.request_receive_router import request_receiver
from solved.homework_first import gas_station_problem_solve
from homework.homework_second import homework2
from solved.homework_second.advanced_homework_second import adv_parallel_process_problem
from solved.homework_second.homework_second import parallel_process_problem

from fastapi import Depends, FastAPI


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
# if __name__ == '__main__':
# print_hi('PyCharm')
# python_basics()
# functions_test()
# gas_station_problem_solve()
# class_test_function()
# # thread_test_sequence()
# # homework2()
# parallel_process_problem()
# adv_parallel_process_problem()

app = FastAPI()


# See PyCharm help at https://www.jetbrains.com/help/pycharm/

@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}


app.include_router(request_receiver)
# 여기에 좌르륵 쓰기에 더러워 보이니까 이쁘게 패키지 안에 넣자
