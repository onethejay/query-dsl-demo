package com.example.querydsldemo.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.querydsldemo.entity.QBoardEntity.boardEntity;

@RequiredArgsConstructor
@Repository
public class BoardQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<BoardEntity> findByTitle(String title) {
        return queryFactory.selectFrom(boardEntity)
                .where(boardEntity.title.eq(title))
                .fetch();
    }
}
