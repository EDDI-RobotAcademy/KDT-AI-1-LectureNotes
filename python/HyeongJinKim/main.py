from fastapi import Depends, FastAPI

from basics.basic_grammer import python_basics
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from basics.therad_test import thread_test_sequence
from problem.python_problem1 import coordinate
from problem.python_problem2_advenced import adv_parallel_process_problem
from problem.python_problem2 import parallel_process_problem
from router.request_receiver.request_receive_router import request_receiver


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.
# Press the green button in the gutter to run the script.

# if __name__ == '__main__':
    # python_basics()
    # functions_test()
    # coordinate(3)
    # class_test_function()
    # thread_test_sequence()
    # parallel_process_problem()
    # adv_parallel_process_problem()


app = FastAPI()


@app.get("/")
async def root_index():
    return { "message": "Hello from FastAPI" }


app.include_router(request_receiver)