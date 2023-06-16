import os.path

from fastapi import APIRouter
import numpy as np
from keras.models import load_model
from tensorflow import keras

homework_router = APIRouter()

@homework_router.get("/get-ai-choice")
async def receive_ai_choice(received_salary_from_vue: str):
    print("vue에서 받은 값" + received_salary_from_vue)
    model_path = os.path.abspath("utility/deep_learning/homework/ai_salary_model.h5")
    loaded_model = load_model(model_path)

    min_salary = 30000000
    max_salary = 40000000
    step_size = 1000000

    salary_amounts_range = np.arange(min_salary, max_salary + step_size, step_size)

    signal_mapping = {signal: i for i, signal in enumerate(salary_amounts_range)}
    mapped_test_signal = signal_mapping[(int(received_salary_from_vue))]
    encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(salary_amounts_range))

    actions = ["입사", "거절"]

    prediction = loaded_model.predict(encoded_test_signal)
    predicted_class = np.argmax(prediction)
    action = actions[predicted_class]
    return action