import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]
seperate_range = 5000


for i in range(0, total_rows, seperate_range):
    chunk = df[i:i+seperate_range]
    chunk.to_excel(f'chunk_{i+1}-{i+len(chunk)}.xlsx', index=False)