package com.gordon.mapper;

import com.gordon.model.Account;
import com.gordon.dto.AccountDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface AccountMapper {

  Account toEntity(AccountDto accountDto);

  AccountDto toDto(Account account);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Account partialUpdate(
      AccountDto accountDto, @MappingTarget Account account);
}