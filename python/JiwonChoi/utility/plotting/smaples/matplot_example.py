import pandas as pd
import matplotlib

온라인_햇살론_고객정보 = pd.read_excel('온라인햇살론_분석정보.xlsx')

print(온라인_햇살론_고객정보.head(10))

# 실제 대출한 금액, 신용 점수, 대출 상품, 직위, 직군, 미상환 금액, 미상환 기관 개수
# 사채 미상환 건수, 신용 카드 한도 소진율, 현금 서비스 한도 소진율, 은행업권 제외 미상환 건수
columns_to_keep = []

print(온라인_햇살론_고객정보.value_counts())
온라인_햇살론_고객정보.value_counts().plot(kind='bar')