import numpy as np
from keras.models import load_model

loaded_model = load_model("sales_model.h5")

sales = 3501
actions = ["취업", "미취업"]

new_data = np.array([sales])

prediction = loaded_model.predict(new_data)
predicted_class = np.argmax(prediction)
action = actions[predicted_class]

print(sales)
print(action)
