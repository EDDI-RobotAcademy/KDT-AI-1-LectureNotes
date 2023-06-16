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

loaded_model = load_model("homework_salary_model.h5")

signal_mapping = {signal: i for i, signal in enumerate(signals)}

sample_number = 1000
correct_predicitions = 0
for _ in range(sample_number):
    test_signal = random.randint(salary_min, salary_max)
    test_signal = test_signal // 1000000 * 1000000 # 백만 단위로 반올림해주기
    mapped_test_signal = signal_mapping[int(test_signal)]
    test_signal_encoded = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))

    predictions = loaded_model.predict(test_signal_encoded)
    predicted_action_index = np.argmax(predictions)
    # numpy.argmax(): 가장 높은 확률을 갖는 값을 반환해라
    predicted_action = actions[predicted_action_index]

    print("테스트 항목:", test_signal)
    print("예측된 상태:", predicted_action)

    if predicted_action == "간다" and test_signal >= salary_minimum_condition:
        correct_predicitions += 1
    elif predicted_action == "안간다" and test_signal < salary_minimum_condition:
        correct_predicitions += 1
    # 적중률을 높이는 if문

accuracy = correct_predicitions / sample_number
print("추론 적중률:", accuracy)

# 결과
# 1/1 [==============================] - 0s 15ms/step
# 테스트 항목: 37000000
# 예측된 상태: 간다
# 1/1 [==============================] - 0s 17ms/step
# 테스트 항목: 35000000
# 예측된 상태: 간다
# 1/1 [==============================] - 0s 15ms/step
# 테스트 항목: 39000000
# 예측된 상태: 간다
# 추론 적중률: 1.0

# for문 안에서 돌리면 각각의 테스트에 대한 결과를 볼 수 있다
# 추론 적중률도 출력하여 확인할 수 있음!