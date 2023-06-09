import random
import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

signals = []
for _ in range(20):
    signals.append(random.randrange(3000, 4000))

print(signals)
actions = ["수락", "거절"]  # y

data = []
labels = []

for _ in range(100):
    signal = np.random.choice(signals)
    if signal < 3500:
        action = "거절"
    else:
        action = "수락"

    data.append(signal)
    labels.append(action)
# print("data : ", data)
# print("labels : ", labels)

signal_mapping = {signal: i for i, signal in enumerate(signals)}
mapped_data = [signal_mapping[signal] for signal in data]
# print("signal_mapping : ", signal_mapping)
# print("mapped_data : ", mapped_data)

vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [vehicle_action_mapping[action] for action in labels]
# print("vehicle_action_mapping : ", vehicle_action_mapping)
# print("mapped_labels : ", mapped_labels)

encoded_traffic_light = keras.utils.to_categorical(mapped_data, num_classes=len(signals))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
# print(encoded_traffic_light)
# print(encoded_action)

# 1. Sequential 모델 생성
model = Sequential()
# 2. 입력층과 은닉층 추가
# Dense의 첫번째 인자 : 출력 뉴런(노드)의 수를 결정
# Dense의 두번째 인자 : input_dim은 입력 뉴런(노드)의 수를 결정, 맨 처음 입력층에서만 사용
#                     input_dim = n, 입력 차원이 n이라는 뜻이며 입력 노드가 n개라고 생각하면 됩니다.
# Dense의 세번째 인자 : activation 활성화 함수를 선택
# relu =>은닉 층으로 학습, 'relu' 는 은닉층으로 역전파를 통해 좋은 성능이 나오기 때문에 마지막 층이 아니고서야 거의 relu 를 이용한다.
# sigmond=>yes or no 와 같은 이진 분류 문제
# softmax=>확률 값을 이용해 다양한 클래스를 분류하기 위한 문제

model.add(Dense(32, input_dim=len(signals), activation="relu"))
# 3. 출력층 추가
model.add(Dense(len(actions), activation="softmax"))
# 모델 컴파일
model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

#모델 훈련 epochs=>훈련 횟수, batch_size=> 작업단위
model.fit(encoded_traffic_light, encoded_action, epochs=500, batch_size=32)
model.summary()


# test_traffic_light = 3600
# mapped_test_signal = signal_mapping[test_traffic_light]
# encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))
#
# predictions = model.predict(encoded_test_signal)
# predicted_action_index = np.argmax(predictions)
# predicted_action = actions[predicted_action_index]
#
# print("제시 연봉:", test_traffic_light)
# print("예측된 AI의 답:", predicted_action)
# #
# test_traffic_light = 3200
# mapped_test_signal = signal_mapping[test_traffic_light]
# encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))
#
# predictions = model.predict(encoded_test_signal)
# predicted_action_index = np.argmax(predictions)
# predicted_action = actions[predicted_action_index]
#
# print("테스트 신호:", test_traffic_light)
# print("예측된 차량 상태:", predicted_action)

# test_traffic_light = "빨간색"
# mapped_test_signal = signal_mapping[test_traffic_light]
# encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))
#
# predictions = model.predict(encoded_test_signal)
# predicted_action_index = np.argmax(predictions)
# predicted_action = actions[predicted_action_index]
#
# print("테스트 신호:", test_traffic_light)
# print("예측된 차량 상태:", predicted_action)