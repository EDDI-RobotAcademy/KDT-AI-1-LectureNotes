package com.example.demo.vue.files.service;

import com.example.demo.vue.files.controller.form.FileInfoRequestForm;
import com.example.demo.vue.files.controller.form.ImagePathResponseForm;
import com.example.demo.vue.files.entity.FileTest;
import com.example.demo.vue.files.repository.FilesTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    final private FilesTestRepository filesTestRepository;
    @Override
    public Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info) {

        try {
            for (MultipartFile multipartFile: fileList) {
                // fileList 업로드할 파일 목록
                String originalFileName = multipartFile.getOriginalFilename();
                                          // 업로드할 파일의 원래 이름

                FileOutputStream writer = new FileOutputStream(
                        "../../../Vue/JuaYun/frontend/src/assets/uploadImgs/" +
                                multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                             // 업로드할 파일을 바이트 배열로 읽어옴
                writer.close();

                // FileOutputStream writer = new FileOutputStream(파일경로)
                // 파일 출력 스트림 생성
                // writer.write(파일에 데이터)
                // 파일에 데이터 쓰기
                // writer.close()
                // 파일 출력 스트림 담기

                // 문법처럼 외우면 될듯


                FileTest fileTest = info.toFileTest(originalFileName);
                // 업로드한 파일정보를 db에 저장하기 위해 toFileTest 메소드를 호출하여
                // fileTest 객체를 생성

                filesTestRepository.save(fileTest);
                // 생성된 fileTest 객체를 db에 저장
            }
        } catch (FileNotFoundException e) {
            // FileNotFoundException 은 파일을 찾을 수 없을 때 발생
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // IOException 은 입출력 예외로 파일을 읽거나 쓸 때 발생
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // try-catch 문은 프로그램 실행 도중 발생할 수 있는 오류를 처리하기 위한 것
    // try 문은 오류가 발생할 가능성이 있는 코드 블록을 정의하고
    // catch 문은 try 문에서 오류가 발생할 경우 실행할 코드 블록을 정의한다.
    // e 변수를 사용하여 예외 정보를 출력하거나 예외 처리를 수행할 수 있다.



    @Override
    public List<ImagePathResponseForm> imageList() {
        List<FileTest> fileTestList = filesTestRepository.findAll();

        List<ImagePathResponseForm> imagePathResponseFormList = new ArrayList<>();

        for (FileTest fileTest: fileTestList) {
            imagePathResponseFormList.add(new ImagePathResponseForm(fileTest.getImagePath()));
        }
        // foreach 문을 사용하여 List<FileTest> 에 있는 fileTestList 의 각 FileTest 객체를
        // ImagePathResponseForm 객체로 변환하여 imagePathResponseFormList 에 추가하는 코드

        return imagePathResponseFormList;
    }
}
