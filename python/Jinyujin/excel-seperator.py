import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]
separate_range = 5000

for i in range(0, total_rows, separate_range):
    print("start loop:", i) # 잘 되는지 확인용 출력
    chunk = df[i:i+separate_range]
    chunk.to_excel(f'chunk_{i+1}-{i+len(chunk)}.xlsx', index=False)
    print("end loop:", i)

# 여기는 사고 발생할 수 있기 때문에 보안 철저히!
# 여차하면 사이버 수사대 신고 들어감

# python --version: 파이썬 버전확인
# python excel-seperator.py
# python file.py: file이라는 이름의 파이썬 파일 실행하는 명령어