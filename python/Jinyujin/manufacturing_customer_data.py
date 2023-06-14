# 분리된 엑셀 파일 읽기

import pandas as pd

df = pd.read_excel('chunk_155001-155746.xlsx')

total_rows = df.shape[0]

print("total_rows:", total_rows)
print(df)

# 똑같이 python file.py 명령어로 실행시켜주면 됨
