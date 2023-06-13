import numpy as np
from keras.models import load_model

min_loan_amount = 30000000
max_loan_amount = 45000000
step_size = 1000000
loan_amounts_range = np.arange(min_loan_amount, max_loan_amount + step_size, step_size)

loaded_model = load_model("loan_model.h5")

미상환금액 = 1000000000
미상환건수 = 1
연체율 = 0.1

new_data = np.array([[미상환금액, 미상환건수, 연체율]])

prediction = loaded_model.predict(new_data)

predicted_class = np.argmax(prediction)
# numpy.argmax()
# 축에 따라 최대값을 반환
loan_amount = loan_amounts_range[predicted_class]
print("Predicted loan amount:", loan_amount)

# 학습한 정보를 바탕으로 대출값을 줌
# 1/1 [==============================] - 0s 84ms/step
# Predicted loan amount: 31000000
# 그런데 미상환금액, 미상환건수, 연체율을 다르게 했는데도 계속 같은 금액을 예측해줌
# -> 망한 학습임 뭔가 잘못된 것

# redo로 재학습시킴
# 1/1 [==============================] - 0s 95ms/step
# Predicted loan amount: 33000000
