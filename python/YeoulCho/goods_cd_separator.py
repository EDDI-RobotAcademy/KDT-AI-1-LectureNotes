import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]

# filtered_df = df[df['GOODS_CD'].astype(str) == '760036']
# filtered_df.to_excel('IBK사잇돌2.xlsx')

goods_code = ['760036', '760054', '760143', '760010', '']
goods_name = ['IBK사잇돌2', '햇살론-근로자(원금균등-12개월 상환)', '온라인햇살론', '',]

# for i in range():
# filtered_df = df[df['GOODS_CD'].astype(str) == '760036']
# filtered_df.to_excel('IBK사잇돌2.xlsx')