import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]
separate_range = 5000

for i in range(0, total_rows,separate_range):
    print("start loop:", i)
    chunk = df[i:i+separate_range]
    chunk.to_excel(f'chunk_{i+1}-{i+len(chunk)}.xlsx', index=False)
    print("end loop:", i)