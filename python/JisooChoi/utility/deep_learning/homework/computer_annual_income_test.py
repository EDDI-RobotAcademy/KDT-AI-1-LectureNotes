import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

# 데이터 준비
actions = ["간다", "안간다"]
low_income = 30000000
high_income = 40000000
step_size = 1000000
computer_income_rule = 35000000

data = []
labels = []

# 3천 ~ 4천 사이의 100만원 씩 증가 하는 범위 생성
salary_range = np.arange(low_income, high_income + step_size, step_size)

salarys = salary_range

for i in range(100): # 샘플 데이터
    salary = np.random.choice(salarys)
    if salary > computer_income_rule:
        action = "간다"
    else:
        action = "안간다"

    data.append(salary)
    labels.append(action)

# 데이터 전처리
signal_mapping = {salary: i for i, salary in enumerate(salarys)}
mapped_data = [signal_mapping[salary] for salary in data]
print(mapped_data)

vehicle_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [vehicle_action_mapping[action] for action in labels]
print(mapped_labels)

encoded_salaries = keras.utils.to_categorical(mapped_data, num_classes=len(salarys))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))

# 모델 생성
model = Sequential()
model.add(Dense(32, input_dim=len(salarys), activation="relu"))
model.add(Dense(64, activation="relu"))
model.add(Dense(128, activation="relu"))
model.add(Dense(len(actions), activation="softmax"))

# 모델 컴파일
model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

# 모델 학습
model.fit(encoded_salaries, encoded_action, epochs=100, batch_size=32)

# 테스트 1
test_encoded_salaries = [32000000]
mapped_test_salaries = signal_mapping[test_encoded_salaries[0]]
encoded_test_salaries = keras.utils.to_categorical([mapped_test_salaries], num_classes=len(salarys))

# 예측
predictions = model.predict(encoded_test_salaries)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 급여: ", test_encoded_salaries[0])
print("예측된 상태: ", predicted_action)

# 테스트 2
test_encoded_salaries = [36000000]
mapped_test_salaries = signal_mapping[test_encoded_salaries[0]]
encoded_test_salaries = keras.utils.to_categorical([mapped_test_salaries], num_classes=len(salarys))

# 예측
predictions = model.predict(encoded_test_salaries)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 급여: ", test_encoded_salaries[0])
print("예측된 상태: ", predicted_action)

# 테스트 3
test_encoded_salaries = [35000000]
mapped_test_salaries = signal_mapping[test_encoded_salaries[0]]
encoded_test_salaries = keras.utils.to_categorical([mapped_test_salaries], num_classes=len(salarys))

# 예측
predictions = model.predict(encoded_test_salaries)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 급여: ", test_encoded_salaries[0])
print("예측된 상태: ", predicted_action)