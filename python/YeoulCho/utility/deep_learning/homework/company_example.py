import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

min_salary_amount = 3000
max_salary_amount = 4000
step_size = 100

salary_amounts_range = np.arange(min_salary_amount, max_salary_amount + step_size, step_size)
num_classes = len(salary_amounts_range) - 1

salarys = salary_amounts_range # x
actions = ["간다", "안간다"] # y
# 차량의 행위 = a * 신호등 색상
# y = ax +b
# y = ax

data = []
labels = []

for _ in range(300):
    salary = np.random.choice(salarys)
    if salary>=3000 and salary<=3500:
        action = "안간다"
    if salary>3500 and salary<=4000:
        action = "간다"

    data.append(salary)
    labels.append(action)

signal_mapping = {signal: i for i, signal in enumerate(salarys)}
mapped_data = [signal_mapping[signal] for signal in data]
#print(mapped_data)

vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [vehicle_action_mapping[action] for action in labels]
#print(mapped_labels)

encoded_salary = keras.utils.to_categorical(mapped_data, num_classes=len(salarys))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
#print(encoded_salary)
#print(encoded_action)

model = Sequential()
model.add(Dense(32, input_dim=len(salarys), activation="relu"))
model.add(Dense(64, activation="relu"))
model.add(Dense(128, activation="relu"))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_salary, encoded_action, epochs=5000, batch_size=32)

model.save("keras_model.h5")


# for i in range(10):
#     salary = np.random.choice(salarys)
#
#     test_salary = salary
#     mapped_test_signal = signal_mapping[test_salary]
#     encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(salarys))
#
#     predictions = model.predict(encoded_test_signal)
#     predicted_action_index = np.argmax(predictions)
#     predicted_action = actions[predicted_action_index]
#
#     print("테스트 신호:", test_salary)
#     print("예측된 입사 상태:", predicted_action)

# test_salary = 3500
# mapped_test_signal = signal_mapping[test_salary]
# encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(salarys))
#
# predictions = model.predict(encoded_test_signal)
# predicted_action_index = np.argmax(predictions)
# predicted_action = actions[predicted_action_index]
#
# print("테스트 신호:", test_salary)
# print("예측된 입사 상태:", predicted_action)
#
# test_salary = 3850
# mapped_test_signal = signal_mapping[test_salary]
# encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(salarys))
#
# predictions = model.predict(encoded_test_signal)
# predicted_action_index = np.argmax(predictions)
# predicted_action = actions[predicted_action_index]
#
# print("테스트 신호:", test_salary)
# print("예측된 입사 상태:", predicted_action)