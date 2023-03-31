package com.gordon.service;

import com.gordon.dto.CardDto;
import com.gordon.mapper.CardMapper;
import com.gordon.model.Card;
import com.gordon.repository.CardRepository;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

  private final CardRepository cardRepository;
  private final CardMapper cardMapper;
  public List<CardDto> getCardDetails(Long id) {
    List<Card> cards = cardRepository.findByCustomerId(id);
    return cards.stream().map(cardMapper::toDto).collect(Collectors.toList());
  }
}
