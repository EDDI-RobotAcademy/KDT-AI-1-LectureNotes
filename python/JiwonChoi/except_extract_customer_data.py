# 비실명화된 고객 대출 상품 데이터 분석
import pandas as pd

df = pd.read_excel('customer_datas/customer_data.xlsx')
total_rows = df.shape[0]

# ~ 표시를 통해 NOT 연산이 가능함
#filtered_df = df[~df['GOODS_CD'].isin(['760036', '760054', '760143', '760010'])]
# DF.isin([values]) DF의 요소가 values와 일치하는지 bool형식으로 반환
# ~DF.isin([values])values가 포함되지 않으면..
#filtered_df.to_excel('except_extract_data.xlsx')

unique_goods_values = df['GOODS_CD'].unique() #'GOODS_CD' 열의 고유값들

for value in unique_goods_values:
    print(value)
