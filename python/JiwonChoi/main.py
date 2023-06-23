from basics.basic_grammer import python_basics
from basics.python_function import function_test

from fastapi import Depends, FastAPI

from router.request_receiver.request_receiver_router import request_receiver
from notification.email.email_notification_router import email_notification_router

from basics.thread_test import thread_test_sequence
from notification.email.email_notification_router import email_notification_router

from fastapi import Depends, FastAPI
from router.machine_learning.ml_router import ml_router

from fastapi.middleware.cors import CORSMiddleware


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# if __name__ == '__main__':
#     # python_basics()
#     # function_test()
#     print("Hi")


app = FastAPI()


@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}


# 예쁘게 처리하는 방법??
app.include_router(request_receiver)
app.include_router(ml_router)
app.include_router(email_notification_router)
