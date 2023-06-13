# 너무 많은 액셀 내용을 분리하기 위한 코드
# customer_data.xlsx에 너무 많은 내용이 들어가 있기 때문에
# just open만 하려는데도 시간이 오래 걸림
# 나눠서 열면 더 빨리 잘 열릴 것

import pandas as pd
# pandas: 파이썬 데이터 처리를 위한 라이브러리
# 파이썬을 이용한 데이터 분석과 같은 작업에서 필수래

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]
# shape[0]은 행의 개수
# shape[1]은 열의 개수
# 즉 customer_data의 행의 개수를 total_rows에 넣어라
# 엑셀 파일의 정보가 얼마나 있는지 알 수 있음
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

# python excel-seperator.py 명령어로 실행시키면
# 일단 customer_data.xlsx 파일 자체에 정보량이 너무 많아서 시간이 좀 걸림
# 그러다 점차 start, end 로 파일이 생성되는 것을 볼 수 있음
# 그리고 만들어진 chunk 폴더들은 직접 들어가서 가져와도 되겠다

# gitignore에 chunk*.xlsx 추가
# 이렇게 하면 chunk라는 이름 뒤에 *에 무엇이 들어가던 ignore되는구나
