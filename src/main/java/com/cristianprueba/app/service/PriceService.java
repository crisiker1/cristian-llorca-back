package com.cristianprueba.app.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.cristianprueba.app.dto.PriceDto;

/**
 * Servicio interface para Price
 */
@Service
public interface PriceService {

	/**
	 * Lista de prices por fecha actual en rango de fechas productId y brandId
	 * 
	 * @param appDate
	 * 
	 * @param productId
	 * 
	 * @param brandId
	 *            
	 * @return PriceDto List
	 */
	List<PriceDto> findPriceProductIdBrandIdFechaRango(String appDate, int productId, int brandId);
	
	/**
	 * Lista de prices por fecha actual en rango de fechas
	 *
	 * @param void
	 *            
	 * @return PriceDto List
	 */
	List<PriceDto> findPriceFechaRango();
	
	/**
	 * Lista de prices por fecha actual en rango de fechas
	 *
	 * @param priceDto
	 *            
	 * @return PriceDto
	 */
	PriceDto savePrice(PriceDto priceDto);


}
