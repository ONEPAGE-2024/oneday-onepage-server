package com.onepage.server.domain.controller;

import com.onepage.server.domain.dto.DiaryDTO;
import com.onepage.server.domain.service.DiaryService;
import com.onepage.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/create")
    public BaseResponse diaryCreate(@RequestBody DiaryDTO diaryDTO){
        return diaryService.diaryCreate(diaryDTO);
    }

}
