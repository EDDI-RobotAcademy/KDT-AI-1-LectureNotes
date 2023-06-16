# 컴퓨터가 갈 연봉: 3500만원 이상
# 회사들의 제안: 3000 ~ 4000만원
# 간다, 안 간다
import random

import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

# y = ax + b
# 컴퓨터의 행위 = a * 회사들의 제안

min_proposal_salary = 3000
max_proposal_salary = 4000
step_size = 100

# proposals = []

# proposals = ["3000", "3100", "3200", "3300", "3400", "3500", "3600", "3700", "3800", "3900", "4000"] # x

proposals = np.arange(min_proposal_salary, max_proposal_salary + step_size, step_size)
# proposals = list(range(salary_min, salary_max, salary_step))

# for i in range(min_proposal_salary, max_proposal_salary, step_size):
#     proposals.append(i)

# print(proposals)

actions = ["간다", "안 간다"] # y

salary = []
labels = []

for _ in range(100):
    proposal = np.random.choice(proposals)
    if proposal < 3500:
        action = "안 간다"
    else:
        action = "간다"

    salary.append(proposal)
    labels.append(action)

# print(salary)
# print(labels)

# # 연봉에 대한 맵핑
proposal_mapping = {proposal: i for i, proposal in enumerate(proposals)}
mapped_salary = [proposal_mapping[proposal] for proposal in salary]
# print(mapped_salary)

# 컴퓨터 행위에 대한 맵핑
computer_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [computer_action_mapping[action] for action in labels]
# print(mapped_labels)

encoded_proposal = keras.utils.to_categorical(mapped_salary, num_classes=len(proposals))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
# print(encoded_proposal)
# print(encoded_action)

model = Sequential()
# Sequential() 메서드를 사용하여 입력층부터 출력층까지 순차적 모델 구성
model.add(Dense(32, input_dim=len(proposals), activation='relu')) # 입력층 추가
model.add(Dense(len(actions), activation='softmax')) # 출력층 추가

# print(model.summary())

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_proposal, encoded_action, epochs=150, batch_size=32)

model.save("homework_salary_model.h5")

# print("연봉:", test_proposal)
# print("예측된 컴퓨터 행위:", predicted_action)