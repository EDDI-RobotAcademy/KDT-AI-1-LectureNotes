import pandas as pd

df = pd.read_excel('customer_data.xlsx')  # 엑셀 파일을 pandas DataFrame으로 읽는다.

total_rows = df.shape[0]  # 전체 행 수
separate_range = 5000  # 나누는 거리

print(total_rows)  # 155746개

chunk = df[0: 1000]
chunk.to_excel(f'chunk_{1}-{len(chunk)}.xlsx', index=True)  # 이렇게 하면 인덱스까지 저장됨

for i in range(0, total_rows, separate_range):  # 0부터 separate_range만큼 total_rows까지
    print("start loop : ", i)
    chunk = df[i: i + separate_range]  # i와 i+separate_range 사이의 행을 저장
    chunk.to_excel(f'chunk_{i + 1}-{i + len(chunk)}.xlsx', index=False)
    # f-string 문자열 형식이다. ex) chunk_1, chunk_5001 이 됨
    # {i + len(chunk)} 함으로써 마지막 행 번호를 체크할 수 있음
    print("end loop : ", i)

# 실행은 python excel-seperator.py 을 터미널에 치면댐
