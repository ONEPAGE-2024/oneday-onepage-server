package com.onepage.server.domain.diary.service;

import com.onepage.server.domain.diary.dto.DiaryDTO;
import com.onepage.server.domain.diary.entity.Diary;
import com.onepage.server.domain.diary.mapper.DiaryMapper;
import com.onepage.server.domain.diary.repository.DiaryRepository;
import com.onepage.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository diaryRepository;
    private final DiaryMapper diaryMapper;

    @Override
    public BaseResponse diaryCreate(DiaryDTO diaryDTO) {
        diaryRepository.save(diaryMapper.dtoToEntity(diaryDTO));
        return new BaseResponse(HttpStatus.OK, "일기 작성 성공");
    }

    @Override
    public BaseResponse findAll() {
        List<Diary> diary = diaryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<DiaryDTO> dtos = diaryMapper.convertDevicesToDtos(diary);
        return new BaseResponse(HttpStatus.OK, "모든 일기 불러오기 성공", dtos);
    }

    @Override
    public BaseResponse updateDiary(DiaryDTO diaryDTO) {
        Diary diary = diaryRepository.findById(diaryDTO.id()).get();
        diary.fixData(diaryDTO.emotion(), diaryDTO.hashtag(), diaryDTO.content());
        diaryRepository.save(diary);
        return new BaseResponse(HttpStatus.OK, "일기 수정 성공");
    }

    @Override
    public BaseResponse deleteDiary(Long id) {
        if (!diaryRepository.existsById(id)) {
            throw new RuntimeException();
        }
        diaryRepository.deleteById(id);
        return new BaseResponse(HttpStatus.OK, "일기 삭제 성공");
    }
}