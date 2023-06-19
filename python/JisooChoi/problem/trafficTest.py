import random

from fastapi import APIRouter

traffic_test = APIRouter()

@traffic_test.get("/request-random-data")
async def request_random_data():
    print("request_random_data")
    return random.randrange(10, 21)

@traffic_test.get("/vue-fastapi")
async def request_direct_random_data():
    print("request_direct_random_data")
    return random.randrange(15, 21)