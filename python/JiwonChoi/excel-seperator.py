# 너무 많은 액셀 내용 분리하기
import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0] #.shape[0] 행 개수, .shape[1] 열 개수
separate_range = 5000
# print(total_rows)
# 155746


for i in range(0, total_rows, separate_range): #0~total_rows, separate_range씩 건너뛰며
    print("start loop:", i)
    chunk = df[i:i+separate_range]
    chunk.to_excel(f'chunk_{i+1}-{i+len(chunk)}.xlsx', index=False)
    print("end loop:", i)