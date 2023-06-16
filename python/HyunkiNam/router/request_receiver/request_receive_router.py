from fastapi import APIRouter
import random
request_receiver = APIRouter()


@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = {'name': 'Hi', 'major': 'C'}
    return ready_asset


@request_receiver.get("/request-int-data")
async def receive_integer_data():
    print("Receive Integer Data!")
    return random.randrange(10,20)

@request_receiver.get("/request-int-data-to-vue")
async def receive_vue_data():
    print("Receive Vue Data!")
    return random.randrange(15,20)
