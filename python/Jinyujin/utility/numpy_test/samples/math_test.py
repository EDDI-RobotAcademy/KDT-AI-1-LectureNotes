import math
import random
import numpy as np

def calculate_score(income, outstanding_amount, delinquency_rate):
    income_weight = 0.4 # 소득
    outstanding_amount_weight = -0.3 # 사채
    delinquency_rate_weight = -0.3 # 연체율

    income_log = np.log10(income)
    # log10으로 변환
    # 추후 미상환 건수를 고려할 때 amount * count 이후 log 스케일 적용이 적합하다 판단됨
    outstanding_amount_log = np.log10(outstanding_amount + 1)

    income_score = income_log * income_weight
    outstanding_amount_score = outstanding_amount_log * outstanding_amount_weight
    delinquency_rate_score = delinquency_rate * delinquency_rate_weight

    final_score = income_score + outstanding_amount_score + delinquency_rate_score

    return final_score
    # 이 점수로 대출을 해줄 수 있는지 없는지 판단하는 것

sample_number = 10
income = np.random.randint(30000000, 45000001, size=sample_number)
print(income)
print("income: {0}".format(income))
# {순서}.format(출력값)
# 이러면 첫번째에 있는 income값만 출력되어야 하는 것 아닌가?
# 지금은 1차원 배열이기 때문에 배열 자체가 income값이 되는 것
print(income[0])
# 이렇게 해야지 첫번째 값만 나오네
# 중괄호{}와 대괄호{}의 차이가 있는 것 같음

outstanding_amount = np.random.randint(0, 10000000, size=sample_number)
print("outstanding_amount: {0}".format(outstanding_amount))

delinquency_rates = np.random.uniform(0.0, 0.3, size=sample_number)
print("delinquency_rates: {0}".format(delinquency_rates))

final_score = calculate_score(income, outstanding_amount, delinquency_rates)
print("final_score: {0}".format(final_score))