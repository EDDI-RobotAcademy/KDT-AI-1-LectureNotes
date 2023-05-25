from fastapi import APIRouter
import random

request_receiver = APIRouter()

# 파이썬으로 컨트롤러 한 것
# 요청
@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = { 'name': 'Hi', 'major': 'C' }
    return ready_asset

@request_receiver.get("/request-int-data")
async def request_integer_process():
    return random.randrange(3, 7)