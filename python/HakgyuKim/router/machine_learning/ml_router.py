from fastapi import APIRouter

from tensorflow.python.client import device_lib
import tensorflow as tf

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

        # print("Device name:", cpu_details['name'])
        # print("Device index:", cpu_details['device_index'])
        # print("Device physical device desc:", cpu_details['physical_device_desc'])

    # cpu-z라는 툴을 다운 받아봅시다.
    # 여러분들 컴퓨터의 스펙 사항을 해당 툴을 통해서 확인 할 수 있습니다.
    # 그리고 이 스펙 사항과 python 코드가 구동한 결과가 일치해야 올바르게 동작합니다.


import numpy as np
import pandas as pd

# 30 ~ 40신용 정보 가상으로 만들어보기
@ml_router.get('/create-virtual-credit')
async def create_virtual_credit():
    mean_age = 35       # 평균(mean)
    std_dev_age = 5     # 표준편차 (standard deviation)

    # mean_credit_score = 700
    # std_dev_credit_score = 50

    mean_income = 6000
    std_dev_income = 1500

    mean_arrears_percent = 0.36
    std_dev_arrears_percent = 0.1

    data_size = 1000

    age = np.round(np.random.normal(mean_age, std_dev_age, data_size)).astype(int)
    income = np.random.normal(mean_income, std_dev_income, data_size)
    arrears_rate = np.random.normal(mean_arrears_percent, std_dev_arrears_percent, data_size)

    virtual_credit_data = pd.DataFrame({
        '나이': age,
        '소득': income,
        '연체율': arrears_rate
    })

    print(virtual_credit_data)