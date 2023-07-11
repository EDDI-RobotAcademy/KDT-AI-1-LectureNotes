import random

from fastapi import APIRouter

request_receiver = APIRouter()


@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = {'name': 'Hi', 'major': 'C'}
    return ready_asset


@request_receiver.get("/request-int-data")
async def request_integer_process():
    return random.randrange(3, 7)


@request_receiver.get("/request-int-second")
async def request_integer_second():
    return random.randrange(10, 20)


@request_receiver.get("/request-int-third")
async def request_integer_third():
    return random.randrange(15, 20)
