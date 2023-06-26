from fastapi import APIRouter
import random

homework_request = APIRouter()

@homework_request.get("/request-pass-string")
async def receive_pass_spring():
    return random.randrange(1, 21)

@homework_request.get("/request-python")
async def receive_from_python():
    return random.randrange(15, 21)