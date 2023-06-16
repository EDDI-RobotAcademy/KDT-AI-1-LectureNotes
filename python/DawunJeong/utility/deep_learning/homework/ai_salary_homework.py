import numpy as np
from keras.models import Sequential
from keras.layers import Dense
from tensorflow import keras

# 난수가 아닌 몇 개의 값을 설정해서 테스트 했을 때
# signals = [2800, 3200, 2500, 3800, 3900]

# 3000 ~ 4000만 원 사이의 값
min_salary = 30000000
max_salary = 40000000
step_size = 1000000

# 3000 ~ 4000만 원까지 100만 원 단위로 배열 생성
salary_amounts_range = np.arange(min_salary, max_salary + step_size, step_size)
num_classes = len(salary_amounts_range) - 1
print(len(salary_amounts_range))

# AI의 선택은 두 가지(입사 혹은 거절)
actions = ["입사", "거절"]

data = []
labels = []

# 데이터 만들기
# 100번 반복하면서 생성된 11개의 salary를 signal로 설정하고
# 이에 따른 action을 대입해준다.
# 3500만 원 이하일 때 "거절"
# 3500만 원 이상일 때 "입사"
for _ in range(100):
    signal = np.random.choice(salary_amounts_range)
    if signal < 35000000:
        action = "거절"
    else:
        action = "입사"

    data.append(signal)
    labels.append(action)

signal_mapping = {signal: i for i, signal in enumerate(salary_amounts_range)}
mapped_data = [signal_mapping[signal] for signal in data]
print(mapped_data)

ai_actions_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [ai_actions_mapping[action] for action in labels]
print(mapped_labels)

encoded_offer_salary = keras.utils.to_categorical(mapped_data, num_classes=len(salary_amounts_range))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
print(encoded_offer_salary)
print(encoded_action)

# 모델 만들기
model = Sequential()
model.add(Dense(32, input_dim=len(salary_amounts_range), activation="relu"))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

# 학습 시키기, epochs에 설정된 값이 학습 횟수
model.fit(encoded_offer_salary, encoded_action, epochs=10000, batch_size=32)

model.save("ai_salary_model.h5")

# 테스트
# 1번 방식
# offer_salary = 38000000

# 2번 방식
offer_salary = np.random.choice(salary_amounts_range)

mapped_test_signal = signal_mapping[offer_salary]
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(salary_amounts_range))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("제안연봉: ", offer_salary)
print("예측된 AI 선택: ", predicted_action)