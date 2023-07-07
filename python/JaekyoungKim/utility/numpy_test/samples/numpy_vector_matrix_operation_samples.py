import numpy as np

matrix1 = np.array([
    [1,2,3],
    [4,5,6],
    [7,8,9],
    [10,11,12],
])
print(matrix1)

matrix2 = np.matrix([
    list(range(1,4)),
    list(range(4,7)),
    list(range(7,10)),
    list(range(10,13)),
])
print(matrix2)

matrix3 =matrix2 + matrix1

print(matrix3)

# 행렬은 (m,n) 형태의 차원을 가지고 있습니다.
# 곱셈 연산이 가능하려면 아래 조건을 만족해야 합니다.
# 해열ㄹ A (mA, nA) 와 행렬 B (mB , nB) 가 있을 때
# nA와 nB의 차원이 서로 일치해야 곱셈이 가능합니다.
# 그러므로 두의 연산을 가능하게 만들려면 전치(Transpose)를 해줘야 합니다.
matrix2 = matrix2.transpose()
print("matrix1:\n", matrix1)
print("matrix2:\n", matrix2)
matrix4 = matrix1 * matrix2
print(matrix4)

#transpose를 직접 입력하기에 많다 생각되는 경우
# 실제 수학에서 전치 행렬에 해당하는 T 형태의 기호를 사요하여 전치가 가능함
# (원래 파이썬이 초기에 과학자들을 대상으로 만들어졌기 때문에 이러한 기능도 지원이 되고 있을)

matrix2 = np.matrix([
    list(range(1,4)),
    list(range(4,7)),
    list(range(7,10)),
    list(range(10,13)),
])

matrix5 = matrix1 * matrix2.T
print(matrix5)
print(matrix5.shape)

vector1 = np.arange(1,11)
print(vector1.shape)
vector2 = np.arange(1,11)
print(vector2.T.shape)
print("----------")
# y= Mx
# y(vector)
# M(matrix)
# x(vector)
vector3 = np.arange(0,11,2)
print(vector3)

matrix6 = vector3.reshape(2,3)
# reshape 괄호 안의 모습으로 바꿔주는 것
print(matrix6)
print(matrix6.shape)

matrix7 = matrix6 + 3
print(matrix7)

print(matrix7.shape[0])
print(matrix7.shape[1])

converted_matrix = matrix7.reshape(matrix7.shape[0] * matrix7.shape[1])
print(converted_matrix)