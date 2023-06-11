import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

signals = ["빨간색", "노란색", "초록색"]  # x
actions = ["전진", "정지"]  # y
# 차량의 행위 = a * 신호등 색상
# y = ax + b
# y

# 대출 가능한 금액 = a1 * 미상환금액 + a2 * 미상환건수 + a3 * 연체율
# 사용자 점수 = a1 * 미상환금액 + a2 * 미상환건수 + a3 * 연체율
# 사용자 점수 얼마 미만 대출 컷
# 범주 어디서 어디까진 3100, 어디서 어디까진 3700
# 아까 예제에서 만든 형태 = a1 * 미상환금액 + 1 * 미상환건수 + 1 * 연체율

data = []
labels = []

for _ in range(100):
    signal = np.random.choice(signals)  # signals 리스트에서 임의의 값을 선택
    if signal == "노란색":
        action = "정지"
    else:
        action = "정지" \
            if signal == "빨간색" else "전진"

    data.append(signal)  # data 리스트에 추가
    labels.append(action)  # labels 리스트에 추가

# --

signal_mapping = {signal: i for i, signal in enumerate(signals)}
# signals 리스트의 각 요소에 대해 인덱스를 매핑
print(signal_mapping)  # {'빨간색': 0, '노란색': 1, '초록색': 2}
print(data)
# ['노란색', '빨간색', '빨간색', '노란색', '노란색', '초록색', '빨간색', '노란색', '노란색', '노란색', '초록색', ...
# '초록색', '노란색', '초록색']

mapped_data = [signal_mapping[signal] for signal in data]
# data 리스트의 각 요소들을 signal_mapping 딕셔너리를 이용해서 매핑된 값을 변환.
# (위에 있는 signal 이랑 여기있는 signal 이랑 다르다.)

print(mapped_data)

vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
# actios 리스트의 각 요소에 대해 익덱스를 매핑
print(vehicle_action_mapping)  # {'전진': 0, '정지': 1}
print(labels)

mapped_labels = [vehicle_action_mapping[action] for action in labels]
# labes의 각 요소들에 대해서 vehicle_action_mapping 딕셔너리를 이용해 매핑된 값을 변환
print(mapped_labels)

encoded_traffic_light = keras.utils.to_categorical(mapped_data, num_classes=len(signals))
# len(signals)만큼의
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
print(encoded_traffic_light)
print(encoded_action)

model = Sequential()
model.add(Dense(32, input_dim=len(signals), activation="relu"))
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
