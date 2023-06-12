import math
import numpy as np
def calculate_score(income, outstanding_amount, delinquency_rate):
    income_weight = 0.4
    outstanding_amount_weight = -0.3
    delinquency_rate_weight = -0.3

    income_log = np.log10(income)
    #추후 미상환 건 수를 고려할 때
    outstanding_amount_log = np.log10(outstanding_amount+1)

    income_score = income_log * income_weight
    outstanding_amount_score = outstanding_amount_log * outstanding_amount_weight
    delinquency_rate_score = outstanding_amount_log * delinquency_rate * delinquency_rate_weight

    final_score = income_score+ outstanding_amount_score+delinquency_rate_score
    return final_score

sample_number = 10
income = np.random.randint(30000000, 40000000, size=sample_number)
print("income: {0}".format(income))
outstanding_amount = np.random.randint(0, 1000000000, size=sample_number)
print("outstanding_amount: {0}".format(outstanding_amount))
delinquency_rates = np.random.uniform(0.0, 0.3, size=sample_number)
print("delinquency_rates: {0}".format(delinquency_rates))

final_score = calculate_score(income,outstanding_amount,delinquency_rates)
print("final_score: {0}".format(final_score))