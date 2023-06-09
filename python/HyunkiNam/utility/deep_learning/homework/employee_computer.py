import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

min_salary_amount = 3000
max_salary_amount = 4000
step_size = 50

computer_wanted_min_salary = 3500

num_samples = 10000

random_suggest_salary = np.random.randint(min_salary_amount/50, max_salary_amount/50, size=num_samples) * 50
actions = ["Yes", "No"]

data = []
labels = []

for i in range(num_samples):
    salary = random_suggest_salary[i]
    if salary > computer_wanted_min_salary:
        action = "Yes"
    else:
        action = "No"

    data.append(salary)
    labels.append(action)

print(data)
print(labels)

action_mapping = {action: i for i, action in enumerate(actions)}
mapped_labels = [action_mapping[action] for action in labels]

encoded_action = keras.utils.to_categorical(mapped_labels, num_classes=len(actions))

model = Sequential()
model.add(Dense(32, input_dim=len(random_suggest_salary), activation="relu", input_shape=(1, )))
model.add(Dense(len(actions), activation="softmax"))

model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])

model.fit(random_suggest_salary, encoded_action, epochs=100000, batch_size=32)

model.save("salary_model.h5")