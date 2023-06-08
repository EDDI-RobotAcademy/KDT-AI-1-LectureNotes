# 개인 사업자 정보 추출
# 분석이 필요하다 판단하는 사항들(1)
# 연금 소득자 [HAC_CD가 3인 경우]의 경우 정말 대출이 낮은가 ?
# -> 연금 소득자만 필터링해서 살펴볼 필요성이 존재함
# ==> 오히려 HAC_CD가 2인 경우를 살펴봤는데
#     미상환이 존재하기 때문에 대출 금액이 낮아진 것을 확인 할 수 있음

import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]

# 필터링 - 필요한 정보만 추출
# filtered_df = df[df['HAC_CD'] == 2] # 이건 오류였음
# data를 못 찾아오니 데이터 타입을 변환시켜줌 -> 그랬더니 찾아옴 (pandas 활용에서의 오류 같음)
filtered_df = df[df['HAC_CD'].to_string(2)] # 개인 사업자는 2번
# astype(str)
# pandas에서 데이터를 문자열로 반환하는 법

# 그렇다면 astype(str)과 to_string의 차이는 몰까?
# astype은 데이터타입, Dataframe 자체를 문자열로 바꿔줄 수 있고
# to_string은 데이터 객체를 단순히 문자열 형태로 바꿔주는 거라는데
# 몬 말인지 아직 잘 모르겠음;;

filtered_df.to_excel('self_employed_data.xlsx') # 개인 사업자 데이터만 모아서 엑셀로 생성해라

# print(df['HAC_CD'])
print(filtered_df)
