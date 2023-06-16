from keras.layers import Dense, Activation
from keras.models import Sequential
from keras.wrappers.scikit_learn import KerasRegressor

from sklearn.datasets import make_regression
from sklearn.model_selection import KFold, cross_val_score

# make_regression 함수를 사용하여 회귀 분석용 가상 데이터셋을 생성합니다.
# n_samples : 샘플 개수
# n_features : 특성(독립 변수) 개수
# n_informative : 유의한 특성 개수
# noise : 잡음의 표준 편차
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

# 열 벡터 = 개수 행렬 * 열 벡터
#    y   =     M    *    x

# 모델 구축
def model_build():
    model = Sequential()

    model.add(Dense(16, input_dim=2, activation='relu'))
    model.add(Dense(8, activation= 'relu'))
    model.add(Dense(1))

    model.compile(loss='mean_squared_error', optimizer='adam')

    return model

# KerasRegressor 클래스를 사용하여 모델 인스턴스를 생성한다.
MyModel = KerasRegressor(
    build_fn = model_build, # model_build 함수를 build_fn 매개 변수로 전달 하여 모델의 구조를 지정
    epochs = 1000,
    batch_size = 10,
    verbose = 1 # verbose 는 학습 과정의 출력을 설정
)

# KFold 쓰는 이유는 교차 검증을 위한 목적임(현재 여기서는 교차 검증을 5번 한다는 뜻이다.)
# 교차 검증을 통해 같은 결과가 나오는 것을 확인 해야 한다.
kf = KFold(n_splits = 8)

# 실제 교차 검증 결과
results = cross_val_score(MyModel, X, y, cv=kf)