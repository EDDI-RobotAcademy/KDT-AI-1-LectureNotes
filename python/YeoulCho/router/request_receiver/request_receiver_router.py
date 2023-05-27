import random

from fastapi import APIRouter

request_receiver = APIRouter()

@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = { 'name':'hi', 'major': 'c'}
    return ready_asset

@request_receiver.get("/request-int-data")
async def receive_integer_process():
    return random.randrange(0,10)