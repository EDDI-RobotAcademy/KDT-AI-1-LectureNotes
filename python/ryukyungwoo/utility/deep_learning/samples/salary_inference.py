import random

import numpy as np
from keras.models import load_model
from tensorflow import keras

salary_min = 30000000
salary_max = 40000001
salary_step = 1000000

salary_minimum_condition = 35000000

signals = list(range(salary_min, salary_max, salary_step))
actions = ["간다", "안간다"]

data = []
labels = []

loaded_model = load_model("salary_model.h5")

sample_number = 1000
for _ in range(sample_number):
    signal = np.random.choice(signals)
    if signal >= salary_minimum_condition:
        action = "간다"
    else:
        action = "안간다"

    data.append(signal)
    labels.append(action)

signal_mapping = {signal: i for i, signal in enumerate(signals)}
# 리스트로 되어있는 signals를 key, value값을 가진 딕셔너리로 바꾸기 위한 작업
mapped_data = [signal_mapping[signal] for signal in data]
# 딕셔너리로 바꿔진 signal로 data를 찾아서 key를 가져와 mapped_data에 매핑
print(signal_mapping)

vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [vehicle_action_mapping[action] for action in labels]

encoded_traffic_light = keras.utils.to_categorical(mapped_data, num_classes=len(signals))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))

sample_number = 1000
correct_predicitions = 0
for _ in range(sample_number):
    test_signal = random.randint(salary_min, salary_max)
    test_signal = test_signal // 1000000 * 1000000
    mapped_test_signal = signal_mapping[int(test_signal)]
    test_signal_encoded = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))
    predictions = loaded_model.predict(test_signal_encoded)
    predicted_action_index = np.argmax(predictions)
    predicted_action = actions[predicted_action_index]

    print("테스트 항목:", test_signal)
    print("예측된 상태:", predicted_action)

    if predicted_action == "간다" and test_signal >= salary_minimum_condition:
        correct_predicitions += 1
    elif predicted_action == "안간다" and test_signal < salary_minimum_condition:
        correct_predicitions += 1

accuracy = correct_predicitions / sample_number
print("추론 적중률:", accuracy)