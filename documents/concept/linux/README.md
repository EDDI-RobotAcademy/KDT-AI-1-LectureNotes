## 리눅스(Linux)
### 1. 운영체제
* 운영체제는 컴퓨터와 같은 기계장치인 하드웨어와 컴퓨터에 설치되는 모든 소프트웨어를 관리하는 역할을 한다.
* 대표적인 운영체제로는 윈도우즈(Windows), 맥 OS(Mac OS), 리눅스(Linux), 유닉스(Unix)가 있다.
### 2. 리눅스(Linux)
* 리눅스는 1991년 9월 17일 핀란드 헬싱키 대학에서 운영체제를 공부하던 리누스 토발즈에 의해 개발된 유닉스 계열의 운영체제이다.
* 소스 코드가 공개되어 있는 대표적인 오픈 소스 소프트웨어로 많은 참여자가 관여하고 있는 오픈 소스 프로젝트다.
* GNU/Linux를 기반으로 하고 있는 인기있는 배포판은 데비안, 레드햇, 페도라, 우분투, CentOS 등의 리눅스가 있다.
### 3. 리눅스의 구성요소
#### 3.1. 커널(Kernel)
* 리눅스 커널은 리눅스 운영 체제의 핵심이 되는 구성 요소로 쉘로부터 명령을 받아 작업을 수행한다.
#### 3.2. 쉘(Shell)
* 커널과 사용자 사이의 인터페이스로 사용자로부터 명령을 받아 그것을 해석하고 실행하는 역할을 한다.
#### 3.3. 응용프로그램(Application)
* 리눅스 환경에서 사용하는 프로그램을 의미한다. (XWindows, 웹 서버, FTP, DB 등)
### 3. 우분투(Ubuntu) 설치
#### 3.1. 우분투 컨테이너 생성
* Docker를 이용하여 우분투 컨테이너를 생성하는 방법은 아래와 같다.
  ```
  > docker run -it --name ubuntu ubuntu:latest
    Unable to find image 'ubuntu:latest' locally
    ...

    root@5987dbc81156:~#
  ```
#### 3.2. 우분투 버전 확인
* 컨테이너 생성 후 아래의 명령어로 우분투 버전을 확인하다.
  ```
  root@5987dbc81156:~# cat /etc/os-release
    PRETTY_NAME="Ubuntu 22.04.1 LTS"
    ...
  ```
#### 3.3. 컨테이너 종료
* 컨테이너를 종료하려면 `exit` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# exit
    ...
  ```
#### 3.4. 컨테이너 재실행
* PC를 다시 시작하거나 컨테이너 종료 후 컨테이너를 다시 실행하려면 `docker restart` 명령어를 사용한다.
* 컨테이너를 재시작 후 컨테이너의 bash 쉘을 수행하려면 `docker exec` 명령어를 사용한다.
  ```
  > docker restart ubuntu
  ubuntu

  > docker exec -it ubuntu /bin/bash
  root@5987dbc81156:~#
  ``` 
## 시스템 기본 명령어
### 1. 현재 시간과 날짜 확인
* 현재 시간과 날짜를 출력하려면 `date` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# date
  Sun Sep  4 07:26:05 UTC 2022
  ```
* 시스템의 시간대를 `KST`로 변경하기 위해서 `tzdata` 패키지를 설치한다.
  ```
  root@5987dbc81156:~# apt-get install -y tzdata
  ...

  root@5987dbc81156:~# date
  Sun Sep  4 16:25:59 KST 2022
  ```
### 2. 시스템 사용자 정보
* 리눅스는 강력한 네트워크를 지원하는 운영체제로 많은 사용자들이 동시에 접속할 수 있다.
* 현재 시스템을 사용하고 있는 사용자를 조회하려면 `whoami` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# whoami
  root
  ```
### 3. 시스템 정보
* 리눅스 시스템에 대한 정보를 조회하려면 `uname` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# uname
  Linux

  root@5987dbc81156:~# uname -a
  Linux 5987dbc81156 5.10.16.3-microsoft-standard-WSL2 #1 SMP Fri Apr 2 22:23:49 UTC 2021 x86_64 x86_64 x86_64 GNU/Linux
  ```
* 리눅스 시스템의 호스트 네임을 조회하려면 `hostname` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# hostname
  5987dbc81156
  ```
* 리눅스에 설정된 환경 변수를 조회하려면 `env` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# env
  HOSTNAME=5987dbc81156
  PWD=/
  HOME=/root
  ...
  ```
* 문자열을 터미널에 출력하려면 `ehco` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# echo "Hello World"
  Hello World
  ```
* `ehco` 명령어를 사용하여 환경 변수의 내용을 출력할 수 있다.
  ```
  root@5987dbc81156:~# echo $HOME
  /root
  ```
* 명령어의 위치를 확인하려면 `which` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# which ls
  /usr/bin/ls
  ```
* 터미널에서 사용한 명령어의 목록을 조회하려면 `history` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# history
    1  uname
    2  env
    3  echo $HOME
    4  history
  ```
* 현재 접속한 계정을 로그아웃하지 않고 다른 계정으로 변경하려면 `su` 명령어를 사용한다.
* su 명령을 사용할 때 - 옵션을 사용하지 않으면 이전 계정의 쉘 환경 변수를 그대로 사용한다.
  ```
  root@5987dbc81156:~# su - ismoon
  ismoon@5987dbc81156:~$
  ```
## 파일과 디렉터리
### 1. 리눅스 파일
#### 1.1. 일반 파일
* 일반 파일은 데이터를 관리하며 주로 사용되는 일상적인 파일을 의미한다.
#### 1.2. 디렉터리 파일
* 리눅스에서는 디렉터리도 파일로 취급되며 해당 디렉터리에 저장된 파일이나 하위 디렉터리에 대한 정보를 가지고 있다.
#### 1.3. 링크 파일
* 원본 파일에 여러 개의 이름을 붙여 접근할 수 있도록 하는 파일을 의미한다. (Windows의 바로 가기)
#### 1.4. 특수 파일
* 리눅스 시스템에서 키보드, 모니터, 마우스, 디스크 드라이브 등과 같은 컴퓨터의 모든 자원이 특수 파일로 사용되고 다루어진다.
### 2. 리눅스 디렉터리
* 리눅스의 디렉터리는 트리(Tree) 구조로 구성되어 있다.
* 리눅스는 최상위 디렉터리인 루트(root) 디렉터리와 하위 디렉터리들로 구성된다.
### 3. 디렉터리 관련 명령어
#### 3.1. 디렉터리 확인
* 현재 작업 중인 디렉터리를 확인하려면 `pwd` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# pwd
  /
  ```
#### 3.2. 디렉터리 이동
* 현재 디렉터리를 이동하려면 `cd` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# cd ~
  root@5987dbc81156:~# pwd
  /root
  ```
#### 3.3. 디렉터리 내용 확인
* 현재 디렉터리에 있는 파일이나 하위 디렉터리의 목록을 확인하려면 `ls` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# ls
  bin  boot  dev  etc  home  lib  lib32  lib64  libx32  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var
  ```
#### 3.4. 디렉터리 생성
* 새로운 디렉터리를 생성하려면 `mkdir` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# mkdir test
  root@5987dbc81156:~# ls
  test
  ```
#### 3.5. 디렉터리 삭제
* 디렉터리를 삭제하려면 `rmdir` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# rmdir test
  root@5987dbc81156:~# ls
  ```
### 4. 파일 명령어
#### 4.1. 파일 생성
* 내용이 없는 빈 파일을 생성하려면 `touch` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# touch test.txt
  root@5987dbc81156:~# ls
  test.txt
  ```
#### 4.2. 파일 복사
* 파일이나 디렉터리를 복사할 때는 `cp` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# cp test.txt test_copy.txt
  root@5987dbc81156:~# ls
  test.txt  test_copy.txt

  root@5987dbc81156:~# mkdir temp
  root@5987dbc81156:~# cp test.txt temp
  root@5987dbc81156:~# ls temp
  test.txt

  root@5987dbc81156:~# cp test.txt test_copy.txt temp
  root@5987dbc81156:~# ls temp
  test.txt  test_copy.txt

  root@5987dbc81156:~# cp -r temp temp_copy
  root@5987dbc81156:~# ls
  temp  temp_copy
  ```
#### 4.3. 파일 내용 출력
* 텍스트 파일의 내용을 출력하려면 `cat` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# echo "Hello World!" > test.txt
  root@5987dbc81156:~# cat test.txt
  Hello World!
  ```
* 화면 단위로 파일의 내용을 출력하려면 `more` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# more /etc/init.d/hwclock.sh
  ```
* 파일의 마지막 내용부터 출력하려면 `tail` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# tail /etc/init.d/hwclock.sh
  ```
#### 4.4. 파일에서 문자열 검색
* 파일에서 문자열을 검색하려면 `grep` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# grep show /etc/init.d/hwclock.sh
  ```
#### 4.5. 파일 이동
* 파일이나 디렉터리를 다른 디렉터리로 이동시키려면 `mv` 명령어를 사용한다.
  ```
  # 파일 이동
  root@5987dbc81156:~# mv test.txt temp

  # 파일 이름 변경
  root@5987dbc81156:~# mv test.txt test_mv.txt
  ```
#### 4.6. 파일 삭제
* 파일을 삭제하려면 `rm` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# rm test.txt
  ```
#### 4.7. 링크 파일 생성
* 링크 파일을 생성하려면 `ln` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# ln -s test.txt test_sl
  root@5987dbc81156:~# cat test_sl
  Hello World
  ```
### 5. 접근 권한
#### 5.1. 접근 권한
* 리눅스는 여러 사용자가 동시에 접속하여 사용하기 때문에 파일들에 대해 접근 권한을 부여할 수 있다.
* 리눅스 파일에 대한 접근 권한의 종류에는 읽기(r), 쓰기(w), 실행(x) 권한이 있다.
* 접근 권한은 세 문자씩 묶어 한 세트로 구성되며 각 묶음 순서대로 소유자, 소유 그룹, 기타 사용자로 분류된다.
  ```
  root@5987dbc81156:~# ls -l
  -rw-r--r-- 1 root root    6 Sep  8 20:34 test.txt
  ```
#### 5.2. 접근 권한 변경
* 파일에 대한 접근 권한을 변경하려면 `chmod` 명령어를 사용한다. 
  ```
  # 기호를 이용한 권한 변경
  root@5987dbc81156:~# chmod u-w test.txt
  root@5987dbc81156:~# ls -l
  -r--r--r-- 1 root root    6 Sep  8 20:34 test.txt

  root@5987dbc81156:~# chmod g+w test.txt
  root@5987dbc81156:~# ls -l
  -r--rw-r-- 1 root root    6 Sep  8 20:34 test.txt

  # 숫자를 이용한 권한 변경
  root@5987dbc81156:~# chmod 555 test.txt
  root@5987dbc81156:~# ls
  -r-xr-xr-x 1 root root    6 Sep  8 20:34 test.txt
  ```
### 6. 소유권
#### 6.1. 소유자와 소유 그룹
* 리눅스는 여러 사용자가 동시에 접속하여 사용하기 때문에 파일들에 대한 소유권을 부여할 수 있다.
* 리눅스 파일에 대한 소유권은 해당 파일에 소유자와 소유 그룹으로 나누어 부여할 수 있다.
* 리눅스 파일에 대한 소유권은 반드시 관리자 계정으로 접속해서 변경해야 한다.
#### 6.2. 소유자와 소유 그룹 변경
* 리눅스 파일이나 디렉터리의 소유자와 소유 그룹을 변경하려면 `chown` 명령어를 사용한다. 
  ```
  # 파일의 소유자만 변경
  root@5987dbc81156:~# chown ismoon test.txt
  root@5987dbc81156:~# ls -l
  -rw-r--r-- 1 ismoon root 6 Sep 11 13:52 test.txt

  # 파일의 소유자와 소유 그룹을 동시에 변경
  root@5987dbc81156:~# chown ismoon:ismoon test.txt
  root@5987dbc81156:~# ls -l
  -rw-r--r-- 1 ismoon ismoon 6 Sep 11 13:51 test.txt
  ```

* 리눅스 파일이나 디렉터리의 소유 그룹을 변경하려면 `chgrp` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# chgrp ismoon test.txt
  root@5987dbc81156:~# ls -l
  -rw-r--r-- 1 root ismoon 6 Sep 11 13:48 test.txt
  ```
## 계정 관리
### 1. 리눅스 계정
#### 1.1. 관리자 계정
* 관리자 계정은 사용자 계정 생성과 권한 부여 등 리눅스 시스템의 관리를 수행하는 계정이다.
* 관리자 계정은 프롬프트에 맨 끝에 `#`으로 표시된다.
#### 1.2. 사용자 계정
* 리눅스는 여러 사용자가 접속하여 사용하는 시스템으로 사용자들은 사용자 계정을 통해 리눅스에 접속하여 시스템을 사용할 수 있다.
* 사용자 계정은 프롬프트에 맨 끝에 `$`로 표시된다.
#### 1.3. 계정 정보 확인
* 계정에 대한 정보는 `/etc/passwd` 파일에 저장되어 있다.
* `/etc/passwd` 파일의 구성 내용은 앞에서부터 사용자 ID, 암호, UID, GID, 설명, 홈 디렉터리, 로그인 쉘로 구성된다.
  ```
  root@5987dbc81156:~# cat /etc/passwd
  root:x:0:0:root:/root:/bin/bash
  ...
  ismoon:x:1000:1000:,,,:/home/ismoon:/bin/bash
  ```
* 계정에 대한 패스워드는 `/etc/shadow` 파일에 저장되어 있다. (관리자 계정으로만 확인 가능)
  ```
  root@5987dbc81156:~# cat /etc/shadow
  root:$y$j9T$OOGv/PIo4j5CbP3wiWwG20$1bX83pbV32.GEYiWeTQJOXR9kQ.ZwKTZWmzCeQgjbjD:19239:0:99999:7:::
  ...
  ismoon:$y$j9T$hAiR1rVUICEKJl2TyKoF4/$wVttHrkseX/y2T6RLJCjg5jMhqHhstHV7KbQr3rOpW/:19239:0:99999:7:::
  ```
### 2. 계정 관리
#### 2.1. 계정 생성
* 계정을 생성하려면 `adduser` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# adduser ismoon
  ```
#### 2.2. 계정 수정
* 계정 정보를 수정하려면 `usermod` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# usermod -a -G sudo ismoon
  root@5987dbc81156:~# su - ismoon
  ismoon@5987dbc81156:~$ groups
  ismoon sudo
  ```
* 계정의 패스워드를 변경하려면 `passwd` 명령어를 사용한다.
  ```
  # root 계정에서 변경
  root@5987dbc81156:~# passwd ismoon
  New password:
  Retype new password:
  passwd: password updated successfully

  # 사용자 계정에서 변경
  ismoon@5987dbc81156:~$ passwd
  Changing password for ismoon.
  Current password:
  New password:
  Retype new password:
  passwd: password updated successfully
  ```
#### 2.3. 계정 삭제
* 계정을 삭제하려면 `userdel` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# userdel -r ismoon
  root@5987dbc81156:~# cat /etc/passwd
  root:x:0:0:root:/root:/bin/bash
  ...
  ```
## 그룹 관리
### 1. 그룹 생성
* 새로운 그룹을 생성하려면 `groupadd` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# groupadd test_group
  root@5987dbc81156:~# grep test_group /etc/group
  test_group:x:1001:
  ```
### 2. 그룹 삭제
* 그룹을 삭제하려면 `groupdel` 명령어를 사용한다.
  ```
  root@5987dbc81156:~# groupdel test_group
  ```
