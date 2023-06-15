import math
import random

import numpy as np


def calculate_score(income, outstanding_amount, delinquency_rate):
    income_weight = 0.4
    outstanding_amount_weight = -0.3
    delinquency_rate_weight = -0.3

    income_log = math.log10(income)
    outstanding_amount_log = math.log10(outstanding_amount + 1)

    income_score = income_log * income_weight
    outstanding_amount_score = outstanding_amount_log * outstanding_amount_weight
    delinquency_rate_score = outstanding_amount_log * delinquency_rate * delinquency_rate_weight

    final_score = income_score + outstanding_amount_score + delinquency_rate_score

    return  final_score

sample_number = 10
for _ in range(sample_number):
    income = random.randint(30000000, 40000001, size=sample_number)
    outstanding_amount = random.randint(0, 10, size=sample_number)
    delinquency_rate = np.random.uniform(0.0, 0.3, size=sample_number)

    final_score = calculate_score(income, outstanding_amount, delinquency_rates)
    print("i: {0}", final_score)

