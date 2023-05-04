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
                String originalFileName = multipartFile.getOriginalFilename();
                log.info("requestFileName: " + originalFileName);

                // src를 기준으로 나와야 하기 때문에 3칸 올라가야함
                // 어차피 나중에 AWS S3로 바꿔야 합니다.
                // 현재 이 기법은 꼼수
                FileOutputStream writer = new FileOutputStream(
                        "../../../Vue/Jinyujin/frontend/src/assets/uploadImgs/" +
                                multipartFile.getOriginalFilename()
                );

                writer.write(multipartFile.getBytes());
                writer.close();

                FileTest fileTest = info.toFileTest(originalFileName);

                fileTestRepository.save(fileTest);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<ImagePathResponseForm> imageList() {
        List<FileTest> fileTestList = fileTestRepository.findAll();

        List<ImagePathResponseForm> imagePathResponseFormList = new ArrayList<>();

        for (FileTest fileTest: fileTestList) {
            imagePathResponseFormList.add(
                    new ImagePathResponseForm(fileTest.getImagePath()));
        }

        return imagePathResponseFormList;
    }

    // try catch라는 것 처음 배울
    // FileOutPutStream 경로 잘 설정해줘야 함
    // vue는 두 칸 올라가야 있는 것
    // 놉 src를 기준으로 나와야 하기 때문에 3칸 올라가야함

    // 리스트도 폼 하나 생성해줘야 함 위에가 리퀘스트 였다면
    // 리스트는 리스폰스폼

}
