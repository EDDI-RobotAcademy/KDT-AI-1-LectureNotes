from basics.basic_grammer import python_basics
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from basics.thread_test import thread_test_sequence
from problem.advanced_multi_process import adv_parallel_process_problem
from problem.gas_station_prob import gas_station_problem_solve
from problem.number_add_prob import number_add_prob_process
from problem.parallel_process import parallel_process_problem
from notification.email.email_notification_router import email_notification_router

from fastapi import Depends, FastAPI

from router.machine_learning.ml_router import ml_router
from router.request_receiver.request_receive_router import request_receiver

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


# def print_hi(name):
#     # Use a breakpoint in the code line below to debug your script.
#     print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
# if __name__ == '__main__':
#     # python_basics()
#     # functions_test()
#     #gas_station_problem_solve()
#     # class_test_function()
#     #thread_test_sequence()
#     #number_add_prob_process()
#     #parallel_process_problem()
#     #adv_parallel_process_problem()
#     print("hi")

app = FastAPI()

@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}

app.include_router(request_receiver)
app.include_router(ml_router)
app.include_router(email_notification_router)