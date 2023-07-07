import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

pays = [3000,3100,3200,3300,3400,3500,3600,3700,3800,3900,4000]
actions = ["yes", "no"]

data = []
labels = []

for _ in range(100):
    pay = np.random.choice(pays)
    if pay < 3600:
        action = "no"
    else:
        action = "yes"

    data.append(pay)
    labels.append(action)

pay_mapping = {pay: i for i, pay in enumerate(pays)}
mapped_data = [pay_mapping[pay] for pay in data]

man_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [man_action_mapping[action] for action in labels]


encoded_pay = keras.utils.to_categorical(mapped_data, num_classes=len(pays))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))


model = Sequential()
model.add(Dense(32, input_dim=len(pays), activation="relu"))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_pay, encoded_action, epochs=5000, batch_size=32)

test_pay = 3000
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3100
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3200
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3300
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3400
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3500
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3600
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3700
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3800
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 3900
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)

test_pay = 4000
mapped_test_pay = pay_mapping[test_pay]
encoded_test_signal = keras.utils.to_categorical([mapped_test_pay], num_classes=len(pays))

predictions = model.predict(encoded_test_signal)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 신호:", test_pay)
print("예측된 차량 상태:", predicted_action)