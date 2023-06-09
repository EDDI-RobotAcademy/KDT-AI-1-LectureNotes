import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

# salarys = [3000, 3100, 3200, 3300,
#           3400, 3500, 3600, 3700,
#           3800, 3900, 4000]

min_salary_amount = 3000
max_salary_amount = 4000
step_size = 100

actions = ["수락", "거절"]

data = []
labels = []

for _ in range(100):
    # salary = np.random.choice(salarys)
    salary = np.random.randint(min_salary_amount, max_salary_amount + 1, size=step_size)
    salary = salary[0]
    if salary < 3500:
        action = "거절"
    else:
        action = "수락"

    data.append(salary)
    labels.append(action)

# salary_mapping = {salary: i for i, salary in enumerate(salarys)}
unique_salaries = np.unique(np.array(data))
salary_mapping = {salary: i for i, salary in enumerate(unique_salaries)}
mapped_data = [salary_mapping[salary] for salary in data]
# print(mapped_data)

ai_action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [ai_action_mapping[action] for action in labels]
# print(mapped_labels)

encoded_salary = keras.utils.to_categorical(mapped_data, num_classes=len(unique_salaries))
encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))
# print(encoded_salary)
# print(encoded_action)

model = Sequential()
model.add(Dense(32, input_dim=len(unique_salaries), activation="relu"))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(encoded_salary, encoded_action, epochs=5000, batch_size=32)

test_salary = 3200
mapped_test_salary = salary_mapping[test_salary]
encoded_test_salary = keras.utils.to_categorical([mapped_test_salary], num_classes=len(unique_salaries))

predictions = model.predict(encoded_test_salary)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 급여", test_salary)
print("예측된 반응", predicted_action)

test_salary = 3600
mapped_test_salary = salary_mapping[test_salary]
encoded_test_salary = keras.utils.to_categorical([mapped_test_salary], num_classes=len(unique_salaries))

predictions = model.predict(encoded_test_salary)
predicted_action_index = np.argmax(predictions)
predicted_action = actions[predicted_action_index]

print("테스트 급여", test_salary)
print("예측된 반응", predicted_action)