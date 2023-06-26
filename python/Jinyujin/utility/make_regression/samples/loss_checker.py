# 대출 해줄 수 있냐 없냐에서 제일 중요한건 갚을 수 있는 능력이 있는지를 보는 것!
# 세금과 생활비 포함하여 산정

import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.wrappers.scikit_learn import KerasRegressor
from sklearn.model_selection import KFold, cross_val_score

from sklearn.datasets import make_regression
from sklearn.model_selection import train_test_split

import pandas as pd
import math

df = pd.read_excel('온라인햇살론_분석정보.xlsx')
print(df)

# 실제 대출한 금액, (대부업권)미상환 금액, (대부업권)미상환 기관 개수, 저축은행업권 미상환 대출총금액
columns_to_keep = ['PRE_LMT', 'LU0024101', 'LU0024201', 'L00080002']

print(df[columns_to_keep])

# 이렇게 4가지를 선별한 근거
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
# math_test에서 가져옴
# income은 가상으로 만들 것임
def calculate_score(income,
                    private_loan_outstanding_amount,
                    outstanding_amount):

    income_weight = 0.5
    private_loan_outstanding_amount_weight = -3.0
    outstanding_amount_weight = -1.4

    # 서울 기준 1인 가구 평균 1년 생활비 + 세금까지 까고 계산!
    available_income = income - 19320000 - outstanding_amount - (income * 0.3)
    # print(available_income)
    # 계산을 하다보니 log가 음수가 되는 경우가 있습니다.
    # 아래와 같은 Runtime Exception이 발생하고 있습니다.
    # .\utility\make_regression\samples\loss_checker.py:51: RuntimeWarning: invalid value encountered in log10
    #   income_log = np.log10(available_income) * income_weight
    # 결론적으로 음수가 나온 것은 현재 빚만으로도 생활이 쉽지 않다는 것을 의미함
    if available_income < 0:
        return -1

    income_log = np.log10(available_income) * income_weight
    # 왜 로그를 사용할까?
    # 데이터 분석 시에는 log를 취하면 정규성이 높아지고
    # 분석에서 정확한 값을 얻을 수 있기 때문임
    # 로그를 취해 데이터 간 편차를 줄여서 정규성을 높일 수 있음
    # 그래서 비교 분석을 비교적 쉽게 할 수 있다고 함!

    # 로그를 만들 때 가중치(income_weight)를 붙여주는 이유는?
    # income에는 양수의 가중치이고 다른 애들은 음수의 가중치를 설정해 주었다
    # why?
    # 데이터 분석 시 가중치를 설정하지 않으면 통계 결과가 과소평가 또는 과대평가 될 수 있는 위험이 존재
    # 예를 들어 화장품 구매 수에 대한 통계를 분석하는데 여자보다 남자가 더 많이 조사된다면
    # 해당년도 화장품 구매가 줄어든 것으로 나타날 것
    # 그래서 여성에 대한 가중치는 높이고 남성에 대한 가중치는 줄여서
    # 남녀 비율을 우리나라 인구의 남녀비인 50:50으로 맞추는 작업을 해주어야 함

    private_loan_outstanding_amount_log = math.log10(private_loan_outstanding_amount + 1)
    # +1을 해준 이유: 로그 함수의 인자가 0이 되는 것을 방지하기 위함
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

# private_loan_outstanding_amount = np.random.randint(0, 20000000, size=sample_number)
# print("사채: {0}".format(private_loan_outstanding_amount))

# total_score = calculate_score(income, private_loan_outstanding_amount, outstanding_amount)
# total_score = calculate_score(income, 0, outstanding_amount)
# print("total_score: {0}".format(total_score))
# 사채가 있고 없고의 차이가 큼
# 사채만 없으면 거의 다 total_score 양수로 나와 대출을 승인 받는 모습을 보임
# 사채가 있으면 거의 음수로 나와서 대출을 거절 당하는 모습

# print(income[0], income[1])

total_score = []
for i in range(sample_number):
    total_score.append(calculate_score(income[i], 0, outstanding_amount[i]))

print("최종 점수:", total_score)

total_score = calculate_score(98000000, 0, 6000000)
print("정상 루틴 점수: {0}".format(total_score))

total_score = calculate_score(99000000, 0, 9000000)
print("정상 루틴 점수: {0}".format(total_score))

# 현재 고려하지 않은 것: 얼마를 대출해줄 것인가
# 우리가 산정한 total_score를 기준으로 대출금액을 정해야
# 기준을 무엇으로 할 것이냐? 소득
# 소득 - 세금 - 빚 = 차액 (지금은 여기까지 함)
# 소득 - 세금 - 빚 - 보편적인 평균 생활비 = 빚을 갚는데 사용하는 금액
# 차액 = 빚을 갚는데 사용하는 금액 + 보편적인 평균 생활비
# 현재 계산된 차액은 log 스케일을 적용한 점수값

# 이렇게 되면 결국 거주지가 중요해지는 상황이 오게 됩니다
# 거주지에 따라 평균 생활비가 달라지기 떄문입니다
# (일단 복잡하니까 우리는 서울 한정으로 진행합니다)

# 서울 청년 1인 가구 기준 평균 한달 생활비가 161만원
# 그러므로 1년 생활비는 1932만원에 해당함
# 그렇기 떄문에 실제 소득을 계산할 때
# 평균 생활비를 까고 계산을 적용하는 것이 맞음