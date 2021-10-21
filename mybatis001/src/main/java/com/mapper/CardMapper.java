package com.mapper;

import com.entity.card;

import java.util.List;

public interface CardMapper {
    card findByCno(String cno);
    List<card> findAll();
    int save(card card);
    int deleteByCno(String cno);
    int updateCardName(card card);
}
