import numpy as np
from keras.models import load_model
from tensorflow import keras

loaded_model = load_model("ai_salary_model.h5")

min_salary = 30000000
max_salary = 40000000
step_size = 1000000

salary_amounts_range = np.arange(min_salary, max_salary + step_size, step_size)
offer_salary = np.random.choice(salary_amounts_range)

signal_mapping = {signal: i for i, signal in enumerate(salary_amounts_range)}
mapped_test_signal = signal_mapping[offer_salary]
encoded_test_signal = keras.utils.to_categorical([mapped_test_signal], num_classes=len(salary_amounts_range))

# offer_salary = 32000000
actions = ["입사", "거절"]

# new_data = np.array([[offer_salary] * len(salary_amounts_range)])

prediction = loaded_model.predict(encoded_test_signal)
predicted_class = np.argmax(prediction)
action = actions[predicted_class]

print(offer_salary)
print(action)