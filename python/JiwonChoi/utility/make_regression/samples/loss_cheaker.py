import math

import numpy as np
from keras.models import Sequential

import pandas as pd

df = pd.read_excel('온라인햇살론_분석정보.xlsx')
print(df)

# 실제 대출한 금액, (대부업권)미상환 금액, (대부업권)미상환 기관 개수
# 은행업권 제외 미상환 건수, 저축은행업권 미상환 대출총금액

columns_to_keep = ['PRE_LMT', 'LU0024101', 'LU0024201', 'L2A000105', 'L00080002']

print(df[columns_to_keep])

# 근거: 어차피 우리가 은행이라 가정한다면
# 미상환 금액과 미상환 건수 등등이 많은 사람의 신용도가 낮기 때문에
# 정상적인 기관이라면 이런 부분에 적절한 제한을 두는 것이 맞기 때문임

# 소득 정보가 없다보니 결론적으로 PRE_LMT(대출 금액) 정보 자체가 의미가 없음
# 그러므로 이전에 만들었던 미상환 금액, 미상환 건수 등등을 기반으로한 점수 계산 매커니즘을 조금 가공해서
# 음수값이 나오면 대출 승인을 거절하고,
# 양수값이 나오면 비율에 따라 차등 조정하는 방식을 사용하는 것이 옳다고 판단됨
columns_to_keep = ['LU0024101', 'L00080002']

print(df[columns_to_keep])


def calculate_score(income,
                    private_loan_outstanding_amount,
                    outstanding_amount):

    income_weight = 0.6
    private_loan_outstanding_amount_weight = -0.5
    outstanding_amount_weight = -0.2

    income_log = np.log10(income) * income_weight
    private_loan_outstanding_amount_log = np.log10(private_loan_outstanding_amount + 1)
    private_loan_outstanding_amount_score = \
        private_loan_outstanding_amount_log * private_loan_outstanding_amount_weight
    outstanding_amount_log = np.log10(outdtanding_amount + 1)

    total_outstanding_amount = \
        private_loan_outstanding_amount * outstanding_amount
    print("total_outstanding_amount:", total_outstanding_amount)
    total_outstanding_amount_log = np.log10(outstanding_aount + 1)
    outstanding_amount_log = np.log10(outstanding_amount + 1)


    return final_score

sample_number = 10
income = np.random.randint(3000000, 45000001, size=sample_number)
print("income: {0}".format(income))

private_loan_outstanding_amount = np.random.randint(0, 1000000000, size=sample_number)
print("outstanging_amount: {0}".format(private_loan_outstanding_amount))

outstanding_amount = np.random.randint(0, 3000000, size=sample_number)
print("deliquency_rated: {0}".formate(outstanding_amount))

private_loan_outstanding_amount = np.random.randint(0, 1000000000, size=sample_number)
print("outstanding_amount: {0}".format(private_loan_outstanding_amount))

total_score = calculate_score(income, private_loan_outstanding_amount, outstanding_amount)
print("total_score: {0}".format(total_score))



# total_score = calculate_score(1000000000, 0, 0)
# print("정상 루틴 점수: {0}".format(total_score)

total_score = calculate_score()