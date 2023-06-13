import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.wrappers.scikit_learn import KerasRegressor
from sklearn.model_selection import KFold, cross_val_score
from sklearn.datasets import make_regression

X, y = make_regression(
    n_samples = 500, n_features = 2,
    n_informative = 2, noise = 5,
    random_state = 0
)
# 이 함수는 생성된 데이터셋을 (X, y) 형태의 튜플로 반환,
# 이때 X는 입력 데이터(독립 변수)를 나타내는 2차원 배열이며,
# y는 출력 데이터(종속 변수)를 나타내는 1차원 배열이다.

print(X.shape)
# (n_samples, n_features)
# 500개의 샘플과 2개의 특성을 가진 2차원 배열
print(y.shape)
# (n_samples, )
# 500개의 샘플에 대한 출력 값을 가지는 1차원 배열

# y = Mx
# y 열 백터
# M 행렬
# x 열 백터

# 열 백터 = 계수 행렬 * 열 백터
#    y   =    M     *   x

def model_build():
    model = Sequential()

    model.add(Dense(16, input_dim = 2, activation = 'relu'))
    model.add(Dense(8, activation = 'relu'))
    model.add(Dense(1))

    model.compile(loss = 'mean_squared_error', optimizer = 'adam')

    return model

MyModel = KerasRegressor(
    build_fn = model_build,
    epochs = 500,
    batch_size = 10,
    verbose = 1
)

# KFold 교차 검증을 위한 목적임
# 교차 검증을 5번 하겠다는 뜻
kf = KFold(n_splits = 5)

# 실제 교차 검증 결과
results = cross_val_score(MyModel, X, y, cv=kf)