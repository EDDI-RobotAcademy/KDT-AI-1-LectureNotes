# This is a sample Python script.
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from homework.homework_keras.keras_salary_inference import keras_salary_inference
from homework.homework_third import vsf_receive
from router.machine_learning.ml_router import ml_router
from router.request_receiver.request_receive_router import request_receiver


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
# thread_test_sequence()
# homework2()
# parallel_process_problem()
# adv_parallel_process_problem()

app = FastAPI()

origins = ["http://localhost:8080"]
           # "http://localhost:8081"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}


# 여기에 좌르륵 쓰기에 더러워 보이니까 이쁘게 패키지 안에 넣자
app.include_router(request_receiver)
app.include_router(vsf_receive)
app.include_router(ml_router)
app.include_router(keras_salary_inference)
