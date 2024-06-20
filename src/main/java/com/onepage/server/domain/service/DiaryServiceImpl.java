package com.onepage.server.domain.service;

import com.onepage.server.domain.dto.DiaryDTO;
import com.onepage.server.domain.mapper.DiaryMapper;
import com.onepage.server.domain.repository.DiaryRepository;
import com.onepage.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
}