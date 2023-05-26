from basics.basic_grammar import python_basics
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from basics.thread_test import thread_test_sequence
from problem.advanced_multi_process import adv_parallel_process_problem
from problem.gas_station_prob import gas_station_problem_solve
from problem.parallel_process import parallel_process_problem
from router.request_receiver.request_receive_router import request_receiver

from fastapi import Depends, FastAPI

def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.

# if __name__ == '__main__':
    # python_basics()
    # functions_test()
    # gas_station_problem_solve()
    # class_test_function()
    # thread_test_sequence()
    # parallel_process_problem()
    # adv_parallel_process_problem()

app = FastAPI()

# 데이터를 외부에서 가져옴 (파이썬, 스프링)
# 뷰에서 버튼을 누를때 웹으로 전송이 되는데
# 스프링에서는 콘피그를 만들어서 방어해줌?
#
origins = {"http://localhost:8080"}
from fastapi.middleware.cors import CORSMiddleware
app.add_middleware(
    CORSMiddleware,
    allow_origins

)

@app.get("/")
async def root_index():
    return { "message": "Hello from FastAPI" }

app.include_router(request_receiver)