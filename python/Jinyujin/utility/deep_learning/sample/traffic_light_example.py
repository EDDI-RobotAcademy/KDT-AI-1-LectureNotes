import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

signals = ['빨간색', '노란색', '초록색']
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

# 신호등에 대한 것 맵핑
signal_mapping = {signal: i for i, signal in enumerate(signals)}
mapped_data = [signal_mapping[signal] for signal in data]
# print(mapped_data)
# 신호등에 대한 것 데이터로 맵핑

# 자동차에 대한 것 맵핑
vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [vehicle_action_mapping[action] for action in labels]
# print(mapped_labels)
# 자동차에 대한 것 label로 맵핑

encoded_traffic_light = keras.utils.to_categorical(mapped_data, num_classes=len(signals))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
print(encoded_traffic_light) # 3X3 행렬
print(encoded_action)        # 2X2 행렬

model = Sequential()
model.add(Dense(32, input_dim=len(signals), activation='relu'))
model.add(Dense(len(actions), activation='softmax'))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_traffic_light, encoded_action, epochs=5000, batch_size=32)
# epochs: 학습시키는 횟수

test_traffic_light = "초록색"
mapped_test_signal = signal_mapping[test_traffic_light]
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))
# 각각에 대한 것들 테스트하기 위한 정보

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_traffic_light)
print("예측된 차량 상태:", predicted_action)
# 초록색에서만 전진이고 노란색, 빨간색에서는 정지로 나타남