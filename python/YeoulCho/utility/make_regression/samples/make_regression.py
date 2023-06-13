import numpy as np
from keras.models import Sequential
from keras.layers import Dense, Activation
from keras.wrappers.scikit_learn import KerasRegressor
from sklearn.datasets import make_regression

from sklearn.model_selection import KFold, cross_val_score

X, y = make_regression(
    n_samples = 500, n_features = 2,
    n_informative = 2, noise = 5,
    random_state = 0
)

print(X.shape)
print(y.shape)

# y = Mx
# y 열 벡터
# M은 행렬
# x도 열 벡터

# 열 벡터 = 계수 행렬 * 열 벡터
#    y   =    M    *  x

def model_build():
    model = Sequential()

    model.add(Dense(16, input_dim = 2, activation = 'relu'))
    model.add(Dense(8, activation = 'relu'))
    model.add(Dense(1))

    model.compile(loss= 'mean_squared_error', optimizer= 'adam')

    return model


MyModel = KerasRegressor(
    build_fn = model_build,
    epochs = 1000,
    batch_size = 10,
    verbose = 1
)

# 교차 검증을 위한 목적임
kf = KFold(n_splits = 8)

# 실제 교차 검증 결과
results = cross_val_score(MyModel, X, y, cv=kf)

# 아까 간다, 안간다는 모든 케이스들이 이미 정해져 있었기 때문에 1이 나왔던 것이다.
# 현실에서는 불가능

