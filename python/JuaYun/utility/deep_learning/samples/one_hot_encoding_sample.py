import numpy as np

traffic_light = ["빨간색", "노란색", "초록색"]

def one_hot_encode(signal):
    encoded_signal = np.zeros(len(traffic_light))
    encoded_signal[traffic_light.index(signal)] = 1
    return encoded_signal

current_traffic_light = '초록색'
encoded_signal = one_hot_encode(current_traffic_light)
print('현재 신호등의 상태:', current_traffic_light)
print('엔코딩 결과:', encoded_signal)

current_traffic_light = '빨간색'
encoded_signal = one_hot_encode(current_traffic_light)
print('현재 신호등의 상태:', current_traffic_light)
print('엔코딩 결과:', encoded_signal)

current_traffic_light = '노란색'
encoded_signal = one_hot_encode(current_traffic_light)
print('현재 신호등의 상태:', current_traffic_light)
print('엔코딩 결과:', encoded_signal)