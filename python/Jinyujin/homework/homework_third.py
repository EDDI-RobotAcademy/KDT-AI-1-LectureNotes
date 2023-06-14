import fastapi
from fastapi import APIRouter
import random

vsf_receive = APIRouter()


@vsf_receive.get("/request_second_number")
async def request_second_number():
    return random.randrange(10, 21)


@vsf_receive.get("/request_third_number")
async def request_third_number():
    return random.randrange(15, 21)
