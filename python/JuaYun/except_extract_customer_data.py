import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]

# ~ 표시를 통해 NOT 연산이 가능함
# filtered_df = df[~df['GOODS_CD'].isin(['760036', '760054', '760143', '760010'])]
# filtered_df.to_excel('except_extract_data.xlsx')

# GOODS_CD 를 유니크한 값으로 뽑아내라
unique_goods_value = df['GOODS_CD'].unique()

for value in unique_goods_value:
    print(value)