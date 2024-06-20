package com.onepage.server.domain.service;

import com.onepage.server.domain.dto.DiaryDTO;
import com.onepage.server.global.common.BaseResponse;

public interface DiaryService {
    BaseResponse diaryCreate(DiaryDTO diaryDTO);
}
