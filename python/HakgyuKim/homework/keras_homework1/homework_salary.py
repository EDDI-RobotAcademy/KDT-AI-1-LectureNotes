import numpy as np
from keras import Sequential
from keras.layers import Dense
from tensorflow import keras

min_salary_amount = 30000000
max_salary_amount = 40000000

answers = ['함', '안함']

final_answer = []
salary = np.random.randint(min_salary_amount, max_salary_amount, size=1000)

# step_size = 1000000
# salary_list = np.arange(min_salary_amount, max_salary_amount + 1, step_size)
# salary = np.random.choice(salary_list, size=1000)


for i in range(1000):
    if salary[i] < 35000000:
        answer = '안함'
    else:
        answer = '함'

    final_answer.append(answer)



answer_mapping = {answer: i for i, answer in enumerate(answers)}
mapped_answers = [answer_mapping[choice] for choice in final_answer]

encoded_answers = keras.utils.to_categorical(mapped_answers, num_classes=len(answers))
X = salary.reshape(-1, 1)
# print(encoded_answers)
# print(X)
print(encoded_answers)

model = Sequential()

model.add(Dense(32, input_dim=1, activation="relu"))
model.add(Dense(len(answers), activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])

model.fit(X, encoded_answers, epochs=10000, batch_size=64)

model.save("homework_model.h5")