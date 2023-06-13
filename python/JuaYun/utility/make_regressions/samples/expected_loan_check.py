import math

import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.wrappers.scikit_learn import KerasRegressor
from sklearn.model_selection import KFold, cross_val_score

from sklearn.datasets import make_regression
from sklearn.model_selection import train_test_split

import pandas as pd

df = pd.read_excel('온라인햇살론_분석정보.xlsx')
print(df)

# 실제 대출한 금액, (대부업권)미상환 금액, (대부업권)미상환 기관 개수, 저축은행업권 미상환 대출총금액
columns_to_keep = ['PRE_LMT', 'LU0024101', 'LU0024201', 'L00080002']

print(df[columns_to_keep])

columns_to_keep = ['LU0024101', 'L00080002']
print(df[columns_to_keep])

def calculate_score(income,
                    private_loan_outstanding_amount,
                    outstanding_amount):
    income_weight = 0.5
    private_loan_outstanding_amount_weight = -3.0
    outstanding_amount_weight = -1.4

    available_income = income - 19320000 - outstanding_amount - (income * 0.3)
    if available_income < 0:
        return -1

    income_log = np.log10(available_income) * income_weight
    private_loan_outstanding_amount_log = math.log10(private_loan_outstanding_amount + 1)
    private_loan_outstanding_amount_score = \
        private_loan_outstanding_amount_log * private_loan_outstanding_amount_weight

    total_score = income_log + private_loan_outstanding_amount_score - 3.1
    if total_score < 0:
        return -1

    return total_score

sample_number = 10
income = np.random.randint(30000000, 100000001, size=sample_number)
print("income: {0}".format(income))

outstanding_amount = np.random.randint(0, 50000000, size=sample_number)
print("은행빚: {0}".format(outstanding_amount))

print(income[0], income[1])

total_score = []
for i in range(sample_number):
    total_score.append(calculate_score(income[i], 0, outstanding_amount[i]))

print("최종 점수:", total_score)

total_score = calculate_score(100000000, 0, 0)
print("정상 루틴 점수: {0}".format(total_score))

total_score = calculate_score(30000000, 0, 0)
print("정상 루틴 점수: {0}".format(total_score))

# 0.41 정도를 800만원으로 지정
# 3년 양정의 경우 2400만원으로 상향 (사실 이러면 일자리가 안정적인지 여부 판정도 해야함)
# 5년 약정으로 4000만원까지 가능하게 구성ㅇ
total_score = calculate_score(100000000, 0, 40000000)
print("정상 루틴 점수: {0}".format(total_score))

# 5천만원에선 대출 거절
total_score = calculate_score(100000000, 0, 50000000)
print("정상 루틴 점수: {0}".format(total_score))

# 0.392 또한 대략 800만원 정도의 여유가 있음
total_score = calculate_score(70000000, 0, 20000000)
print("정상 루틴 점수: {0}".format(total_score))

# 동일하게 0.392가 나오고 있음
# 현재 구성한 수식 자체가 소득 - 1932 - 세금 - 빚이 같다면 모두 같은 점수로 환산됨
# 즉 실제 어떤 사람이 실제로 가용할 수 있는 금액을 점수로 환산했다 볼 수 있음
total_score = calculate_score(50000000, 0, 6000000)
print("정상 루틴 점수: {0}".format(total_score))

# 현재 케이스에서 최소 금액은 800만원이고 제한선은 그 위로 지정
# 실질적인 수식을 세우기 위해 위쪽에서 셰산한 값을 다시 정리해봅시다.
# 10^8 * (소득[비율] - 1.932 - 3)
# 소득[비율] = 실제 소득 / 10^8

# 10^8 * (소득[비율] - 1.932 - 3 - 빚[비율])
# 빚[비율] = 실제 빚 / 10^8

# 결국 위의 수식을 통해서 어떤 사람이 가용할 수 있는 금액이 산출되고 있습니다.
# 그리고 현재 시스템에서 최소값은 800만원으로 지정하였고
# 최대값은 4000만원으로 지정하도록 합니다.
# 만야 소득이 충분하다면 좀 더 장기적인 관점에서 더 큰 액수를 빌려줄 수 있도록 구성할 수도 있습니다.
# (우선 여기까진 보류)

# 0.40 ~ 0.4142 이상이면 800만원
total_score = calculate_score(100000000, 0, 39000000)
print("정상 루틴 점수: {0}".format(total_score))

# 0.41 ~ .4235 이상이면 900만원
total_score = calculate_score(50000000, 0, 4000000)
print("정상 루틴 점수: {0}".format(total_score))

# 0.4235 ~ 0.4329 -> 1000만원
total_score = calculate_score(100000000, 0, 38000000)
print("정상 루틴 점수: {0}".format(total_score))

# 0.4329 ~ 0.4423 -> 1100
# 0.4423 ~ 0.4516 -> 1200
# 0.4516 ~ 0.4610 -> 1300
# 0.4610 ~ 0.4704 -> 1400
# 0.4704 ~ 0.4797 -> 1500
# 0.4797 ~ 0.4891 -> 1600
# 0.4891 ~ 0.4985 -> 1700
# 0.4985 ~ 0.5078 -> 1800
# ~ 0.5172
# ~ 0.5266
# ~ 0.5453
# ~ 0.5547
# ~ 0.5640
# ~ 0.5734
# ~ 0.5828
# ~ 0.5921
# ~ 0.6015
# ~ 0.6109
# ~ 0.6202
# ~ 0.6296
# ~ 0.6390
#

# 0.75
# 7000  - 1932 := 5000
# 실제 최대치인 4000만원을 한계로 지정한다면 0.70 정도의 수치값을 가짐
total_score = calculate_score(100000000, 0, 10000000)
print("정상 루틴 점수: {0}".format(total_score))

score_list = np.linspace(4142, 7046, 32)
print(score_list)