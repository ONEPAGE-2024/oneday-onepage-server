package com.onepage.server.domain.diary.service;

import com.onepage.server.domain.diary.dto.DiaryDTO;
import com.onepage.server.global.common.BaseResponse;

public interface DiaryService {
    BaseResponse diaryCreate(DiaryDTO diaryDTO);
    BaseResponse findAll();
    BaseResponse updateDiary(DiaryDTO diaryDTO);
    BaseResponse deleteDiary(Long id);
}
