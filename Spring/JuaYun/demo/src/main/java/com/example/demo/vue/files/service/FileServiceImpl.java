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
                String originalFileName = multipartFile.getOriginalFilename();

                FileOutputStream writer = new FileOutputStream(
                        "../../../Vue/JuaYun/frontend/src/assets/uploadImgs/" +
                                multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();

                FileTest fileTest = info.toFileTest(originalFileName);

                filesTestRepository.save(fileTest);
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
        List<FileTest> fileTestList = filesTestRepository.findAll();

        List<ImagePathResponseForm> imagePathResponseFormList = new ArrayList<>();

        for (FileTest fileTest: fileTestList) {
            imagePathResponseFormList.add(new ImagePathResponseForm(fileTest.getImagePath()));
        }
        return imagePathResponseFormList;
    }
}
