from fastapi import APIRouter
import random
import numpy as np
from keras.models import load_model

request_receiver = APIRouter()

@request_receiver.get("/request-data")
async def receive_spring_data():
    print("Receive Spring Data!")
    ready_asset = { 'name': 'Hi', 'major': 'C' }
    return ready_asset

@request_receiver.get("/request-int-data")
async def request_integer_process():
    return random.randrange(10,21)

# 아래 두 개는 과제
@request_receiver.get("/request-second-data")
async def request_second_number_process():
    return random.randrange(1,10)

@request_receiver.get("/request-third-data")
async def request_second_number_process():
    return random.randrange(1,10)

@request_receiver.get('/integer-request')
async def integer_request_receiver():
    return random.randrange(15, 21)

@request_receiver.get("/request-ai-choice")
async def request_ai_choice(receivedDataFromVue):
    loaded_model = load_model("ai_salary_model.h5")
    actions = ["입사", "거절"]
    predictions = loaded_model.predict(receivedDataFromVue)
    predicted_action_index = np.argmax(predictions)
    predicted_action = actions[predicted_action_index]

    print("제안연봉: ", receivedDataFromVue)
    print("예측된 AI 선택: ", predicted_action)

    return predicted_action
