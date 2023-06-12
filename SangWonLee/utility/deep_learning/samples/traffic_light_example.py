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
# mapped_data의 각 요소를 len(signals)만큼의 이진 벡터로 변환한다. 0 = [1,0,0], 1 = [0,1,0], 2 = [0,0,1]
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
# mapped_lables의 각 요소를 len(actions)만큼의 이진 벡터로 변환한다.
print(encoded_traffic_light)
print(encoded_action)

model = Sequential()
# Sequential 클래스의 인스턴스 생성
model.add(Dense(32, input_dim=len(signals), activation="relu"))
# Dense는 완전 연결 레이어로, 각 입력 노드가 모든 출력 노드와 연결되어 있다.
# 유닛 수는 32, 입력 데이터는 signals의 길이 만큼의 값
# relu는 입력값이 0보다 작으면 0 출력하고, 0보다 크면 그대로 출력
model.summary()
# Param 은 레이어가 가지는 파라미터의 수를 말함 (입력 차원 + 1) x 유닛수 임
# ex) 위에는 (len(signals)+ 1) x 32 = 128

model.add(Dense(len(actions), activation="softmax"))
# 이전 레이어의 Output Shape가 32 이므로, 입력 차원은 32임.
# len(actions) 만큼의 유닛을 가지고 있음
# softmax는 입력값을 확률 분포로 변환하는 함수임.
# 입력 값의 지수 값을 계산한 후, 전체 합을 나누어 정규화한다.
model.summary()

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])
# .compile 메소드는 손실 함수, 최적화 알고리즘 ,평가 지표 등을 설정한다.
# loss는 손실 함수를 지정한다. categorical_crossentropy 예측값과 실제값 사이의 교차 엔트로피를 계산한다.
# optimizer는 모델의 최적화 알고리즘을 지정한다.
# adam은 경사 하강법(stochastic gradient descent) 알고리즘의 변형인데, 학습률을 동적으로 조절하여 학습 속도를 개선한 알고리즘..
# metrics는 모델의 성능을 평가하는 지표를 지정함.
# accuracy는 정확도를 평가함
model.summary()

model.fit(encoded_traffic_light, encoded_action, epochs=5000, batch_size=32)
# .fit은 학습하는 메소드
# encoded_traffic_light은 입력 데이터, encoded_action은 목표값
# epochs는 5000번 사용하여 학습한다.
# batch_size는 배치 크기를 지정, 한번에 처리할 데이터 수를 나타냄
# 배치 크기가 32로 지정되어 있으므로, 한번에 32개의 데이터 처리하여 학습.
model.summary()

# 테스트 시작

test_traffic_light = "초록색"
mapped_test_signal = signal_mapping[test_traffic_light]
# 초록색을 인덱스로 매핑함 ex) 초록색 = 2
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(signals))
# mapped_test_signal를 len(signals)만큼의 이진 벡터로 변환한다. 2 = [0,0,1]

predictions = model.predict(encoded_test_signal)
# model을 사용해서 encoded_test_signal로 모델의 예측값 계산
print(predictions)
predicted_action_index = np.argmax(predictions)
# 예측값의 인덱스를 찾는다. 초록색이니까 전진이 나왔겠고, 전진은 0
print(predicted_action_index)

predicted_action = actions[predicted_action_index]
# actions의 0은 전진

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
