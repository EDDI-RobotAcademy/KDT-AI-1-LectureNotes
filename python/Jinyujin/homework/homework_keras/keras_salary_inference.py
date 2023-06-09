import keras.utils
import numpy as np
from keras.models import load_model

min_proposal_salary = 30000000
max_proposal_salary = 40000000
step_size = 1000000
proposals_range = np.arange(min_proposal_salary, max_proposal_salary + step_size, step_size)

test_salary = 33000000
salary_mapping = {proposal: i for i, proposal in enumerate(proposals_range)}
mapped_test_salary = salary_mapping[test_salary]
encoded_test_salary = keras.utils.to_categorical([mapped_test_salary], num_classes=len(proposals_range))

salary_model = load_model("homework_salary_model.h5")

갈까_말까 = ["간다", "안 간다"]

# new_data = np.array([min_proposal_salary])

prediction = salary_model.predict(encoded_test_salary)

predicted_class = np.argmax(prediction)
action = 갈까_말까[predicted_class]
print(encoded_test_salary)
print(action)


