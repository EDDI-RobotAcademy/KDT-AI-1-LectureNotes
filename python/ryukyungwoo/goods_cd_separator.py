import pandas as pd

df = pd.read_excel('customer_data.xlsx')

goods_code = ['760143', '760054', '760010', '760036', '760125', '760142']
goods_name = ['IBK사잇돌2', '햇살론-근로자', '온라인햇살론',
              '참좋은사업자대출', 'SBI저축은행스피드론', '참좋은론iPass론']

for i in range(len(goods_code)):
    filtered_df = df[df['GOODS_CD'].astype(str) == goods_code[i]]
    filtered_df.to_excel(goods_name[i] + '.xlsx')