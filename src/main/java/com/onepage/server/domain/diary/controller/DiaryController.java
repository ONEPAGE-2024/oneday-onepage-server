package com.onepage.server.domain.diary.controller;

import com.onepage.server.domain.diary.dto.DiaryDTO;
import com.onepage.server.domain.diary.service.DiaryService;
import com.onepage.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
@Tag(name = "일기", description = "하루한장 api 문서입니다.")
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/create")
    @Operation(summary = "일기 생성", description = "일기를 작성합니다.")
    public BaseResponse diaryCreate(@RequestBody DiaryDTO diaryDTO){
        return diaryService.diaryCreate(diaryDTO);
    }

    @GetMapping("/list")
    @Operation(summary = "일기 조회", description = "일기들을 조회합니다.")
    public BaseResponse allDiary(){
        return diaryService.findAll();
    }

    @PutMapping("/update")
    @Operation(summary = "일기 수정", description = "일기를 수정합니다.")
    public void updateDiary(@RequestBody DiaryDTO diaryDTO) {
        diaryService.updateDiary(diaryDTO);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "일기 삭제", description = "일기를 삭제합니다.")
    public BaseResponse deleteDiary(@PathVariable Long id){
        return diaryService.deleteDiary(id);
    }
}
