import numpy as np
from keras.models import load_model

loaded_model = load_model("homework_model.h5")

answers = ['함', '안함']
suggest_salary = 38000000

new_data = np.array(suggest_salary)
X = new_data.reshape(-1, 1)
prediction = loaded_model.predict(X)
print(prediction)
predicted_answer_index = np.argmax(prediction)
predicted_answer = answers[predicted_answer_index]

print('연봉:', suggest_salary)
print('답:', predicted_answer)