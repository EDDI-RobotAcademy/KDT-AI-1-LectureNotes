from fastapi import APIRouter
import numpy as np
from keras.models import load_model
import keras

vue_keras_fastapi = APIRouter()


@vue_keras_fastapi.get("/keras-test")
async def kerasData_toVue():
    loaded_model = load_model("./utility/deep_learning/homework/keras_model.h5")

    min_salary_amount = 3000
    max_salary_amount = 4000
    step_size = 100

    salary_amounts_range = np.arange(min_salary_amount, max_salary_amount + step_size, step_size)
    num_classes = len(salary_amounts_range) - 1

    salarys = salary_amounts_range  # x
    actions = ["간다", "안간다"]  # y

    for i in range(3):
        salary = np.random.choice(salarys)

        test_salary = salary
        signal_mapping = {signal: i for i, signal in enumerate(salarys)}
        mapped_test_signal = signal_mapping[test_salary]
        encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(salarys))

        predictions = loaded_model.predict(encoded_test_signal)
        predicted_action_index = np.argmax(predictions)
        predicted_action = actions[predicted_action_index]

    info1 = "테스트 신호: " + str(test_salary)
    info2 = "예측된 입사형태: " + str(predicted_action)
    ready_asset = {"info1": info1, "info2": info2}
    print(ready_asset)
    # print(json.dumps(ready_asset))
    return ready_asset
