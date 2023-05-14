package com.example.demo.lectureClass.vue.files.service;

import com.example.demo.lectureClass.vue.files.controller.form.FileInfoRequestForm;
import com.example.demo.lectureClass.vue.files.controller.form.ImagePathResponseForm;
import com.example.demo.lectureClass.vue.files.entity.FileTest;
import com.example.demo.lectureClass.vue.files.repository.FileTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    final private FileTestRepository fileTestRepository;

    @Override
    public Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info) {

        try {
            for (MultipartFile multipartFile: fileList) {
                // fileList에 담긴 MultipartFile 객체들을 하나씩 꺼내서 multipartFile에 하나씩 담는 것
                String originalFileName = multipartFile.getOriginalFilename();
                // 원래 파일 이미지 이름 설정해주기 위함
                log.info("requestFileName: " + originalFileName);

                // src를 기준으로 나와야 하기 때문에 3칸 올라가야함
                // 어차피 나중에 AWS S3로 바꿔야 합니다.
                // 현재 이 기법은 꼼수
                FileOutputStream writer = new FileOutputStream(
                        "../../../Vue/Jinyujin/frontend/src/assets/uploadImgs/" +
                                multipartFile.getOriginalFilename()
                );
                // FileOutputStream은 무조건 해당 파일을 생성함
                // FileOutPutStream 경로 잘 설정해줘야 함

                writer.write(multipartFile.getBytes()); // FileOutputStream은 바이트 단위로 데이터를 읽어들임
                writer.close(); // 파일을 닫는다

                FileTest fileTest = info.toFileTest(originalFileName);

                fileTestRepository.save(fileTest);
            }
        } catch (FileNotFoundException e) {
            // FileOutputStream 객체 생성 시 파일 경로가 유효하지 않으면 FileNotFoundException 발생
            e.printStackTrace();
            // printStackTrace: 에러를 알려주는 역할을 하는 메서드
            return false;
        } catch (IOException e) {
            // IOException은 파일 입출력 중에 발생하는 예외
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<ImagePathResponseForm> imageList() {
        List<FileTest> fileTestList = fileTestRepository.findAll();
        // FileTest 엔티티 타입을 가진 fileTestList에 디비에 있는 것들을 다 찾아와라

        List<ImagePathResponseForm> imagePathResponseFormList = new ArrayList<>();
        // 응답할 형태의 폼의 타입을 가진 imagePathResponseFormList 선언

        for (FileTest fileTest: fileTestList) {
            // fileTestList에 담긴 FileTest 객체를 fileTest에 넣어줘라
            imagePathResponseFormList.add(
                    new ImagePathResponseForm(fileTest.getImagePath()));
            // imagePath만 넣을라고 리스트로 만들어줌
        }

        return imagePathResponseFormList;
        // imagePath만 담긴 리스트 반환
    }

    // try catch라는 것 처음 배울
    // vue는 두 칸 올라가야 있는 것
    // 놉 src를 기준으로 나와야 하기 때문에 3칸 올라가야함

    // 리스트도 폼 하나 생성해줘야 함 위에가 리퀘스트 였다면
    // 리스트는 리스폰스폼

}
