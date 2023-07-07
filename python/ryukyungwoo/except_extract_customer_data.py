import pandas as pd

df = pd.read_excel('customer_data.xlsx')

total_rows = df.shape[0]
#
# filtered_df = df[~df['GOODS_CD'].isin(['760036', '760054', '760143', '760010'])]
# filtered_df.to_excel('except_extract_data.xlsx')

unique_goods_values = df['GOODS_CD'].unique()

for value in unique_goods_values:
    print(value)