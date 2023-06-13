import numpy as np

vector1 = np.array(list(range(1,11)))
print(vector1)

vector1 = np.array(1, 11)
print(vector1)

matrix1 = np.array([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
    [10, 11, 12],
])
print(matrix1)

matrix1 = np.matrix([
    list(range(1, 3)),
    list(range(4, 6)),
    list(range(7, 9)),
    list(range(10, 12)),
])

print(matrix1)
print(matrix1.shape)

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