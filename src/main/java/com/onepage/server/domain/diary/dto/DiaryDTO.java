package com.onepage.server.domain.diary.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record DiaryDTO (
        Long id,
        String emotion,
        List<String> hashtag,
        String content,
        LocalDateTime regDate
) {
}
