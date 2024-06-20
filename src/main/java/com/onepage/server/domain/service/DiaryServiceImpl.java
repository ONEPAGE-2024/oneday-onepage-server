package com.onepage.server.domain.service;

import com.onepage.server.domain.dto.DiaryDTO;
import com.onepage.server.domain.entity.Diary;
import com.onepage.server.domain.mapper.DiaryMapper;
import com.onepage.server.domain.repository.DiaryRepository;
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
    public void updateDiary(DiaryDTO diaryDTO) {
        Diary diary = diaryRepository.findById(diaryDTO.id()).get();
        diary.fixData(diaryDTO.emotion(), diaryDTO.hashtag(), diaryDTO.content());
        diaryRepository.save(diary);
    }
}