# This is a sample Python script.
from fastapi import FastAPI

from request_receiver.request_receive_router import request_receiver


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

# parallel_process_problem


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.


if __name__ == '__main__':
    print_hi('PyCharm')
    print("Hello Python!")
# python_basics()
# functions_test()

# gas_station_problem_solve()
# class_test_function()
# thread_test_sequence()
# parallel_process_problem()
# adv_parallel_process_problem()

app = FastAPI()


@app.get("/")
async def root_index():
    return {"message": "Hello from FastAPI"}


app.include_router(request_receiver)
