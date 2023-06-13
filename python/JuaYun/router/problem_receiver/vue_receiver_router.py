import random

from fastapi import APIRouter

problem_receiver = APIRouter()

@problem_receiver.get("/request-int-prob")
async def request_integer_data():
    return random.randrange(10, 20)

@problem_receiver.get("/request-vue-int-prob")
async def request_integer_data():
    return random.randrange(15, 20)

