import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Dropout

min_loan_amount = 30000000
max_loan_amount = 45000000
step_size = 1000000

num_samples = 1000
# 미상환 금액
random_outstanding_amounts = np.random.randint(min_loan_amount, max_loan_amount + 1, size=num_samples)
# 미산환 건수
random_outstanding_counts = np.random.randint(1, 10, size=num_samples)
# 연체율
random_deliquency_rates = np.random.uniform(0.0, 0.3, size=num_samples)

loan_amounts_range = np.arange(min_loan_amount, max_loan_amount + step_size, step_size)
num_classes = len(loan_amounts_range) - 1

y = np.zeros(num_samples, dtype=int)
for i in range(num_samples):
    # outstanding_amounts는 OK, 나머지는 amount를 계산할 때 적정 계수값을 곱해서 조정하도록 해줘야함
    # 일단 예제니까 그냥 더하도록 함
    # 더하면 대출 금액이 있고 뒤에 숫자는 0.0 ~ 0.3, 1 ~ 10이라 아주 미비한 영향을 미침
    amount = random_outstanding_amounts[i] + random_outstanding_counts[i] + random_deliquency_rates[i]
    for j in range(len(loan_amounts_range) - 1):
        if amount >= loan_amounts_range[j] and amount < loan_amounts_range[j + 1]:
            y[i] = j
            break
        else:
            y[i] = len(loan_amounts_range) - 1

# 데이터 셋 구성
X = np.column_stack((random_outstanding_amounts, random_outstanding_counts, random_deliquency_rates))

one_hot_labels = np.eye(num_classes + 1)[y]

model = Sequential()
model.add(Dense(32, activation='relu', input_shape=(3, )))
model.add(Dense(64, activation='relu'))
model.add(Dropout(0.5))
model.add(Dense(32, activation='relu'))
model.add(Dense(num_classes + 1, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])

model.fit(X, one_hot_labels, epochs=50, batch_size=32)

model.save("loan_model.h5")