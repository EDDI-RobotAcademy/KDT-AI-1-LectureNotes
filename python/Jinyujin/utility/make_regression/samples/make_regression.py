import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.wrappers.scikit_learn import KerasRegressor
from sklearn.model_selection import KFold, cross_val_score

from sklearn.datasets import make_regression

# 데이터 셋 구성
X, y = make_regression(
    n_samples=500, n_features=2,
    n_informative=2, noise=5,
    random_state=0
)
# n_samples: 표본 개수
# n_features: 독립 변수의 수
# n_informative: 독립 변수 중 실제로 종속 변수와 상관 관계가 있는 독립 변수의 수
# noise: 표준편차
# random_state: 시작값

print(X.shape) # 결과: (500, 2)
print(y.shape) # 결과: (500,)
# 회귀분석을 하려면 x는 2차원 배열이어야 하고 y는 1차원 또는 2차원 배열이어야 한다
# 그래야 fit()메서드를 통하여 학습시킬 수 있음


# y = Mx
# y 열 벡터
# M은 행렬
# x도 열 벡터

# 열 벡터 = 계수 행렬 * 열 벡터
#    y   =     M    *   x

# 학습시킬 모델 생성
def model_build():
    model = Sequential()

    model.add(Dense(16, input_dim=2, activation='relu'))
    model.add(Dense(8, activation='relu'))
    model.add(Dense(1))

    model.compile(loss='mean_squared_error', optimizer='adam')
    # mean_squared_error: 예측 값과 실제 값 사이에 평균 제곱 오차

    return model

# 학습시키기
MyModel = KerasRegressor(
    build_fn=model_build,
    epochs=1000,
    batch_size=10,
    # batch_size: 연산 한번에 들어가는 데이터의 크기 설정
    verbose=1
    # 얘는 잘 모르겠음
    # verbose=1이면 정보를 상세하게 출력하는 명령이라고 함
)

# KFold를 사용하는 이유
# 교차 검증을 위한 목적임
# 교차 검증이란 쉽게 말해 데이터를 여러 번 반복해서 나누고 여러 모델을 학습하여 성능을 평가하는 방법이다.
# 이렇게 하는 이유는 데이터를 학습용/평가용 데이터 세트로 여러 번 나눈 것의 평균적인 성능을 계산하면,
# 한 번 나누어서 학습하는 것에 비해 일반화된 성능을 얻을 수 있기 때문이다.

# 교차 검증을 왜 할까?
# 우리가 세워 놓은 모델로만 학습을 시켜서 정확성이 100%라고 해도
# 새로운 데이터를 추가시켰을 때 예측에 실패하면 과적합됐다고 표현함
# 이를 방지하기 위해 교차검증이 필요한 것
# 즉 학습이 얼마나 잘 '일반화'되어 있는지 확인하기 위함

kf = KFold(n_splits=8)
# 몇개의 폴드로 나눌거니?

# 실제 교차 검증 결과
# 지정된 모델과 데이터 셋을 사용하여 교차 검증
results = cross_val_score(MyModel, X, y, cv=kf)
# cv: 교차검증 뭐로 할지 정하는 것
# 최종적으로 교차 검증했을 때 올바른 추론을 해낼 가능성: 100 - loss
# 아무리 해도 loss 값을 0으로 만들기는 불가능
# 이번 과제의 경우는 가능했음 왜?
# 모든 상황이 다 정해져 있었으니까
# 정해져 있지 않은 상황이 주어지면 계산 못하게 됨