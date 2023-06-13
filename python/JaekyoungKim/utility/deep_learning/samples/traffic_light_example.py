import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

signals = ["빨간색", "노란색", "초록색"]
actions = ["전진", "정지"]

data = []
labels = []

for _ in range(100):
    signal = np.random.choice(signals)
    if signal == "노란색":
        action = "정지"
    else:
        action = "정지" if signal == "빨간색" else "전진"

    data.append(signal)
    labels.append(action)

signal_mapping = {signal: i for i, signal in enumerate(signals)}
mapped_data = [signal_mapping[signal] for signal in data]
#print(mapped_data)

vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [vehicle_action_mapping[action] for action in labels]
#print(mapped_labels)

encoded_traffic_light = keras.utils.to_categorical(mapped_data, num_classes=len(signals))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
#print(encoded_traffic_light)
#print(encoded_action)

model = Sequential()
model.add(Dense(32, input_dim=len(signals), activation="relu"))
model.add(Dense(64, activation="relu"))
model.add(Dense(128, activation="relu"))
model.add(Dense(64, activation="relu"))
model.add(Dense(32, activation="relu"))
model.add(Dense(16, activation="relu"))
model.add(Dense(8, activation="tanh"))
model.add(Dense(4, activation="tanh"))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_traffic_light, encoded_action, epochs=5000, batch_size=32)

test_traffic_light = "초록색"
mapped_test_signal = signal_mapping[test_traffic_light]
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_traffic_light)
print("예측된 차량 상태:", predicted_action)

test_traffic_light = "노란색"
mapped_test_signal = signal_mapping[test_traffic_light]
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_traffic_light)
print("예측된 차량 상태:", predicted_action)

test_traffic_light = "빨간색"
mapped_test_signal = signal_mapping[test_traffic_light]
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_traffic_light)
print("예측된 차량 상태:", predicted_action)