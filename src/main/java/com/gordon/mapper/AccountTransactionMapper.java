package com.gordon.mapper;

import com.gordon.dto.AccountTransactionDto;
import com.gordon.model.AccountTransaction;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface AccountTransactionMapper {

  AccountTransaction toEntity(AccountTransactionDto accountTransactionDto);

  AccountTransactionDto toDto(AccountTransaction accountTransaction);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  AccountTransaction partialUpdate(
      AccountTransactionDto accountTransactionDto,
      @MappingTarget AccountTransaction accountTransaction);
}