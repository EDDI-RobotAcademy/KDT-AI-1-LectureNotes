import random

from fastapi import APIRouter

request_receiver = APIRouter()

# => Python 으로 Controller 를 만들었다.
@request_receiver.get("/request-data")
async def receiver_spring_data():
    print("Receiver Spring Data!")
    ready_asset = { 'name': 'Hi', 'major': 'C' }
    return ready_asset

@request_receiver.get("/request-int-data")
async def request_integer_process():
    return random.randrange(3, 7)