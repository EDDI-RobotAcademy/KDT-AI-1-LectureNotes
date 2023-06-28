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

num_samples = 11

salary_amounts_range = np.arange(min_proposal_salary, max_proposal_salary + step_size, step_size) # X
num_classes = len(salary_amounts_range) - 1
actions = ["안 간다", "간다"] # y

salary = []

y = np.zeros(num_samples, dtype=int)
for i in range(num_samples):
    salary = np.random.choice(salary_amounts_range)
    # print(salary)

    for j in range(len(actions) - 1):
        if salary < 3500:
            y[i] = j
            break
        else:
            y[i] = len(actions) - 1

# print(y)

salary_mapping = {salary: i for i, salary in enumerate(salary_amounts_range)}
mapped_salary = [salary_mapping[salary] for salary in salary_mapping]

# print(mapped_salary)

X = np.column_stack((mapped_salary, ))
# print(X)


# # 연봉에 대한 맵핑
# proposal_mapping = {proposal: i for i, proposal in enumerate(proposals)}
# mapped_salary = [proposal_mapping[proposal] for proposal in salary]
# # print(mapped_salary)
#
# # 컴퓨터 행위에 대한 맵핑
# computer_action_mapping = {action: i for i, action in enumerate(actions)}
# mapped_labels = [computer_action_mapping[action] for action in labels]
# # print(mapped_labels)
#
# encoded_proposal = keras.utils.to_categorical(mapped_salary, num_classes=len(proposals))
# encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
# # print(encoded_proposal)
# # print(encoded_action)
#
model = Sequential()
model.add(Dense(32, input_dim=len(salary_amounts_range), activation='relu')) # 입력층 추가
model.add(Dense(len(actions), activation='softmax')) # 출력층 추가
#
# # print(model.summary())
#
model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(X, y, epochs=10, batch_size=32)

# model.save("homework_salary_model.h5")

# print("연봉:", test_proposal)
# print("예측된 컴퓨터 행위:", predicted_action)