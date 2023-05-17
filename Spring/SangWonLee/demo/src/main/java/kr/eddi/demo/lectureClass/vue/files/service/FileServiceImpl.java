package kr.eddi.demo.lectureClass.vue.files.service;

import kr.eddi.demo.lectureClass.vue.files.controller.form.FileInfoRequestForm;
import kr.eddi.demo.lectureClass.vue.files.controller.form.ImagePathResponseForm;
import kr.eddi.demo.lectureClass.vue.files.entity.FileTest;
import kr.eddi.demo.lectureClass.vue.files.repository.FilesTestRepository;
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
public class FileServiceImpl implements FileService {

    final private FilesTestRepository filesTestRepository;

    @Override
    public Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info) {

        try {
            for (MultipartFile multipartFile: fileList) {
                // filsList를 for문 돌린다.
                String originalFileName = multipartFile.getOriginalFilename();
                log.info("requestFileName: " + originalFileName);
                // MultipartFile은 스프링에서 제공하는 인터페이스로 업로드한 파일을 쉽게 다룰 수 있게 해준다.
                // getOriginalFilename() 으로 원본 파일 이름을 반환 후, log.info 로 출력한다.


                // src를 기준으로 나와야 하기 때문에 3칸 올라가야함
                // 어차피 나중에 AWS S3로 바꿔야 합니다.
                // 현재 이 기법은 꼼수
                FileOutputStream writer = new FileOutputStream(
                        "../../../Vue/SangWonLee/frontend/src/assets/uploadImgs/" +
                                multipartFile.getOriginalFilename()
                ); // 이 경로에 파일을 생성한다. 이름은 원본 이름으로

                writer.write(multipartFile.getBytes());
                // 이게 없으면 multipartFile 객체 내용이 파일에 저장이 되지 않는다.
                // (파일은 생성되지만 이미지를 열 수 없음(안이 비었기 때문))
                // 따라서 객체의 내용을 파일에 저장하려면 반드시 write 메소드를 호출하여 데이터를 써줘야 한다.

                writer.close(); // 꼭 close를 해줘야 된다.
                // 안 그러면 파일에 대한 접근이 계속 유지되어서 다른 프로세스에서 파일에 접근 할 수 없게 된다.

                FileTest fileTest = info.toFileTest(originalFileName);
                // 위에 FileInfoRequestForm info 인자를 가져옴.
                // price와 productName은 info 객체의 멤버 변수로 저장되어 있으므로,
                // toFileTest에서 price와 productName을 직접 참조하여 FileTest 객체를 생성할 수 있다.
                // 이렇게하면 originalFileName만 인자로 전달해도 price와 productName이 제대로 저장됨

                filesTestRepository.save(fileTest);
                // save 메소드를 호출하여 fileTest를 저장한다.
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
        // filesTestRepository 객체의 findAll 메소드를 호출시켜서
        // 데이터베이스 테이블에서 모든 엔티티를 가져옴

        List<ImagePathResponseForm> imagePathResponseFormList = new ArrayList<>();

        for (FileTest fileTest: fileTestList) { // fileTestList를 반복한다.
            imagePathResponseFormList.add(
                    new ImagePathResponseForm(fileTest.getImagePath()));
            // FileTest 객체의 getImagePath 메소드를 사용해서 ImagePathResponseForm 객체를 생성하고,
            // imagePathResponseFormList에 추가한다.
        }
        // 그리고 그 List를 반환
        return imagePathResponseFormList;
    }
}