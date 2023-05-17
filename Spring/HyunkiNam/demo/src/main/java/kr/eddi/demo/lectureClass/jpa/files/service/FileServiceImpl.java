package kr.eddi.demo.lectureClass.jpa.files.service;

import kr.eddi.demo.lectureClass.jpa.files.controller.form.FileInfoRequestForm;
import kr.eddi.demo.lectureClass.jpa.files.controller.form.ImagePathResponseForm;
import kr.eddi.demo.lectureClass.jpa.files.entity.FileTest;
import kr.eddi.demo.lectureClass.jpa.files.repository.FilesTestRepository;
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
    final private FilesTestRepository filesTestRepository;

    @Override
    public Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info){
        try{
            for( MultipartFile multipartFile: fileList){
                String originalFileName = multipartFile.getOriginalFilename();
                log.info("requestFileName: " + originalFileName);

                FileOutputStream writer = new FileOutputStream(
                        "../../../Vue/HyunKiNam/frontend/src/assets/uploadImage/" +
                                multipartFile.getOriginalFilename()
                );

                writer.write(multipartFile.getBytes());
                writer.close();

                FileTest fileTest = info.toFileTest(originalFileName);

                filesTestRepository.save(fileTest);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return false;
        }catch (IOException e){
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
            imagePathResponseFormList.add(
                    new ImagePathResponseForm(fileTest.getImagePath()));
        }

        return imagePathResponseFormList;
    }
}
