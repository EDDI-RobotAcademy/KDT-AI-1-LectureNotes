from fastapi import APIRouter

from tensorflow.python.client import device_lib
import tensorflow as tf

import numpy as np
import pandas as pd

ml_router = APIRouter()


@ml_router.get("/ml-device-info")
async def print_device_info():
    print("device info:", device_lib.list_local_devices())
    devices = device_lib.list_local_devices()
    device_info = [{'name': device.name, 'device_type': device.device_type} for device in devices]
    return device_info


@ml_router.get('/get-all-physical-cpu')
async def print_all_physical_cpu():
    physical_cpus = tf.config.list_physical_devices('CPU')
    for cpu in physical_cpus:
        print(cpu)

    logical_cpus = tf.config.list_logical_devices('CPU')
    for logical_cpu in logical_cpus:
        print(logical_cpu)


@ml_router.get('/get-device-details')
async def get_device_details():
    cpus = tf.config.list_physical_devices('CPU')

    for cpu in cpus:
        cpu_details = tf.config.experimental.get_device_details(cpu)
        print(cpu_details)

        #print("Device name:", cpu_details['name'])
        #print("Device index:", cpu_details['device_index'])
        #print("Device physical device desc:", cpu_details['physical_device_desc'])


# 30 ~ 40대의 신용 정보 가상으로 만들어보기
@ml_router.get('/create-virtual-credit')
async def create_virtual_credit():
    mean_age = 35   # 평균(mean)
    std_dev_age = 5 # 표준편차(standard deviation)

    #mean_credit_score = 700
    #std_dev_credit_score = 50

    mean_income = 6000
    std_dev_income = 1500

    mean_arrears_percent = 0.36
    std_dev_arrears_percent = 0.1

    data_size = 1000
    
    # 가우시안 분포(정규 분포)를 따르는 확률 밀도 함수를 생성함 -> np.random.normal()
    # 확률의 종류가 여러 가지 있습니다.
    # 푸아송 분포, 이항 분포, 기하 분포, 정규 분포 등등이 존재합니다
    # 그 중 자연을 반영하는 확률 분포가 가우시안 분포에 해당합니다.
    # exp(-x^2) 형태의 함수를 가지고 있고 x^2 측에 평균과 표준 편차로 그래프 모양이 결정됩니다
    # np.random.normal()에 평균과 표준편차를 입력해서 해당 함수를 따르는 값들을 만들어 달라 요청하는 함수입니다

    # 그래프 추이를 보고 싶다면
    # wolfram alpha로 이동합니다.
    # 수식 편집기에 다음 내용을 입력하세요.
    # y = exp(-((x - 70) / (sqrt(2) * 100.5))^2)
    # 여기서 70은 평균[mean] 값에 해당합니다
    # 그리고 100.5는 표준편차[standard deviation]에 해당합니다
    # 추가적으로 대각선 길이 구할 때 (주유소 문제)
    # Math.sqrt()를 사용 했는데 동일하게 루트를 표현하기 위한 목적으로 사용합니다.
    # 함수의 기본형은 exp(-x^2) 입니다.
    # 평균은 그래프의 중앙이 어느 위치에 있냐를 표현하며
    # 표준편차는 데이터가 얼마나 골고루 분산되어 있는지를 표현합니다
    # 그러므로 신용 정보 관점에서 표준편차는 작을수록 좋긴합니다
    # 크다는 것은 그만큼 간극이 크다는 것을 의미합니다


    age = np.round(np.random.normal(mean_age, std_dev_age, data_size)).astype(int)
    income = np.random.normal(mean_income, std_dev_income, data_size)
    arrears_rate = np.random.normal(mean_arrears_percent, std_dev_arrears_percent, data_size)

    pd.set_option('display.max_rows', None)
    virtual_credit_data = pd.DataFrame({
        '나이': age,
        '소득': income,
        '연체율': arrears_rate
    })

    print(virtual_credit_data)


# pip install openpyxl
@ml_router.get('/make-excel')
async def make_excel():
    info_data = {
        '이름': ['가가가', '나나나', '다다다'],
        '나이': [10, 20, 30],
        '성별': ['남', '남', '여']
    }

    df = pd.DataFrame(info_data)

    file_path = './data.xlsx'
    df.to_excel(file_path, index=False)