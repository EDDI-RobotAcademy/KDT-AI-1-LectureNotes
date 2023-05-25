# This is a sample Python script.
from fastapi import FastAPI

from basics.basic_grammer import python_basics
from basics.python_class import class_test_function, AccessControlTest
from basics.python_function import functions_test
from basics.thread_test import thread_test_sequence
from problem.Q2_thread import perform_add_process, perform_add_process_lock
from problem.gas_station_prob import gas_station_problem_solve
from router.request_receiver.request_receiver_router import request_receiver


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':

    #python_basics()
    #functions_test()
    # gas_station_problem_solve()
    # class_test_function()
    # AccessControlTest()

    #thread_test_sequence()
    # perform_add_process()
    #perform_add_process_lock()
    print("hi")

app = FastAPI()
@app.get("/")
async def root_index():
    return {"message": "Hello from FASTAPI"}

app.include_router(request_receiver)