from basics.basic_grammar import python_basics
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from basics.thread_test import thread_test_sequence
from problem.advanced_multi_process import adv_parallel_process_problem
from problem.gas_station_prob import gas_prob, gas_station_problem_solve

from fastapi import Depends, FastAPI

from router.request_receiver.request_receiver_router import request_receiver


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
# if __name__ == '__main__':
    # python_basics()
    # functions_test()
    # class_test_function()
    # gas_station_problem_solve()
    # thread_test_sequence()
    # parallel_process_problem()
    # adv_parallel_process_problem()

app = FastAPI()


@app.get("/")
async def root_index():
    return { "message": "Hello from FastAPI" }


# 파이썬 도메인 분리를 위한 코드
app.include_router(request_receiver)