package com.onepage.server.domain.diary.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        기분
    */
    @Column(nullable = false)
    private String emotion;

    /*
        해시태그
    */
    @ElementCollection
    private List<String> hashtag;

    /*
        일기
    */
    @Column(nullable = false)
    private String content;

    /*
        작성일
    */
    @Column(nullable = false)
    private LocalDateTime regDate;

    @Builder
    public Diary (String emotion, List<String> hashtag, String content, LocalDateTime regDate) {
        this.emotion = emotion;
        this.hashtag = hashtag;
        this.content = content;
        this.regDate = regDate;
    }

    public void fixData(String emotion, List<String> hashtag, String content){
        this.emotion = emotion;
        this.hashtag = hashtag;
        this.content = content;
    }
}
