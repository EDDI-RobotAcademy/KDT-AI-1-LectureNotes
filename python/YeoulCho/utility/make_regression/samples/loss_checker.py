import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.wrappers.scikit_learn import KerasRegressor
from sklearn.model_selection import KFold, cross_val_score

from sklearn.datasets import make_regression
from sklearn.model_selection import train_test_split

import pandas as pd

df = pd.read_excel('../../../온라인햇살론_분석정보.xlsx')
print(df)

# 실제 대출한 금액, (대부업권)미상환 금액, (대부업권)미상환 기관 개수, 저축은행업권 미상환 대출총금액
columns_to_keep = ['PRE_LMT', 'LU0024101', 'LU0024201', 'L00080002']

print(df[columns_to_keep])

# 근거:
# 어차피 우리가 은행이라 가정한다면
# 미상환 금액과 미상환 건수 등등이 많은 사람의 신용도가 낮기 때문에
# 정상적인 기관이라면 이런 부분에 적절한 제한을 두는 것이 맞기 때문임

# 소득 정보가 없다보니 결론적으로 PRE_LMT(대출 금액) 정보 자체가 의미가 없음
# 그러므로 이전에 만들었던 미상환 금액, 미상환 건수 등등을 기반으로한
# 점수 계산 메커니즘을 조금 가공해서
# 음수값이 나오면 대출 승인을 거절하고,
# 양수값이 나오면 비율에 따라 차등 조정하는 방식을 사용하는 것이 옳다고 판단됨
columns_to_keep = ['LU0024101', 'L00080002']

print(df[columns_to_keep])


def calculate_score(income,
                    private_loan_outstanding_amount,
                    outstanding_amount):

    income_weight = 0.6
    private_loan_outstanding_amount_weight = -0.5
    outstanding_amount_weight = -0.3

    income_log = np.log10(income) * income_weight
    private_loan_outstanding_amount_log = np.log10(private_loan_outstanding_amount + 1)
    private_loan_outstanding_amount_score = \
        private_loan_outstanding_amount_log * private_loan_outstanding_amount_weight
    outstanding_amount_log = np.log10(outstanding_amount + 1)
    outstanding_amount_score = \
        outstanding_amount_log * outstanding_amount_weight

    total_score = income_log + outstanding_amount_score + \
                  private_loan_outstanding_amount_score

    return total_score

sample_number = 10
income = np.random.randint(30000000, 100000001, size=sample_number)
print("income: {0}".format(income))

outstanding_amount = np.random.randint(0, 10000000, size=sample_number)
print("은행빚: {0}".format(outstanding_amount))

private_loan_outstanding_amount = np.random.randint(0, 20000000, size=sample_number)
print("사채: {0}".format(private_loan_outstanding_amount))

total_score = calculate_score(income, private_loan_outstanding_amount, outstanding_amount)
print("total_score: {0}".format(total_score))

total_score = calculate_score(98000000, 0, 6000000)
print("정상 루틴 점수: {0}".format(total_score))

total_score = calculate_score(99000000, 0, 9000000)
print("정상 루틴 점수: {0}".format(total_score))