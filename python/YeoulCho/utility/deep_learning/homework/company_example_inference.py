import numpy as np
from keras.models import Sequential, load_model
import keras

loaded_model = load_model("keras_model.h5")

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

    print("테스트 신호:", test_salary)
    print("예측된 입사 상태:", predicted_action)