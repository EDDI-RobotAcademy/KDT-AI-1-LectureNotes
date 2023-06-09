import pandas as pd

df = pd.read_excel('customer_data.xlsx')

# total_rows = df.shape[0]

# filtered_df = df[df['GOODS_CD'].astype(str) == '760036']
# filtered_df.to_excel('IBK사잇돌2.xlsx')

# 반복적인 패턴 스마트하게 바꾸기
goods_code = ['760036', '760054', '760143', '760010', '760125', '760142']
# unique 함수를 이용해 어떤 종류들이 있는지 구하고 그걸 추가함
goods_name = ['IBK사잇돌2', '햇살론-근로자(원금균등-12개월변동금리)', '온라인햇살론',
              '참좋은사업자대출', 'SBI저축은행스피드론', '참좋은론ipass론']
# 시너지 론(760044)의 경우 대출 한도 및 자세한 약정 파악이 불가하므로 폐기처분

print(len(goods_code))
print(range(len(goods_name)))
# goods_name 리스트의 길이만큼 범위를 둔다
# -> print(range(6))과 마찬가지임
# 여기서 range() 함수를 쓴 큰 이유는 없는 것 같음
# 보통 for문 돌릴 때 범위 구하려고 쓰는 듯

for i in range(len(goods_code)):
    filtered_df = df[df['GOODS_CD'].astype(str) == goods_code[i]]
    filtered_df.to_excel(goods_name[i] + '.xlsx')
    # 이렇게하면 GOODS_CD에 맞춰서 필요한 이름들 다 뽑아낼 수 있을 것