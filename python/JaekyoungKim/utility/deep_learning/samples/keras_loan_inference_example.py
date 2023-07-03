import numpy as np
from keras.models import load_model

min_loan_amount = 30000000
max_loan_amount = 45000000
step_size = 1000000
loan_amounts_range = np.arange(min_loan_amount, max_loan_amount + step_size, step_size)

loaded_model = load_model("loan_model.h5")

미상환금액 = 1000000
미상환건수 = 1
연체율 = 0.1

new_data = np.array([[미상환금액, 미상환건수, 연체율]])

prediction = loaded_model.predict(new_data)

predicted_class = np.argmax(prediction)
loan_amount = loan_amounts_range[predicted_class]
print("Predicted loan amount:", loan_amount)
