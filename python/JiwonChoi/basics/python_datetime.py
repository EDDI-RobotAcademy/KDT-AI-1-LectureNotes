from datetime import date
import datetime as dt
#날자 정보 계산하기

def date_test_function():
    remain_date = date.today()
    changeable_date = date(2023, 5, 26)
    print('changeable_date :',changeable_date)
    print('remain_date :',remain_date)
    print(changeable_date - remain_date)
def datetime_test_function():
    remain_datetime = dt.datetime.today()
    changeable_datetime = dt.datetime(2023, 5, 26, 15, 27, 4, 517207)
    print('changeable_datetime :',changeable_datetime)
    print('remain_datetime :',remain_datetime)
    print(changeable_datetime - remain_datetime)

if __name__ == '__main__':
    date_test_function()
    datetime_test_function()