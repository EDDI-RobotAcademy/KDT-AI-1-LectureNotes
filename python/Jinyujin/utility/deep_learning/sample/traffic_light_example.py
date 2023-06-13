import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

signals = ['빨간색', '노란색', '초록색'] # x
actions = ["전진", "정지"] # y

# y = ax + b
# y = ax
# 차량의 행위 = a * 신호등 색상

# 대출 같은 경우는 더 복잡한 시스템
# 대출 가능한 금액이 먼저 판정되어야 함
# 대출 가능한 금액 = a1 * 미상환금액 + a2 * 미상환건수 + a3 * 연체율

# 혹은 사용자 점수를 추가하여
# 사용자 점수 = a1 * 미상환금액 + a2 * 미상환건수 + a3 * 연체율
# 사용자 점수 얼마 미만 대출할 것
# 범주 어디서 어디까진 3100, 어디서 어디까진 3700 이런 형식으로 구성할 수도 있음
# 그래서 신불자에게는 대출을 하지 못하도록 제한할 수 있음
# 이전까지는 신불자에게도 최소 3천만원 대출하게 해줬는데 그럼 회수 못할 수도 있으니..
# 아까 예제에서 만든 형태 = a1 * 미상환금액 + 1 * 미상환건수 + 1 * 연체율
# 그래서 미상환건수와 연체율의 영향력은 없다고 봐야함
# 계수들을 어떻게 표현할 수 있냐가 관건 (근데 그럼 식이 복잡해짐)

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
# enumerate() 함수
# 인덱스와 원소를 동시에 접근하면서 루프를 돌려줌
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
# loss는 오차

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
# 문자열로 색깔을 표현한 상태

# Epoch 5000/5000
# 4/4 [==============================] - 0s 1ms/step - loss: 0.0000e+00 - accuracy: 1.0000
# loss 오차: 잘못된 데이터를 학습해서 오판을 하지 않겠다
# 어느 정도 배우니까 지나니까 오차가 없어진 모습

# 지금 수업 흐름은
# y = ax + b를 간단하게 만드는 과정
# 지금 여기서 y: actions
# x: signals
# 컴퓨터에 데이터를 주입했고 5000번을 학습시킴

# 이러한 딥러닝으로 서비스에 적용한다면
# 많이 검색한 결과를 토대로 추천검색어를 적용시킬 수 있다