import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Dropout

min_loan_amount = 3000
max_loan_amount = 4500
step_size = 100

num_samples = 1000
# 미상환 금액
random_outstanding_amounts = np.random.randint(min_loan_amount, max_loan_amount + 1, size=num_samples) * 10000000
# 미상환 건수
random_outstanding_counts = np.random.randint(1, 10, size=num_samples)
# 연체율
random_deliquency_rates = np.random.uniform(0.0, 0.3, size=num_samples)

# 대출 금액 범위: 3000부터 4500까지 step_size 단위(100)로 배열 생성됨
loan_amounts_range = np.arange(min_loan_amount, max_loan_amount + step_size, step_size)
num_classes = len(loan_amounts_range) - 1

print(loan_amounts_range)
print(num_classes)

# 점수 판정을 위한 샘플 데이터
# 2번 케이스 산정 점수 - 10억 + 50억 + 33.4억 = 93.4억 (worst)
# 3번 케이스 산정 점수 - 0.3억 + 0.3억 + 3억 = 3.6억 (best)
# 그러므로 실제 데이터에서는 Max, Min 값을 실제 데이터 기반으로 계산하도록 구성해야함 (여기선 우리가 가상으로 만들었음)
# defective_min_score = 3.6e8
# defective_max_score = 93.4e8
# interval_length = 16
#
# interval_size = (defective_max_score - defective_min_score) / interval_length
#
# calculated_interval = []
# for i in range(interval_length):
#     start = defective_min_score + i * interval_size
#     end = start + interval_size
#     calculated_interval.append((start, end))
#
# for interval in calculated_interval:
#     print(f"계산된 구간: {interval[0]:.2e} ~ {interval[1]:.2e}")


y = np.zeros(num_samples, dtype=int)
for i in range(num_samples):
    amount = random_outstanding_amounts[i] + random_outstanding_counts[i] + random_deliquency_rates[i]

    for j in range(len(loan_amounts_range) - 1):
        if amount >= loan_amounts_range[j] * 10000000 and amount > loan_amounts_range[j + 1] * 10000000:
            y[i] = j
            break
        else:
            y[i] = len(loan_amounts_range) - 1

# print(y)
# amount에 대한 y값을 정해준 것 같음

# 데이터 셋 구성
X = np.column_stack((random_outstanding_amounts, random_outstanding_counts, random_deliquency_rates))
# numpy.colum_stack(): 1차원 배열을 열로 하여 2차원 배열로 만들어줌 -> X축으로

one_hot_labels = np.eye(num_classes + 1)[y]
# 행렬을 num_classes + 1 크기로 한 단위행렬을 반환해줌
# 쉽게 말해 위에서 구한 y값을 0,1로 엔코딩해준 것
print(one_hot_labels)

# 딥러닝 모델을 만드는 방법 중 하나가 Sequential model만들기!
model = Sequential()
model.add(Dense(32, activation='relu', input_shape=(3, )))
# 처음 추가할 때는 input_shape() 필요
model.add(Dense(64, activation='relu'))
model.add(Dropout(0.5))
model.add(Dense(32, activation='relu'))
model.add(Dense(num_classes + 1, activation='softmax'))

model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])

# 학습
model.fit(X, one_hot_labels, epochs=100, batch_size=32)

model.save("loan_model.h5")