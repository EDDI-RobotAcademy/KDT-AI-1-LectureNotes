import random

from fastapi import APIRouter

request_receiver = APIRouter()


@request_receiver.get("/request_data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = {'name': 'Hi', 'major': 'C'}
    return ready_asset


# Integer에 대응하는 라우터
@request_receiver.get("/request_int_data")
async def request_integer_process():
    return random.randrange(1, 10)
