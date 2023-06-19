import random

from fastapi import APIRouter

prb3 = APIRouter()

@prb3.get("/request-second-num")
async def go_spring_process():
    return random.randrange(10, 20)

@prb3.get("/request-third-num")
async def go_vue_process():
    return random.randrange(15, 20)