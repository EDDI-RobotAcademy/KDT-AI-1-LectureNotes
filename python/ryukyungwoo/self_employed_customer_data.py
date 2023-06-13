import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]

filtered_df = df[df['HAC_CD'].astype(str) == 2]
filtered_df.to_excel('self_employed_data.xlsx')