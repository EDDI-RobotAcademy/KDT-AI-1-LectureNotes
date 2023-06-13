# This is a sample Python script.
from fastapi import FastAPI

from Homework.Homework1 import Homework1
from Homework.advanced_multi_process import adv_parallel_process_problem
from Homework.parallel_process import parallel_process_problem
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from basics.basic_grammar import python_basics
from basics.thread_test import thread_test_sequence
from notification.email.email_notification_router import email_notification_router

from router.machine_learning.ml_router import ml_router

from router.request_receiver.request_receive_router import request_receiver


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

    print("hello python!")

    # python_basics()

    # functions_test()

    # Homework1()
    # class_test_function()
    # thread_test_sequence()
    # adv_parallel_process_problem()
    # parallel_process_problem()
app = FastAPI()


@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}

app.include_router(email_notification_router)


app.include_router(request_receiver)

app.include_router(ml_router)