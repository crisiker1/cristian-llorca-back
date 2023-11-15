package com.cristianprueba.app.mapper;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.cristianprueba.app.dto.PriceDto;
import com.cristianprueba.app.model.PriceEntity;

/**
 * Mapper entidades y dto Prices
 */
@Mapper(componentModel = "spring", 
		unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapping {

	@Mapping(source = "startDate", target = "startDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Mapping(source = "endDate", target = "endDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
	PriceEntity priceDtoToEntity(PriceDto priceDto);	
	List<PriceEntity> priceDtosToEntities(List<PriceDto> priceDtos);
	
	PriceDto priceToDto(PriceEntity price);
	List<PriceDto> priceToDtos(List<PriceEntity> prices);
	
}
