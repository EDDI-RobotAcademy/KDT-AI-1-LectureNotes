from fastapi import APIRouter
import random

request_receiver = APIRouter()


@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = {'name': 'Hi', 'major': 'C'}
    return ready_asset


@request_receiver.get("/request-int-data")
async def request_integer_process():
    return random.randrange(1, 10)

@request_receiver.get("/request-random-number")
async def request_random_number():
    return random.randrange(10, 20)
@request_receiver.get("/request-random-number-directly")
async def request_random_number():
    return random.randrange(15, 20)