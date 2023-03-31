package com.gordon.mapper;

import com.gordon.dto.LoanDto;
import com.gordon.model.Loan;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface LoanMapper {

  Loan toEntity(LoanDto loanDto);

  LoanDto toDto(Loan loan);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Loan partialUpdate(
      LoanDto loanDto, @MappingTarget Loan loan);
}