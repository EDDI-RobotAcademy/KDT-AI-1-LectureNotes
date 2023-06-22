import math
import numpy as np

from fastapi import APIRouter
from pydantic import BaseModel

loan_receiver = APIRouter()

def calculate_loan(score):

    loan_score_table = {
        0.39: 8000000, 0.4142: 9000000, 0.4235: 10000000, 0.4329: 11000000, 0.4423: 12000000,
        0.4516: 13000000, 0.4610: 14000000, 0.4704: 15000000, 0.4797: 16000000, 0.4891: 17000000,
        0.4985: 18000000, 0.5078: 19000000, 0.5172: 20000000, 0.5266: 21000000, 0.5359: 22000000,
        0.5453: 23000000, 0.5547: 24000000, 0.5640: 25000000, 0.5734: 26000000, 0.5828: 27000000,
        0.5921: 28000000, 0.6015: 29000000, 0.6109: 30000000, 0.6202: 31000000, 0.6296: 32000000,
        0.6390: 33000000, 0.6483: 34000000, 0.6577: 35000000, 0.6671: 36000000, 0.6764: 37000000,
        0.6858: 38000000, 0.6952: 39000000, 0.7046: 40000000, 9999: 1000000000000000000000000000,
    }
    score = round(score, 4)
    print("score:", score)

    key_list = list(loan_score_table.keys())

    if key_list[0] > score:
        return 0

    for idx, key in enumerate(key_list):
        if key <= score < key_list[idx + 1]:
            return loan_score_table[key]

    return 0

class Payment(BaseModel):
    income: float
    private_loan_outstanding_amount: float
    outstanding_amount: float

@loan_receiver.post("/check")
def calculate_score(request: Payment):

    income = request.income
    private_loan_outstanding_amount = request.private_loan_outstanding_amount
    outstanding_amount = request.outstanding_amount

    income_weight = 0.5
    private_loan_outstanding_amount_weight = -3.0
    outstanding_amount_weight = -1.4

    available_income = income - 19320000 - outstanding_amount - (income * 0.3)

    if available_income < 0:
        return -1

    income_log = np.log10(available_income) * income_weight
    private_loan_outstanding_amount_log = math.log10(private_loan_outstanding_amount + 1)
    private_loan_outstanding_amount_score = \
        private_loan_outstanding_amount_log * private_loan_outstanding_amount_weight

    total_score = income_log + private_loan_outstanding_amount_score - 3.1

    if total_score < 0:
        return -1

    loan_amount = calculate_loan(total_score)

    return loan_amount


