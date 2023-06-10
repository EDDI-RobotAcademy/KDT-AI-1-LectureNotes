import keras.utils
import numpy as np
from fastapi import APIRouter
from keras.models import load_model
from starlette.responses import JSONResponse

keras_salary_inference = APIRouter()


@keras_salary_inference.get("/test-salary")
async def return_test_salary():
    min_proposal_salary = 30000000
    max_proposal_salary = 40000000
    step_size = 1000000
    proposals = np.arange(min_proposal_salary, max_proposal_salary + step_size, step_size)

    test_salary = np.random.choice(proposals)

    return test_salary


@keras_salary_inference.get("/keras")
async def return_predicted_action():
    min_proposal_salary = 30000000
    max_proposal_salary = 40000000
    step_size = 1000000
    proposals = np.arange(min_proposal_salary, max_proposal_salary + step_size, step_size)

    salary_model = load_model("homework_salary_model.h5")

    test_salary = await return_test_salary()

    salary_mapping = {proposal: i for i, proposal in enumerate(proposals)}
    mapped_test_salary = salary_mapping[test_salary]
    encoded_test_salary = keras.utils.to_categorical([mapped_test_salary], num_classes=len(proposals))

    actions = ["간다", "안 간다"]

    prediction = salary_model.predict(encoded_test_salary)
    predicted_class = np.argmax(prediction)
    predicted_action = actions[predicted_class]

    return predicted_action


