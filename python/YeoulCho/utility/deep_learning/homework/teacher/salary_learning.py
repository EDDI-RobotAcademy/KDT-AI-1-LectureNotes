import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

salary_min = 30000000
salary_max = 40000001
salary_step = 1000000

salary_minimum_condition = 35000000

signals = list(range(salary_min, salary_max, salary_step))
actions = ["간다", "안간다"]

data = []
labels = []

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
mapped_data = [signal_mapping[signal] for signal in data]

vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [vehicle_action_mapping[action] for action in labels]

encoded_traffic_light = keras.utils.to_categorical(mapped_data, num_classes=len(signals))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))

model = Sequential()
model.add(Dense(32, input_dim=len(signals), activation="relu"))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_traffic_light, encoded_action, epochs=5000, batch_size=32)

model.save("salary_model.h5")