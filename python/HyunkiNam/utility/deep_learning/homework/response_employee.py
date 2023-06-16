import numpy as np
from keras.models import load_model


def response(salary):
    loaded_model = load_model("salary_model.h5")

    actions = ["Yes", "No"]

    new_data = np.array([salary])

    prediction = loaded_model.predict(new_data)
    predicted_class = np.argmax(prediction)
    action = actions[predicted_class]

    return action
