package com.onepage.server.domain.controller;

import com.onepage.server.domain.dto.DiaryDTO;
import com.onepage.server.domain.service.DiaryService;
import com.onepage.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/create")
    public BaseResponse diaryCreate(@RequestBody DiaryDTO diaryDTO){
        return diaryService.diaryCreate(diaryDTO);
    }

    @GetMapping("/list")
    public BaseResponse allDiary(){
        return diaryService.findAll();
    }

    @PutMapping("/update")
    public void updateDiary(@RequestBody DiaryDTO diaryDTO) {
        diaryService.updateDiary(diaryDTO);
    }
    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteDiary(@PathVariable Long id){
        return diaryService.deleteDiary(id);
    }
}
