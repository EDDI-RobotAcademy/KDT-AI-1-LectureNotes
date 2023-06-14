from problem.problemBank1 import gas_station_problem_solve
from problem.problemBank2 import num_plus
from basics.python_class import class_test_function
from basics.thread_test import thread_test_sequence

from fastapi import Depends, FastAPI

from router.request_receiver.request_receive_router import request_receiver

# if __name__ == '__main__':
# python_basics()
# functions_test()
# gas_station_problem_solve()
# class_test_function()
# num_plus()

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