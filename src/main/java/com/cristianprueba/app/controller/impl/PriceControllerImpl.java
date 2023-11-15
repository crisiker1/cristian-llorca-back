package com.cristianprueba.app.controller.impl;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristianprueba.app.controller.PriceController;
import com.cristianprueba.app.dto.BodyPriceDto;
import com.cristianprueba.app.dto.PriceDto;
import com.cristianprueba.app.service.PriceService;

@RestController
@RequestMapping(value = "/price")
public class PriceControllerImpl implements PriceController {
	
	private static final Logger logger = LoggerFactory.getLogger(PriceControllerImpl.class);
	
	@Autowired
	private PriceService priceService;
	
	@Override
	@PostMapping("/findPriceFechaRango")
	public ResponseEntity<List<PriceDto>> findPriceFechaRango(@RequestBody BodyPriceDto request) {
		// Se pasa por el body el BodyPriceDto
		logger.info("Llamada al endpoint /findPriceFechaRango con variables {}, {}, {}", request.getAppDate(), request.getProductId(), request.getBrandId());
		List<PriceDto> response = new ArrayList<PriceDto>();
		
		// Primero se intenta la llamada findPriceProductIdBrandIdFechaRango.
		// Si hay un parametro mal definido, el catch llama a findPriceFechaRango
		try {
			response = priceService.findPriceProductIdBrandIdFechaRango(request.getAppDate(), request.getProductId(), request.getBrandId());
		} catch (Exception e) {
			logger.warn("Se procede a la llamada findPriceFechaRango debido al error: {}", e.toString());
			response = priceService.findPriceFechaRango();
		}
		
		return ResponseEntity.ok(response);
	}
	
	@Override
	@PostMapping("/savePrice")
	public ResponseEntity<PriceDto> savePrice(@RequestBody PriceDto request) {
		// Se pasa por el body el PriceDto
		logger.info("Llamada al endpoint /savePrice con variables {}, {}, {}, {}, {}, {}", request.getProductId(), request.getStartDate(), request.getEndDate(), request.getPriceList(), request.getPrice(), request.getBrandId());
		
		return ResponseEntity.ok(priceService.savePrice(request));
	}

}
