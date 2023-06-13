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

# 같은 위치의 같은 자리만 더함
matrix3 = matrix1 + matrix2
print(matrix3)

# matrix4 = matrix1 * matrix2
# print(matrix4)
# 행렬은 (m, n) 형태의 차원을 가지고 있습니다.
# 곱셈 연산이 가능하려면 아래 조건을 만족해야 합니다.
# 행렬 A (mA, nA) 와 행렬 B (mB, nB)가 있을 때
# nA와 nB의 차원이 서로 일치해야 곱셈이 가능합니다.
# 행과 열의 방향의 갯수가 같아야함
# 그러므로 둘의 연산을 가능하게 만들려면 전치(Transpose)를 해줘야 합니다.

matrix2 = matrix2.transpose()
print("matrix1:\n", matrix1)
print("matrix2:\n", matrix2)
matrix4 = matrix1 * matrix2
print("matrix4:\n", matrix4)
# 행렬의 곱셈 결과는 (mA, nB) 형태가 됩니다.
# 그러므로 (4, 3) 과 (3, 4)를 곱하면 (4, 4)가 됩니다.
# matrix2 는 행과 열을 뒤집음
# matrix1행과 matrix2열을 순차적으로 곱하여 더함
# 행렬의 곱 = 벡터의 외적 = 차원의 일치

matrix2 = np.matrix([
    list(range(1, 4)),
    list(range(4, 7)),
    list(range(7, 10)),
    list(range(10, 13))
])

# transpose 를 직접 입력하기에 많다 생각되는 경우
# 실제 수학에서 전치 행렬에 해당하는 T 형태의 기호를 사용하여 전치가 가능함
# (원래 파이썬이 초기에 과학자들을 대상으로 만들어졌기 때문에 이러한 기능도 지원이 되고 있음)
matrix5 = matrix1 * matrix2.T
print(matrix5)
print(matrix5.shape)

vector1 = np.arange(1, 11)
print(vector1.shape)

vector2 = np.arange(1, 11)
print(vector2.T.shape)

# y = Mx
# y(vector)
# M(matrix)
# x(vector)

vector3 = np.arange(0, 11, 2)
print(vector3)

# reshape((2, 3)) 해당 배열의 2행 3열을 만들어 줌
matrix6 = np.arange(0, 11, 2).reshape((2, 3))
print(matrix6)
print(matrix6.shape)

matrix7 = matrix6 + 3
print(matrix7)

# 행과 열의 차원을 분리
print(matrix7.shape[0])
print(matrix7.shape[1])

# 분리된 행과 열을 백터로 변경
converted_matrix = matrix7.reshape(matrix7.shape[0] * matrix7.shape[1])
print(converted_matrix)