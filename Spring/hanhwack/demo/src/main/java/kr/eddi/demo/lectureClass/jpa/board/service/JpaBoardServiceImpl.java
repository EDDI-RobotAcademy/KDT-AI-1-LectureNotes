package kr.eddi.demo.lectureClass.jpa.board.service;

import kr.eddi.demo.lectureClass.jpa.board.entity.JpaBoard;
import kr.eddi.demo.lectureClass.jpa.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaBoardServiceImpl implements JpaBoardService {

    final private JpaBoardRepository boardRepository;

    @Override
    public List<JpaBoard> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }
}