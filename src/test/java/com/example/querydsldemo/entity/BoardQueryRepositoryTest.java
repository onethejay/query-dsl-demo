package com.example.querydsldemo.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BoardQueryRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardQueryRepository boardQueryRepository;

    @DisplayName("1. querydsl 테스트")
    @Test
    void test_1(){
        //given
        String title = "제목1";
        String author = "작성자;";
        String contents = "본문1";

        boardRepository.save(BoardEntity.builder()
                        .title(title)
                        .author(author)
                        .contents(contents)
                .build());

        //when
        List<BoardEntity> result = boardQueryRepository.findByTitle(title);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getAuthor()).isEqualTo(author);

    }

}