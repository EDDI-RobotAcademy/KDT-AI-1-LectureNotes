package kr.eddi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// 에러나면 cmd 켜서 netstat -ano 입력 후 8080 포트의 PID를 찾아 작업 종료 (작업관리자 - 세부정보)
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
