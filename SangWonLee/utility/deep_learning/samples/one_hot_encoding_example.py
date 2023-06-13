import numpy as np

# 수치 계산을 위한 핵심 라이브러리.

traffic_light = ["빨간색", "노란색", "초록색"]


def one_hot_encode(signal):
    encoded_signal = np.zeros(len(traffic_light))
    # 지정된 크기의 배열을 생성하고 모든 요소를 0으로 초기화 한다. [0, 0, 0]
    encoded_signal[traffic_light.index(signal)] = 1
    # traffic_light 리스트에서 signal이 위치한 인덱스를 찾고,
    # 그 인덱스를 이용하여 encoded_signal 배열의 해당 위치에 1을 할당한다.
    return encoded_signal


def inverse_data(signal):
    index = np.argmax(signal)
    # 가장 큰 값의 index의 번호를 반환한다. ex) [0, 1, 0] 이면 1이 제일 크니까 '1' 을 반환함(index의 1임)
    original_data = traffic_light[index]
    # traffic_light 의 index를 가져옴

    return original_data


current_traffic_light = '초록색'
encoded_signal = one_hot_encode(current_traffic_light)
print('현재 신호등의 상태:', current_traffic_light)
print('엔코딩 결과:', encoded_signal)
original_signal = inverse_data(encoded_signal)
print(original_signal)

current_traffic_light = '빨간색'
encoded_signal = one_hot_encode(current_traffic_light)
print('현재 신호등의 상태:', current_traffic_light)
print('엔코딩 결과:', encoded_signal)
original_signal = inverse_data(encoded_signal)
print(original_signal)

current_traffic_light = '노란색'
encoded_signal = one_hot_encode(current_traffic_light)
print('현재 신호등의 상태:', current_traffic_light)
print('엔코딩 결과:', encoded_signal)
original_signal = inverse_data(encoded_signal)
print(original_signal)
