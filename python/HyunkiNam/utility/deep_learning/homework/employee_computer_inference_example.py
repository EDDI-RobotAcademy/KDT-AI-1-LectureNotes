import numpy as np
from keras.models import load_model

loaded_model = load_model("salary_model.h5")

test_salary = 3600
actions = ["Yes", "No"]

new_data = np.array([test_salary])

prediction = loaded_model.predict(new_data)
predicted_class = np.argmax(prediction)
action = actions[predicted_class]

print(test_salary)
print(action)