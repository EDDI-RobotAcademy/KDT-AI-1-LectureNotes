from fastapi import APIRouter
from pydantic import BaseModel

random_income = APIRouter()

# post 요청일 경우
class Item(BaseModel):
    randomNumber: int

@random_income.post("/income-data", response_model=str)
async def receive_income_data(item: Item):
    print("receive_income_data!")

    computer_income = item.randomNumber

    joining_company = '입사 가능'
    not_joining_company = '입사 불가'

    if computer_income > 35000000:
        return joining_company
    return not_joining_company


# get 방식 요청일 경우

# @random_income.get("/get-income-data")
# async def receiver_random_data(annual_income: int):
#     print("receiver_random_data!")
#
#     joining_company = '입사 가능'
#     not_joining_company = '입사 불가'
#
#     if annual_income > 35000000:
#         return joining_company
#     return not_joining_company