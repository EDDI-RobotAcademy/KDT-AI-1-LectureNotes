import pandas as pd

일부_고객_대출_정보 = pd.read_excel('chunk_155001-155746.xlsx')

print(일부_고객_대출_정보.head(10))

print("30개 뿌리기")
print(일부_고객_대출_정보.head(30))

total_row_column_info = 일부_고객_대출_정보.shape
print(total_row_column_info)

일부_고객_대출_정보_CL0631905 = 일부_고객_대출_정보['CL0631905'].unique()

for value in 일부_고객_대출_정보_CL0631905:
    print(value)