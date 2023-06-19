import numpy as np

def calculate_score(income, outstanding_amount, delinquency_rate):
    # 1. 가중치 설정
    income_weight = 0.4
    outstanding_amount_weight = -0.3
    delinquency_rate_weight = -0.3
    # Q. 가중치를 설정하는 이유?
    # A. 각 변수의 중요도를 조절하고, 계산에 미치는 영향력을 조절하기 위함이다.
    #    다양한 변수가 주어진 상황에서 각 변수가 최종 점수에
    #    어느정도 영향을 미치는 지를반영하기 위해 가중치를 사용한다.
    #    가중치는 변수의 상대적인 중요성을 나타내며,
    #    높은 가중치를 가진 변수는 해당 점수에 더 큰 영향을 줄 수 있다.

    # 2. 변수 변환
    # income 변수에 로그 스케일을 적용했다.
    # 로그 스케일을 적용함으로써 값의 범위를 변환한다.
    income_log = np.log10(income)
    # 추후 미상환 건수를 고려할 때 amount * count 이후 log 스케일 적용이 적합하다.
    outstanding_amount_log = np.log10(outstanding_amount + 1)

    # 3. 변수에 가중치 적용
    income_score = income_log * income_weight
    outstanding_amount_score = outstanding_amount_log * outstanding_amount_weight
    delinquency_rate_score = outstanding_amount_log * delinquency_rate * delinquency_rate_weight

    # 4. 최종 점수 계산
    final_score = income_score + outstanding_amount_score + delinquency_rate_score

    return final_score

sample_number = 10
# 수입
income = np.random.randint(30000000, 45000001, size=sample_number)
print("income: {0}".format(income))

# 미결제 금액
outstanding_amount = np.random.randint(0, 1000000000, size=sample_number)
print("outstanding_amount: {0}".format(outstanding_amount))

# 과실률
deliquency_rates = np.random.uniform(0.0, 0.3, size=sample_number)
print("deliquency_rates: {0}".format(deliquency_rates))

# 최종 점수
final_score = calculate_score(income, outstanding_amount, deliquency_rates)
print("final_score: {0}".format(final_score))