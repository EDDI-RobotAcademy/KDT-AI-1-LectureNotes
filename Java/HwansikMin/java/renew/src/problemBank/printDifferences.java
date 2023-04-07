package problemBank;

public class printDifferences {
    public static void main(String[] args) {
        int number = 1234;
        String str = "안녕, 자바";

// 프로그래밍을 해도 결과를 볼 수 있는 명령문을 실행하지 않으면 확인할 수 없다.
// println은 자바에서 기본 출력문으로 널리 사용되며, 출력하고자 하는 내용을 입력하여 출력한다.
// System.out.println("문자열");
// System.out.println(변수명);
// System.out.println("문자열"+변수명);
// 이런 방식으로 출력하는데 문자열을 출력하려면 큰따옴표로 써줘야한다.
// 큰따옴표가 붙어있지 않으면 모두 변수명으로 인식하며, 입력한 변수명이 없다면 애러가 발생한다.
// 문자열과 변수명을 함께 사용하려면 반드시 "+" 로 연결시켜야한다.
// println은 괄호 안의 내용을 출력한 후에 자동으로 줄을 바꿔주는 기능이 있다.
// tip!> 이클립스는 sysout를 입력하고 ctrl+space를 누르면 system.out.println()이 입력된다.

        System.out.println(str + number);
        System.out.print("print ! " + number);
        System.out.printf("printf ! " + number);
        System.out.println("println ! " + number);
        System.out.printf("printf ! " + number);
        System.out.print("print ! " + number);

// println()은 변수의 값을 그대로 출력한다.
// println()은 값을 변환하지 않고서는 다른형식으로 출력이 불가능하다.
// 반면 printf()는 지시자를 통해 변수의 값을 여러가지 형식으로 변환하여 출력이 가능하다.

// System.out.printf("출력 서식",출력할 내용);
// 1. 출력 후 줄바꿈을 하지 않아, 줄바꿈을 하려면 지시자 '%n'을 넣어줘야한다.
// 2. 출력하는 값의 수만큼 지시자를 사용해야한다.
// 3. 출력될 값과 지시자의 순서는 일치해야한다.
// 4. 지시자를 제외한 문자는 입력한 그대로 출력된다.

// 출력 서식 : %[-][0][n][.m]지시자
// 출력 서식의 지시자를 제외한 나머지는 생략 가능하다. 예) %d 식으로 사용 가능.
// n : 출력할 전체 자리수 지정(오른쪽 정렬). 예) %3d, 전체자리수가 3인 정수
// 0 : 전체 자리수가 지정된 경우 왼쪽의 남는 자리에 0을 출력.  예) %03d
// - : 전체 자리수가 지정된 경우 왼쪽 정렬하고 빈칸에 공백 출력.
// .m : 소수점 아래 자리수 지정. 잘리는 소수점 자리수는 반올림 시켜서 표시.  예)3.2f

// 지시자
// %b : boolean 형식으로 출력
// %d : 정수 형식으로 출력
// %o : 8진수 정수의 형식으로 출력
// %x 또는 %X : 16진수 정수의 형식으로 출력
// %f : 소수점 형식으로 출력
// %c : 문자형식으로 출력
// %s : 문자열 형식으로 출력
// %n : 줄바꿈 기능
// %e 또는 %E : 지수 표현식의 형식으로 출력

        int age = 30;
        String address = "서울";

        //'%n'지시자를 사용 안 했을 경우
        System.out.printf("줄바꿈 기능");
        System.out.printf("없음.");

        //'%n'지시자를 사용한 경우
        System.out.printf("줄바꾸기%n");
        System.out.printf("성공!%n");

        System.out.printf("내 나이는 %d살 입니다.%n",age);
        System.out.printf("내 나이는 %d살 이고 %s에 살고 있습니다.%n",age,address);



        System.out.printf("자리수 미지정 :%d%n",1);
        System.out.printf("자리수 미지정 :%d%n",10);
        System.out.printf("자리수 미지정 :%d%n",100);
        System.out.printf("자리수 미지정 :%d%n",1000);

        //자리수 지정했을 경우  오른쪽으로 정렬된다.(남는 자리수는 공백)
        System.out.printf("자리수 지정 :%4d%n",1);
        System.out.printf("자리수 지정 :%4d%n",10);
        System.out.printf("자리수 지정 :%4d%n",100);
        System.out.printf("자리수 지정 :%4d%n",1000);

        //자리수 지정 후 '-'사용하면 왼쪽으로 정렬된다.
        System.out.printf("자리수 지정('-'사용) :%-4d%n",1);
        System.out.printf("자리수 지정('-'사용) :%-4d%n",10);
        System.out.printf("자리수 지정('-'사용) :%-4d%n",100);
        System.out.printf("자리수 지정('-'사용) :%-4d%n",1000);

        //자리수 지정 후 '0'사용하면 오른쪽으로 정렬된다. (왼쪽 자리수는 0으로 채운다)
        System.out.printf("자리수 지정('0'사용) :%04d%n",1);
        System.out.printf("자리수 지정('0'사용) :%04d%n",10);
        System.out.printf("자리수 지정('0'사용) :%04d%n",100);
        System.out.printf("자리수 지정('0'사용) :%04d%n",1000);



        float f = 1.2345f;

        //소수점 자리수 미지정시
        System.out.printf("소수점 자리수 미지정 : %f%n",f);
        //소수점 자리 지정시
        System.out.printf("소수점 자리수 지정 : %.3f%n",f);

    }
}

// system.out.println
// print와 동일하게 형식(int, float, double 등)에 구애받지 않는 문자를
// 그대로 출력하고 싶을 때 사용한다.
// 차이점은 엔터 입력시 버퍼(buffer)에 \n(개행문자)가 같이 들어간다.
// (엔터 누르는 순간 엔터도 입력된걸로 간주)

// system.out.printf
// print 와 println과 달리 형식을 신경써야할 때 사용(int, long, float, double 등)
// 엔터 입력시 버퍼(buffer)에 \n(개행문자)는 포함 안됨.

//system.out.print
// 형식(int, float, double 등)에 구애받지 않는 문자를 그대로 출력하고 싶을 때 사용한다.
// 엔터 입력시 버퍼(buffer)에 \n(개행문자)는 포함 안됨.(엔터 누르는 순간 엔터는 입력 안됨)
// 그래서 줄바꿈 필요 없을 때 println말고 print를 사용하면 된다.

