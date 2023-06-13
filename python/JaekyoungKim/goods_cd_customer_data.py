import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]


goods_code=['760036','760054','760143','760010','760125','760142']
goods_name=['IBK사잇돌2','햇살론-근로자(원금균등-12개월 변동금리)','온라인햇살론','참좋은사업자대출','SBI스피드론','참좋은론iPass론']

#print(len(goods_code))
#print(range(len(goods_code)))

for i in range(len(goods_code)):
    filtered_df = df[df['GOODS_CD'].astype(str) == goods_code[i]]
    filtered_df.to_excel(goods_name[i]+'.xlsx')

# ~ 표시를 통해 NOT 연산이 가능함
#filtered_df = df[~df['GOODS_CD'].isin(['760036','760054','760143','760010','760044','760125','760142'])]
#filtered_df.to_excel('except_extract_data.xlsx')

#unique_goods_values = df['GOODS_CD'].unique()

#for value in unique_goods_values:
#   print(value)
#print(filtered_df)