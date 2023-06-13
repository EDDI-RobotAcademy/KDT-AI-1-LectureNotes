# 엔코딩

import numpy as np

traffic_light = ['빨간색', '노란색', '초록색']

def one_hot_encode(signal):
    encoded_signal = np.zeros(len(traffic_light))
    # numpy.zeros(n)
    # n만큼 길이의 배열로 만들어주는 메서드
    # 여기서는 3만큼의 배열로 반환해줌
    encoded_signal[traffic_light.index(signal)] = 1
    # index() 함수
    # 배열에서 원하는 값의 위치를 찾아줌
    # 여기서는 traffic_light의 signal의 값이 1인 위치를 찾아줄 것
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

# 엔코딩은 결국 뭘하려는 걸까?
# 3개의 숫자값이 있고 3개의 숫자값의 상태가 0,1로 나타남
# 문자를 숫자로 만드는게 쉬울까? 숫자를 문자로 만드는게 쉬울까? 당연 전자
# => 해당 문자를 대체할 수 있는 숫자값을 만들어준 것
# 결국 딥러닝 시키기 위해 해주는 것
