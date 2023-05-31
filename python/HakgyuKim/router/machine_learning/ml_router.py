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