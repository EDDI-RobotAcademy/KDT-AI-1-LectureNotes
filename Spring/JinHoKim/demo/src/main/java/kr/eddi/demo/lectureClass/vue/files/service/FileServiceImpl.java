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
public class FileServiceImpl implements FileService{

    final private FilesTestRepository filesTestRepository;

    @Override
    public Boolean register(List<MultipartFile> fileList, FileInfoRequestForm info) {
        //MultipartFile 은 Spring Framework 에서 제공하는 인터페이스로, HTTP 요청의 멀티파트 파일 데이터를 나타냅니다.
        // 이 인터페이스를 사용하면 파일 업로드 기능을 쉽게 구현할 수 있습니다.


        //try-catch 는 예외 처리에 사용되는 구문으로, 예외가 발생하는 코드 블록을 try 블록에 작성하고,
        // 예외가 발생했을 때 처리할 코드를 catch 블록에 작성합니다.
        try {
            for (MultipartFile multipartFile : fileList) {
                String originalFileName = multipartFile.getOriginalFilename();
                // getOriginalFilename() 메소드는 MultipartFile 인터페이스의 메소드 중 하나로,
                // 클라이언트가 업로드한 파일의 원래 이름을 문자열로 반환합니다
                log.info("requestFileName: " + originalFileName);

                FileOutputStream writer = new FileOutputStream(
                        "../../../Vue/JinHoKim/frontend/src/assets/uploadImgs/" +
                                multipartFile.getOriginalFilename()
                        //FileOutputStream 클래스는 자바에서 파일을 생성하거나 파일에 데이터를 기록하는 클래스입니다
                        // FileOutputStream 은 바이트 기반 스트림 클래스이며, 파일에 데이터를 쓸 수 있도록 해줍니다.
                );

                writer.write(multipartFile.getBytes());
                // FileOutputStream 클래스는 파일에 데이터를 기록하는 작업을 수행할 수 있는 write() 메소드를 제공합니다.
                // 이 메소드는 다양한 형태의 매개변수를 받아 파일에 데이터를 기록할 수 있습니다.
                // multipartFile.getBytes() 는 MultipartFile 객체에서 데이터를 byte 배열로 읽어오는 메소드입니다.
                // 이 메소드를 호출하면, MultipartFile 객체에서 읽어온 데이터를 메모리에 byte 배열로 저장합니다.

                // write(multipartFile.getBytes())는 MultipartFile 객체에서 읽어온 데이터를
                // FileOutputStream 을 이용하여 파일에 쓰는 작업을 수행하는 코드입니다.
                // multipartFile.getBytes() 메소드를 호출하여 MultipartFile 객체에서 데이터를 byte 배열로 읽어온 후,
                // 이를 write() 메소드를 사용하여 FileOutputStream 에 쓰게 됩니다

                writer.close();
                // writer.close() 메소드는 Writer 객체를 닫아서 사용하던 자원을 해제하는 역할을 합니다.
                // Writer 객체는 파일이나 네트워크 등의 출력 대상에 데이터를 쓰기 위한 스트림으로,
                // close() 메소드를 호출하지 않고 그대로 둘 경우, 자원 누수로 인해 메모리 누수 등의 문제가 발생할 수 있습니다

                FileTest fileTest = info.toFileTest(originalFileName);

                filesTestRepository.save(fileTest);

            }
            //FileNotFoundException 은 파일을 찾을 수 없을 때 발생하는 예외입니다.
            // 이 예외는 파일을 읽거나 쓰는 작업을 수행할 때, 해당 파일이 존재하지 않는 경우에 발생합니다.
        } catch (FileNotFoundException e) {
            // FileNotFoundException 은 파일을 찾을 수 없는 경우에 발생하는 예외입니다.
            // 이 예외는 파일을 열거나 읽어들일 때, 파일이 존재하지 않는 경우 발생할 수 있습니다.
            e.printStackTrace();
            return false;
            //printStackTrace() 메서드는 예외가 발생했을 때,
            // 예외 발생 정보를 출력하는 메서드입니다

        } catch (IOException e) {
            //IOException 는 입출력 작업이 실패한 경우에 발생합니다
            e.printStackTrace();
            return false;

        }
        return true;
    }

    @Override
    public List<ImagePathResponseForm> imageList() {
        List<FileTest> fileTestList = filesTestRepository.findAll();

       // findAll()은 Spring Data JPA 에서 제공하는 메서드 중 하나로, 데이터베이스에 저장된 모든 엔티티를 조회하는 메서드입니다.
        List<ImagePathResponseForm> imagePathResponseFormList = new ArrayList<>();

        for (FileTest fileTest : fileTestList) {
            imagePathResponseFormList.add(new ImagePathResponseForm(fileTest.getImagePath()));

        }
        System.out.println(fileTestList);
        System.out.println(imagePathResponseFormList);
        return imagePathResponseFormList;
    }
}
