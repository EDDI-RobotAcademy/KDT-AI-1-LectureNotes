# 행렬 연산

import numpy as np

matrix1 = np.array([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
    [10, 11, 12],
])
print(matrix1)

matrix2 = np.matrix([
    list(range(1, 4)),
    list(range(4, 7)),
    list(range(7, 10)),
    list(range(10, 13)),
])
print(matrix2)

matrix_sum = matrix1 + matrix2
print(matrix_sum)

# 행렬 곱은 에러가 나옴 -> 차원이 맞지 않을 경우!
# matrixMulityply = matrix1 * matrix2
# 행렬은 (m, n) 형태의 차원을 가지고 있습니다
# 곱셈 연산이 가능하려면 아래 조건을 만족해야 합니다
# 행렬 A (mA, nA) 와 행렬 B (mB, nB)가 있을 때
# nA와 mB의 차원이 서로 일치해야 곱셈이 가능합니다
# 그러므로 둘의 연산을 가능하게 만들려면 전치(Transpose)를 해줘야 합니다

matrix2 = matrix2.transpose()
matrix_mulityply = matrix1 * matrix2
print(matrix_mulityply)
# 행렬의 곱셈 결과는 (mA, nB)의 형태가 됩니다
# 그러므로 (4, 3)과 (3, 4)를 곱하면 (4, 4)가 됩니다

# transpose 간단하게 표현하기
matrix2 = np.matrix([
    list(range(1, 4)),
    list(range(4, 7)),
    list(range(7, 10)),
    list(range(10, 13)),
])

matrix_mulityply2 = matrix1 * matrix2.T
print(matrix_mulityply2)
print(matrix_mulityply2.shape) # (4, 4)
# tanspose를 직접 입력하기에 많다 생각되는 경우
# 실제 수학에서 전치 행렬에 해당하는 T 형태의 기호를 사용하여 전치가 가능함
# (원래 파이썬이 초기에 과학자들을 대상으로 만들어졌기 때문에 이러한 기능도 지원되고 있음)

vector1 = np.arange(1, 11)
print(vector1.shape) # (10,)

vector2 = np.arange(1, 11)
print(vector2.T.shape) # 이것도 (10,)
# 벡터는 연산할 때 행과 열을 구분하지 않아줘도 되는 듯
# 여기서 배열로 표시해줬는데 배열은 원래 행과 열의 구분이 없음
# 행렬이면 1행이어도 10열로 취급하는데 벡터는 그렇지 않다는 것!
# 그냥 벡터도 원래 그렇다고 받아들이자

# 저번 시간 y = Mx
# y(vector)
# M(matrix)
# x(vector)

# vector3 = vector2.reshape(1, -1)
# print(vector3)
# print(vector3.T)

vector3 = np.arange(0, 11, 2)
print(vector3)

# 벡터를 행렬로 재형성
matrix6 = vector3.reshape((2, 3))
print(matrix6)
print(matrix6.shape)

# 행렬 전체에 대한 덧셈
matrix7 = matrix6 + 3
print(matrix7)

# 나중에 shape 안맞아서 오류나는 경우 많다고 함!
print(matrix7.shape[0]) # 행
print(matrix7.shape[1]) # 열

# 행렬을 다시 백터로 바꾸기
converted_matrix = matrix7.reshape(matrix7.shape[0] * matrix7.shape[1])
print(converted_matrix)

