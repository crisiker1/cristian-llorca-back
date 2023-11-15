package com.cristianprueba.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cristianprueba.app.dto.BodyPriceDto;
import com.cristianprueba.app.dto.PriceDto;

/**
 * Controller interface para Prices servicios REST
 */
public interface PriceController {

	/**
	 * Controlador para devolver la lista de prices por fecha actual en rango de fechas
	 * 
	 * @param BodyPriceDto
	 *            
	 * @return ResponseEntity PriceDto List
	 */
	ResponseEntity<List<PriceDto>> findPriceFechaRango(BodyPriceDto request);

	/**
	 * Lista de prices por fecha actual en rango de fechas
	 *
	 * @param priceDto
	 *            
	 * @return ResponseEntity PriceDto
	 */
	ResponseEntity<PriceDto> savePrice(PriceDto request);

}
