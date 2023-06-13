import os.path
import smtplib

from fastapi import APIRouter
import pickle

from email.mime.multipart import MIMEMultipart
from email.mime.image import MIMEImage
from email.mime.audio import MIMEAudio
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

email_notification_router = APIRouter()

NAVER_USER_DATA_SAVED_FILE = "naver/account"


@email_notification_router.get("/email-notification-prepare")
async def email_notification_prepare():
    print("Prepare to send email!")

    f = open(NAVER_USER_DATA_SAVED_FILE, 'rb')
    naver_user_info = pickle.load(f)
    f.close()

    print(naver_user_info['smtp_user_id'])


def send_email(smtp_info, naver_user_info, msg):
    with smtplib.SMTP(smtp_info['smtp_server'], smtp_info['smtp_port']) as server:
        server.starttls()

        server.login(naver_user_info['smtp_user_id'], naver_user_info['smtp_user_pw'])

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
            with open(value['filename'], 'rb') as fp:
                msg = MIMEImage(fp.read(), _subtype=value['subtype'])

        msg.add_header("Content-Disposition", 'attachment',
                       filename=os.path.basename(value['filename']))

        multi.attach(msg)

    return multi


@email_notification_router.get('/email-notification')
async def email_notification():
    print("send email to id owner!")

    f = open(NAVER_USER_DATA_SAVED_FILE, 'rb')
    naver_user_info = pickle.load(f)
    f.close()

    smtp_info = dict({
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
    receiver = naver_user_info['smtp_user_id']

    msg = MIMEText(_text=content, _charset='utf-8')
    msg_dict['image']['filename'] = 'image/voice_phishing.jpg'

    multi = make_multipart(msg_dict)

    multi['Subject'] = title
    multi['From'] = sender
    multi['To'] = receiver
    multi.attach(msg)

    send_email(smtp_info, naver_user_info, multi)

    return "email 전송 완료"