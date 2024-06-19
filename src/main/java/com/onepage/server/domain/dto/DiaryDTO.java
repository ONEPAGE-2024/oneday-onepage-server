package com.onepage.server.domain.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DiaryDTO (
        Long id,
        String emotion,
        String hashtag,
        String content,
        LocalDateTime regDate
) {
}
