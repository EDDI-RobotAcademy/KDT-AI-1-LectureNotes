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

# 이 경우 정상 루틴 점수가 0.414정도 나옴
# 정상 루틴 점수가 0.414인 경우 내줄 수 있는 수치를 정해야 함
# 0.414 정도를 800만원으로 지정
# 3년 약정의 경우 2400만원으로 상향 (사실 이러면 일자리가 안정적인지 여부 판정도 해야함)
# 5년 약정으로 4000만원까지 가능하게 구성
total_score = calculate_score(100000000, 0, 40000000)
print("정상 루틴 점수: {0}".format(total_score))

total_score = calculate_score(100000000, 0, 50000000)
print("정상 루틴 점수: {0}".format(total_score))

# 0.392 또한 대략 800만원 정도의 여유가 있음
total_score = calculate_score(70000000, 0, 20000000)
print("정상 루틴 점수: {0}".format(total_score))

# 동일하게 0.392가 나오고 있음
total_score = calculate_score(50000000, 0, 6000000)
print("정상 루틴 점수: {0}".format(total_score))

# 현재 구성한 수식 자체가 소득 -1932 - 세금 -빚이 같아면 모두 같은 점수로 환산됨
# 즉 실제 어떤 사람이 실제로 가용할 수 있는 금액을 점수로 환산했다 볼 수 있음
# 소득이 클수록 은행 대출을 더 많이 땡길 수 있는 것은 맞음

# 현재 케이스에서 최소 금액은 800만원이고 제한선은 그 위로 지정
# 10^8(10 - 1.932 - 3) -> 5천만원 정도
# 10은 소득에서 10^8을 나눈 수치
# 실질적인 수식을 세우기 위해 위쪽에서 계산한 값을 다시 정리해봅니다
# 10^8(소득[비율] - 1.932 - 3)
# 소득[비율] = 실제 소득 /10^8

# 10^8 * (소득[비율] - 1.932 - 3 - 빚[비율])
# 빚[비율] = 실제 빚 / 10^8

# 결국 위의 수식을 통해서 어떤 사람이 가용할 수 있는 금액이 산출되고 있습니다
# 그리고 현재 시스템에서 최소값은 800만원으로 지정하였고
# 최대값은 4000만원으로 지정하도록 합니다
# 만약 소득이 충분하다면 좀 더 장기적인 관점에서 더 큰 액수를 빌려줄 수 있도록 구성할 수도 있습니다
# (우선 여기까진 보류)

# 800만원의 점수를 0.39로 놓고 이 점수보다 아래인 사람들에게는 장기 대출을 고려하지 않을 것
# 0.39 ~ 0.4142 이상이면 800만원

# 그리고 900만원이 되는 조건을 찾아야 함
# (쌤이 금액을 맞추는 비율?을 어떻게 찾고 있는지 모르겠음)
# 이 점수는 0.433까지 올라감
total_score = calculate_score(100000000, 0, 39000000)
print("정상 루틴 점수: {0}".format(total_score))

# 이 점수도 0.433
# 0.41 ~ 0.4235 이상이면 900만원
total_score = calculate_score(50000000, 0, 4000000)
print("정상 루틴 점수: {0}".format(total_score))

# 0.4235 ~ 0.4329 이상이면 1000만원
total_score = calculate_score(100000000, 0, 38000000)
print("정상 루틴 점수: {0}".format(total_score))

# 0.39 ~ 0.4142 이상이면 800만원
# 0.41 ~ 0.4235 이상이면 900만원
# 0.4235 ~ 0.4329 이상이면 1000만원
# 0.4329 ~ 0.4423 -> 1100
# 0.4423 ~ 0.4516 -> 1200
# 0.4516 ~ 0.4610 -> 1300
# 0.4610 ~ 0.4704 -> 1400
# 0.4704 ~ 0.4797 -> 1500
# 0.4797 ~ 0.4891 -> 1600
# 0.4891 ~ 0.4985 -> 1700
# 0.4985 ~ 0.5078 -> 1800
# 0.5078 ~ 0.5172 -> 1900
# 0.5172 ~ 0.5266 -> 2000
# 0.5266 ~ 0.5359 -> 2100
# 0.5359 ~ 0.5453 -> 2200
# 0.5453 ~ 0.5547 -> 2300
# 0.5547 ~ 0.5640 -> 2400
# 0.5640 ~ 0.5734 -> 2500
# 0.5734 ~ 0.5828 -> 2600
# 0.5828 ~ 0.5921 -> 2700
# 0.5921 ~ 0.6015 -> 2800
# 0.6015 ~ 0.6109 -> 2900
# 0.6109 ~ 0.6202 -> 3000
# 0.6202 ~ 0.6296 -> 3100
# 0.6296 ~ 0.6390 -> 3200
# 0.6390 ~ 0.6483 -> 3300
# 0.6483 ~ 0.6577 -> 3400
# 0.6577 ~ 0.6671 -> 3500
# 0.6671 ~ 0.6764 -> 3600
# 0.6764 ~ 0.6858 -> 3700
# 0.6858 ~ 0.6958 -> 3800
# 0.6958 ~ 0.7046 -> 3900
# 0.7046 이상 -> 4000

# 한마디로 대출금액 테이블을 만드는 과정
# score_list = np.linspace(4142, 7046, 32)로 나온 결과로 만든 것

# 그리고 그 테이블에 대한 dictionary를 만들 것
loan_score_table = {
    0.39: 8000000, 0.4142: 9000000, 0.4235: 10000000, 0.4329: 11000000, 0.4423: 12000000,
    0.4516: 13000000, 0.4610: 14000000, 0.4704: 15000000, 0.4797: 16000000, 0.4891: 17000000,
    0.4985: 18000000, 0.5078: 19000000, 0.5172: 20000000, 0.5266: 21000000, 0.5359: 22000000,
    0.5453: 23000000, 0.5547: 24000000, 0.5640: 25000000, 0.5734: 26000000, 0.5828: 27000000,
    0.5921: 28000000, 0.6015: 29000000, 0.6109: 30000000, 0.6202: 31000000, 0.6296: 32000000,
    0.6390: 33000000, 0.6483: 34000000, 0.6577: 35000000, 0.6671: 36000000, 0.6764: 37000000,
    0.6858: 38000000, 0.6958: 39000000, 0.7046: 40000000, 9999: 1000000000000000000000000000
}
# print(loan_score_table)
# 이제 key값을 설정해서 뿌릴 수 있음

# 은행 빚 없는 케이스는 0.75
# 7000 - 1932 := 5000(대략적)
# 실제 가용할 수 있는 금액이 4000이 되는 구간을 찾아야 함
# 실제 최대치인 4000만원을 한계로 지정한다면 0.70 정도의 수치값을 가짐
total_score = calculate_score(100000000, 0, 10000000)
print("정상 루틴 점수: {0}".format(total_score))

# 900만원부터 4000만원이니까 스텝이 32개
# np.arange 특성으로 float 처리가 안되므로
# 각 숫자에 10000을 곱하고 해당 값에 대해 다시 10000을 나눠서 값을 산출
score_list = np.linspace(4142, 7046, 32)  # 정상 루틴 점수에 10000 곱한 값
# print(score_list)


# 대출금액 테이블까지 만들었으니 이제 이걸 토대로 사람의 정보가 들어왔을 때
# 얼마까지 대출해 줄 수 있겠다는 대략적인 판단 가능
# 특정 인물의 소득, 빚 등이 입력되면 대출 승인 및 거절 +
#   승인의 경우 비용 출력 + 거절의 경우 거절 사유 (빚을 얼마까지 탕감해야 하는지)

# 그럼 이제 대출 사이트에서 버튼 누르면 바로 돈 들어온다면?
# 편하긴 할 것 그러나 실제로는 서류 작성해야 하는 것도 많고 암튼 시간이 오래 걸림
# 그런데 뭐하면 편리할꺼라고 하셨는데 못들음

def calculate_loan(score):
    # print(score)
    # score를 4자리 숫자로 잘라내줘야 함
    # print(round(score, 4))

    key_list = list(loan_score_table.keys())
    # print(key_list)
    # key를 list형태로 저장

    # value_list = list(loan_score_table.values())
    # print(value_list)
    # value를 list 형태로 저장

    if key_list[0] > score:
        print("대출 승인 거절!")
        return

    for i, key in enumerate(key_list):
        # key와 value를 한꺼번에 뽑아내기 위해 enum 사용
        # print(i, key, loan_score_table[key]) # 키와 value 잘 매치됨을 확인

        if key_list[i] <= score < key_list[i + 1]:
            print("대출 승인 완료!")
            return loan_score_table[key]

    # print(loan_score_table[0.7046])


print("대출 금액:", calculate_loan(total_score))

# 대출 잘되는 케이스 확인
total_score = calculate_score(100000000, 0, 38000000)
print("정상 루틴 점수: {0}".format(total_score))

print("대출 금액:", calculate_loan(total_score))

# 대출 안되는 케이스 확인
total_score = calculate_score(100000000, 0, 50000000)
print("비정상 루틴 점수: {0}".format(total_score))

print("대출 금액:", calculate_loan(total_score))

# 이제 이걸 가지고 서비스를 만들면?
# 컴퓨터가 알아서 계산해서 대출을 해줄 수 있을지 없을지
# 대출 금액은 얼마 정도가 적정할지 체크해주어
# 시간이 오래 걸리지 않게 바로 대출을 받을 수 있는 편리성을 제공할 수 있음
# 여기에 UI만 붙이면 되는 것!(프로젝트 주제1 완료)
# 근데 여기에서는 약정 기간은 제외한 상태
# 추천 대출 상품도 추가하면 좋을 듯
