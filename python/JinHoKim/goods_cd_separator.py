import pandas as pd

df = pd.read_excel('customer_data.xlsx')

#total_rows = df.shape[0]
#filtered_df = df[df['GOODS_CD'].astype(str) == '760036']
#filtered_df.to_excel('IBK사잇돌2.xlsx')

# 시너지 론(760044)의 경우 대출 한도 및 자세한 약정 파악이 불가하므로 폐기처분
goods_code = ['760036', '760054', '760143', '760010', '760125', '760142']
goods_name = ['IBK사잇돌2', '햇살론-근로자(원금균등-12개월변동금리)', '온라인햇살론',
              '참좋은사업자대출', 'SBI저축은행스피드론', '참좋은론iPass론']

print(len(goods_code))
print(range(len(goods_code)))

for i in range(len(goods_code)):
    filtered_df = df[df['GOODS_CD'].astype(str) == goods_code[i]]
    filtered_df.to_excel(goods_name[i] + '.xlsx')

