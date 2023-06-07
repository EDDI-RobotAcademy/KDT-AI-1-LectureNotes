

# (Vue와 FastAPI가 통신을 할 때 반드시 Spring을 거쳐서 통신하도록 구성하세요)

# 첫 번째 숫자 * 1.25 + 두 번째 숫자 * 1.5 + 세 번째 숫자 * 1.75의 값을 Vue 화면에서 출력해주세요.

import random

from fastapi import APIRouter

request_homework = APIRouter()
# Vue와 Spring을 통신하여 5 ~ 20 사이의 숫자 (첫 번째 숫자)를 받아옵니다.
@request_homework.get("/request-first-homework")
async def request_first_homework():
    return random.randrange (5,20)
# Vue와 FastAPI를 통신하여 10 ~ 20 사이의 숫자 (두 번째 숫자)를 받아옵니다.
@request_homework.get("/request-second-homework")
async def request_second_homework():
    return random.randrange (10,20)

# 또한 Vue가 직접 FastAPI와 통신하여 15 ~ 20 사이의 숫자 (세 번째 숫자)를 받아오도록 구성합니다.
# (이번에는 Spring을 거치지 않고 직접 가져옵니다)

