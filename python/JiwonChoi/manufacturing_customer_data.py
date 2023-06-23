import pandas as pd

df = pd.read_excel('chunk_155001-155746.xlsx')

total_rows = df.shape[0]

print("total_rows:", total_rows)
print(df)