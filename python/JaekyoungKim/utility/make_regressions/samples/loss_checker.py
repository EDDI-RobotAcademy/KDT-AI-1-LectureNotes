import math
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


# 서울 청년 1인 가구 기준 평균 한달 생활비가 161만원
# 그러므로 1년 생활비는 1932만원에 해당함
# 그렇기 때문에 실제 소득을 계산할 때
# 평균 생활비를 까고 계산을 적용하는 것이 맞음
def calculate_score(income,
                    private_loan_outstanding_amount,
                    outstanding_amount):

    income_weight = 0.5
    private_loan_outstanding_amount_weight = -3.0
    outstanding_amount_weight = -1.4

    # 서울 기준 1인 가구 평균 1년 생활비 + 세금까지 까고 계산!
    available_income = income - 19320000 - outstanding_amount - (income * 0.3)
    #print(available_income)
    # 계산을 하다보니 log가 음수가 되는 경우가 있습니다.
    # 아래와 같은 Runtime Exception이 발생하고 있습니다.
    # .\utility\make_regression\samples\loss_checker.py:51: RuntimeWarning: invalid value encountered in log10
    #   income_log = np.log10(available_income) * income_weight
    # 결론적으로 음수가 나온 것은 현재 빚만으로도 생활이 쉽지 않다는 것을 의미함
    if available_income < 0:
        return -1

    income_log = np.log10(available_income) * income_weight
    private_loan_outstanding_amount_log = math.log10(private_loan_outstanding_amount + 1)
    private_loan_outstanding_amount_score = \
        private_loan_outstanding_amount_log * private_loan_outstanding_amount_weight

    total_score = income_log + private_loan_outstanding_amount_score - 3.1
    # 실제 출력된 데이터를 토대로 생활비를 제외하고
    # 남은 금액이 800만원 정도인 사람들도 승인이 되고 있었음
    # 이사람들의 점수가 3.46, 3.43 정도이므로 3.5를 까서 승인되지 않게 만듭니다.
    # 대략 소득 7600에 빚 4500이면 1년에 1200정도 여유가 있음
    # 그리고 이 점수가 3.5이므로
    # 3.5를 제한선으로 놓으면 될 것이라 판단됨
    if total_score < 0:
        return -1

    return total_score

sample_number = 10
income = np.random.randint(30000000, 100000001, size=sample_number)
print("income: {0}".format(income))

outstanding_amount = np.random.randint(0, 50000000, size=sample_number)
print("은행빚: {0}".format(outstanding_amount))

#private_loan_outstanding_amount = np.random.randint(0, 20000000, size=sample_number)
#print("사채: {0}".format(private_loan_outstanding_amount))

#total_score = calculate_score(income, private_loan_outstanding_amount, outstanding_amount)
#total_score = calculate_score(income, 0, outstanding_amount)
#print("total_score: {0}".format(total_score))

print(income[0], income[1])

total_score = []
for i in range(sample_number):
    total_score.append(calculate_score(income[i], 0, outstanding_amount[i]))

print("최종 점수:", total_score)

total_score = calculate_score(98000000, 0, 6000000)
print("정상 루틴 점수: {0}".format(total_score))

total_score = calculate_score(99000000, 0, 9000000)
print("정상 루틴 점수: {0}".format(total_score))

# 현재 고려하지 않은 것: 얼마 대출 할 것인가 ?
# 기준을 무엇으로 할 것이냐 ? 소득
# 소득 - 세금 - 빚 = 차액
# 소득 - 세금 - 빚 - 보편적인 평균 생활비 = 빚을 갚는데 사용하는 금액
# 차액 = 빚을 갚는데 사용하는 금액 + 보편적인 평균 생활비
# 현재 계산된 차액은 log 스케일을 적용한 점수값

# 이렇게 되면 결국 거주지가 중요해지는 상황이 오게 됩니다.
# 거주지에 따라 평균 생활비가 달라지기 때문입니다.
# (일단 복잡하니까 우리는 서울 한정으로 진행합니다)

# 서울 청년 1인 가구 기준 평균 한달 생활비가 161만원
# 그러므로 1년 생활비는 1932만원에 해당함
# 그렇기 떄문에 실제 소득을 계산할 때
# 평균 생활비를 까고 계산을 적용하는 것이 맞음