from fastapi import Depends, FastAPI
from router.request_receiver.request_receive_router import request_receiver
from router.machine_learning.ml_router import ml_router

from basics.basic_grammar import python_basics
from basics.python_class import class_test_function
from basics.python_functions import functions_test
from basics.thread_test import thread_test_sequence
from homework.thread_homework import thread_homework


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    # python_basics()
    # functions_test()
    # class_test_function()
    # thread_test_sequence()
    # thread_homework()
    print("Hello")

app = FastAPI()
origins = ["http://localhost:8080"]
from fastapi.middleware.cors import CORSMiddleware
app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}


app.include_router(request_receiver)
app.include_router(ml_router)