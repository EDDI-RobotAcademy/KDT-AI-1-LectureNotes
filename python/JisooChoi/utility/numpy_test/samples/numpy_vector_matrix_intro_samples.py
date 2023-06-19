import numpy as np

vector1 = np.array(list(range(1, 11)))
print(vector1)

vector1 = np.arange(1, 11)
print(vector1)

matrix1 = np.array([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
    [10, 11, 12],
])
print(matrix1)

matrix1 = np.matrix([
    list(range(1, 4)),
    list(range(4, 7)),
    list(range(7, 10)),
    list(range(10, 13)),
])
print(matrix1)
print(matrix1.shape)

# 업으로 삼지 않을 것이면 몰라도 괜찮은 부분
# 행렬 안에 행렬이 들어가 있는 형태 (이미지 분석, 비디오 분석에 활용)
tensor1 = np.array([
    [
        [1, 2, 3],
        [4, 5, 6],
    ],
[
        [7, 8, 9],
        [10, 11, 12],
    ],
])
print(tensor1)
print(tensor1.shape)