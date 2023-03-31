package com.gordon.mapper;

import com.gordon.dto.CardDto;
import com.gordon.model.Card;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface CardMapper {

  Card toEntity(CardDto cardDto);

  CardDto toDto(Card card);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Card partialUpdate(
      CardDto cardDto, @MappingTarget Card card);
}