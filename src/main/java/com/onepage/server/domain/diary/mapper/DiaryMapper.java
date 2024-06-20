package com.onepage.server.domain.diary.mapper;

import com.onepage.server.domain.diary.dto.DiaryDTO;
import com.onepage.server.domain.diary.entity.Diary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiaryMapper {
    public static DiaryDTO entityToDto(Diary entity) {
        return DiaryDTO.builder()
                .id(entity.getId())
                .emotion(entity.getEmotion())
                .hashtag(entity.getHashtag())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .build();
    }

    public static Diary dtoToEntity(DiaryDTO dto) {
        return Diary.builder()
                .emotion(dto.emotion())
                .hashtag(dto.hashtag())
                .content(dto.content())
                .regDate(LocalDateTime.now())
                .build();
    }

    public static List<DiaryDTO> convertDevicesToDtos(List<Diary> devices) {
        return devices.stream()
                .map(DiaryMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
