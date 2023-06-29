import smtplib
import os.path

from fastapi import APIRouter

import pickle

from email.mime.multipart import MIMEMultipart
from email.mime.image import MIMEImage
from email.mime.audio import MIMEAudio
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

# 우리가 백엔드에 뭔가를 요청하면 응답으로 돌아오는건? Html
# mime: 못들음ㅋ

email_notification_router = APIRouter()
# 주피터에서는 이거 지워야 함 있으면 오류

NAVER_USER_DATA_SAVED_FILE = "naver/account"


# 주피터로 run 하면 naver 폴더에 account 파일이 생김

# 이메일 제대로 전송하는지 prepare
@email_notification_router.get("/email-notification-prepare")
async def email_notification_prepare():
    print(("Prepare to send email!"))

    f = open(NAVER_USER_DATA_SAVED_FILE, 'rb') # 파일을 오픈했으면
    # rb: byte 형식으로 읽기
    naver_user_info = pickle.load(f)
    # pickle.load()
    # 한 줄씩 파일을 읽어옴
    f.close() # 꼭 닫아주어야 한다
    # why?
    # 한번 파일을 열면 컴퓨터는 리소스를 사용하는데 그 사용을 중지해야 한다
    # 또한 오픈한 파일을 닫지 않으면 데이터가 날라갈 수 있는 위험이 있다

    print(naver_user_info['smtp_user_id'])
    # 결과
    # Prepare to send email!
    # wlsdbwls321@naver.com
    # 터미널에 뜨고 서버에서는 null이라고 뜸 - 통신 잘 된 것


# 이메일 전송하는 메서드
# SMTP 서버, 포트 객체 생성하고
# 서버의 포트에 연결하고
# 로그인 해주고
# 이메일 전송
def send_email(smtp_info, naver_user_info, msg):
    with smtplib.SMTP(smtp_info['smtp_server'], smtp_info['smtp_port']) as server:
        # 파이썬에서 이메일을 보내기 위해서는 내장 모듈인 smtplib을 사용 (import 필요)
        # Simple Mail Transfer Protocol
        # SMTP 서버에 접속하기 위해 smtp 서버와 포트로 SMTP 객체 생성

        server.starttls()
        # SMTP 서버의 포트 587에 암호화된 연결을 할 때 starttls()를 호출해주어야 함

        server.login(naver_user_info['smtp_user_id'], naver_user_info['smtp_user_pw'])
        # 연결 후 로그인 해주기

        print(msg.as_string())
        res = server.sendmail(msg["from"], msg["to"], msg.as_string())

        if not res:
            print("이메일 전송 성공!")
        else:
            print(res)


def make_multipart(msg_dict):
    multi = MIMEMultipart(_subtype='mixed')

    for key, value in msg_dict.items():
        if key == 'image':
            with open(value['filename'], 'rb') as fp: # with를 사용하면 f.close()를 매번 사용해주지 않아도 됨
                msg = MIMEImage(fp.read(), _subtype=value['subtype'])

        msg.add_header("Content-Disposition", 'attachment',
                       filename=os.path.basename(value['filename']))

        multi.attach(msg)

    return multi


@email_notification_router.get("/email-notification")
async def email_notification():
    print("send email to id owner!")

    f = open(NAVER_USER_DATA_SAVED_FILE, 'rb')
    naver_user_info = pickle.load(f)
    f.close()

    smtp_info = dict({
        # 딕셔너리 만들기
        # 딕셔너리: 연관된 값을 묶어서 저장하는 용도
        "smtp_server": "smtp.naver.com",
        "smtp_port": 587
    })

    msg_dict = {
        'image': {
            'maintype': 'image',
            'subtype': 'jpg',
        }
    }

    title = '가즈아!'
    content = '간드아'
    sender = naver_user_info['smtp_user_id']
    reciever = naver_user_info['smtp_user_id']

    msg = MIMEText(_text=content, _charset='utf-8')
    msg_dict['image']['filename'] = 'image/voice_phishing.jpg' # 글자만 보낼 땐 이부분 필요없음

    multi = make_multipart(msg_dict)

    multi['Subset'] = title
    multi['From'] = sender
    multi['To'] = reciever
    multi.attach(msg)

    send_email(smtp_info, naver_user_info, multi)

    return "email 전송 완료"

# 이런건 어디에 써먹어?
# 상품 구매한 고객에게 '상품 구매 완료되었습니다'
# 이런거 줄 때 써먹을 수 있음
# 사진 같은거 추가 해서 보내줄 수 있는데 이미지 생성이 필요한 부분이라
# 지금은 사실상 글자만 보내면 됨

