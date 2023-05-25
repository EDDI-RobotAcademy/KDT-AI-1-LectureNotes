from fastapi import APIRouter

request_receiver = APIRouter()

@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive_Spring_Data!")
    ready_asset = { 'name': 'Hi', 'major': 'C' }
    return ready_asset