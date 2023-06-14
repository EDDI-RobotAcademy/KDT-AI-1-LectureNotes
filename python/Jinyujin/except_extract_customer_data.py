import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]

# ~ 표시를 통해 NOT 연산이 가능함
# filtered_df = df[~df['GOODS_CD'].isin(['760036', '760054', '760143', '760010'])]
# filtered_df.to_excel('except_extract_data.xlsx')
# 요거 너무 오래걸려서 죽이심

unique_goods_values = df['GOODS_CD'].unique()
# unique: 데이터에 고유값들이 어떠한 종류들이 있는지 알고 싶을 때 사용 (중복을 제외한다는 것)

for value in unique_goods_values:
    print(value)
