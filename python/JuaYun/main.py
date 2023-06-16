from notification.email.email_notification_router import email_notification_router
from problem.teacher.advanced_multi_process import adv_parallel_process_problem
from problem.thread_prob import All_add_process

from fastapi import Depends, FastAPI

from router.machine_learning.ml_router import ml_router
from router.problem_receiver.vue_receiver_router import problem_receiver
from router.request_receiver.request_receive_router import request_receiver


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
# if __name__ == '__main__':
    # python_basics()
    # functions_test()
    # gas_station_problem_solve()
    # class_test_function()
    # thread_test_sequence()
    # All_add_process()
    # adv_parallel_process_problem()

app = FastAPI()


@app.get("/")
async def root_index():
    return { "message": "Hello fro, FastAPI" }

app.include_router(request_receiver)
app.include_router(problem_receiver)
app.include_router(ml_router)
app.include_router(email_notification_router)