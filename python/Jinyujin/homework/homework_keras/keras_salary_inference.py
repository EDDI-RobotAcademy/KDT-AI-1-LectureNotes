import keras.utils
import numpy as np
from keras.models import load_model

min_proposal_salary = 30000000
max_proposal_salary = 40000000
step_size = 1000000
proposals = np.arange(min_proposal_salary, max_proposal_salary + step_size, step_size)

salary_model = load_model("homework_salary_model.h5")

test_salary = np.random.choice(proposals)
print("테스트 연봉은:", test_salary)

salary_mapping = {proposal: i for i, proposal in enumerate(proposals)}
mapped_test_salary = salary_mapping[test_salary]
encoded_test_salary = keras.utils.to_categorical([mapped_test_salary], num_classes=len(proposals))

actions = ["간다", "안 간다"]

prediction = salary_model.predict(encoded_test_salary)
predicted_class = np.argmax(prediction)
predicted_action = actions[predicted_class]

print(predicted_action)


