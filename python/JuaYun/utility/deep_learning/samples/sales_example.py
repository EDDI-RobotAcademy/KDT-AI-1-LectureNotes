import numpy as np
from keras import Sequential
from keras.layers import Dense
from numpy.random import random
from tensorflow import keras

min_loan_amount = 3000
max_loan_amount = 4000
step_size = 100
actions = ["취업", "미취업"]

data = []
labels = []

num_samples = 100

sales = np.random.randint(min_loan_amount, max_loan_amount, size=num_samples)
sales_amounts = np.arange(min_loan_amount, max_loan_amount + step_size, step_size)
print(sales_amounts)
print(sales)

for signal in sales:
    if signal >= 3500:
        action = "취업"
    else:
        action = "미취업"

    data.append(signal)
    labels.append(action)

signal_mapping = {signal: i for i, signal in enumerate(sales)}
mapped_data = [signal_mapping[signal] for signal in data]

action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [action_mapping[action] for action in labels]

encoded_traffic_light = keras.utils.to_categorical(mapped_data, num_classes=len(sales))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))

model = Sequential()
model.add(Dense(32, input_dim=len(sales), activation='relu'))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_traffic_light, encoded_action, epochs=10, batch_size=32)

test_traffic_light = sales.__getitem__(15)
mapped_test_signal = signal_mapping[test_traffic_light]
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(sales))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_traffic_light)
print("예측된 차량 상태:", predicted_action)

