# This is a sample Python script.
from fastapi import Depends, FastAPI

from basics.basic_grammar import python_basics
from basics.python_class import class_testfunction
from basics.python_function import functions_test
from basics.thread_test import thread_test_sequence, perform_process, perform_process_lock, advanced_perform_process
from router.request_receiver.request_receive_router import request_receiver


# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press ⌘F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
#     # python_basics()
#     # functions_test();
#     # class_testfunction();
#     # thread_test_sequence()
#     # for i in range(10):
#         # perform_process()
#         # perform_process_lock()
#         # advanced_perform_process()
        print("hi")


app = FastAPI()


@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}

app.include_router(request_receiver)
