import pandas as pd
import matplotlib

온라인_햇살론_고객정보 = pd.read_excel('온라인햇살론_분석정보.xlsx')

print(온라인_햇살론_고객정보.head(10))

columns_to_keep = ['PRE_LMT', 'PRE_RT', 'GOODS_CD', 'RRC_CD', 'HAC_CD', 'LU0024101', 'LU0024201',
                   'LS0000180', 'CL0631905', 'CL0631906', 'L2A000105', 'L00080002',
                   'LA6000005', 'L22001800', 'L22002000', 'SALE_TRM',
                   'LC0099024', 'LA1200018']

print(온라인_햇살론_고객정보.value_counts())

온라인_햇살론_고객정보.value_counts().plot(kind='bar')
