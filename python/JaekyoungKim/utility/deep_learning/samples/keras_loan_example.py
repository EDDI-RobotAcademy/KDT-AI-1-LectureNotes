import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Dropout

min_loan_amount = 300000000
max_loan_amount = 1000000000
step_size = 10000000

num_samples = 10
# 미상환 금액
random_outstanding_amounts = np.random.randint(min_loan_amount, max_loan_amount + 1, size=num_samples)
# 미산환 건수
random_outstanding_counts = np.random.randint(1, 5, size=num_samples)
# 연체율
random_deliquency_rates = np.random.uniform(0.0, 0.3, size=num_samples)

loan_amounts_range = np.arange(min_loan_amount, max_loan_amount + step_size, step_size)
num_classes = len(loan_amounts_range) - 1

print(loan_amounts_range)
print(num_classes)

# 점수 판정을 위한 샘플 데이터
# 2번 케이스 산정 점수 - 10억 + 50억 + 33.4억 = 93.4억 (worst)
# 3번 케이스 산정 점수 - 0.3억 + 0.3억 + 3억 = 3.6억 (best)
# 그러므로 실제 데이터에서는 Max, Min 값을 실제 데이터 기반으로 계산하도록 구성해야함 (여기선 우리가 가상으로 만들었음)
defective_min_score = 3.6e8
defective_max_score = 93.4e8
interval_length = 16

interval_size = (defective_max_score - defective_min_score) / interval_length

calculated_interval = []
for i in range(interval_length):
    start = defective_min_score + i * interval_size
    end = start + interval_size
    calculated_interval.append((start, end))

for interval in calculated_interval:
    print(f"계산된 구간: {interval[0]:.2e} ~ {interval[1]:.2e}")

y = np.zeros(num_samples, dtype=int)
for i in range(num_samples):
    # outstanding_amounts는 OK, 나머지는 amount를 계산할 때 적정 계수값을 곱해서 조정하도록 해줘야함
    # 일단 예제니까 그냥 더하도록 함
    # 더하면 대출 금액이 있고 뒤에 숫자는 0.0 ~ 0.3, 1 ~ 10이라 아주 미비한 영향을 미침

    # 이 사람이 갚을 능력이 있냐를 어떻게 계산할 것이냐가 관건이긴함 (소득 정보가 없는 것이 큼)
    #amount = random_outstanding_amounts[i] + random_outstanding_counts[i] + random_deliquency_rates[i]

    outstanding_uniform_separated_amounts = random_outstanding_amounts[i] * random_outstanding_counts[i]
    outstanding_deliquency_processed_amounts = random_outstanding_amounts[i] / random_deliquency_rates[i]

    # ex) 1번 케이스 - 미상환금액: 2억, 미상환 건수: 5, 연체율: 30%
    #     2번 케이스 - 미상환금액: 10억, 미상환 건수: 10, 연체율: 30%
    #     3번 케이스 - 미상환금액: 3000만원, 미상환 건수: 1, 연체율: 10%

    #     1번 케이스 산정 점수 - 2억 + 10억 + 666666666.6 (6.7억) = 18.7억 -> scale to 3000만 ~ 4500만
    #     2번 케이스 산정 점수 - 10억 + 50억 + 33.4억 = 93.4억 (worst)
    #     3번 케이스 산정 점수 - 0.3억 + 0.3억 + 3억 = 3.6억 (best)
    defective_score = random_outstanding_amounts[i] + \
                outstanding_uniform_separated_amounts + \
                    outstanding_deliquency_processed_amounts

    # 계산한 불량 점수가 구간의 end 값 보다 작은지 검사한다.
    # 만약 작다면 해당 구간으로 배치하고
    # 크다면 작은 구간을 만날 때까지 반복시켜야 한다.
    for j in range(len(loan_amounts_range) - 1):
        if defective_score >= calculated_interval[j][1]:
            y[i] = j
            break
print(y)

# 데이터 셋 구성
X = np.column_stack((random_outstanding_amounts, random_outstanding_counts, random_deliquency_rates))

one_hot_labels = np.eye(num_classes + 1)[y]
print(one_hot_labels)

# model = Sequential()
# model.add(Dense(32, activation='relu', input_shape=(3, )))
# model.add(Dense(64, activation='relu'))
# model.add(Dropout(0.5))
# model.add(Dense(32, activation='relu'))
# model.add(Dense(num_classes + 1, activation='softmax'))
#
# model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
#
# model.fit(X, one_hot_labels, epochs=50, batch_size=32)
#
# model.save("loan_model.h5")