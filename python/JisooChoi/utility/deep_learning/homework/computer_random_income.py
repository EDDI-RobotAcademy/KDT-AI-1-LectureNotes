from fastapi import APIRouter

random_income = APIRouter()


@random_income.get("/get-income-data")
async def receiver_random_data(annual_income: int):
    print("receiver_random_data!")

    joining_company = '입사 가능'
    not_joining_company = '입사 불가'

    if annual_income > 35000000:
        return joining_company
    return not_joining_company