package com.cristianprueba.app.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristianprueba.app.dao.PriceDao;
import com.cristianprueba.app.dto.PriceDto;
import com.cristianprueba.app.mapper.PriceMapping;
import com.cristianprueba.app.model.PriceEntity;
import com.cristianprueba.app.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {
	
	private static final Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);

	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	private PriceMapping priceMapper;
	
	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public List<PriceDto> findPriceProductIdBrandIdFechaRango(String appDate, int productId, int brandId) {
		List<PriceEntity> priceList = new ArrayList<PriceEntity>();
		logger.info("Llamada al servicio findPriceProductIdBrandIdFechaRango");
		
		// No hacemos comprobacion productId ni de brandId. Si no estuvieran definidas correctamente, pasa al metodo findPriceFechaRango
		// Si appDate es pasado por parametro, lo procesamos, y si es nulo o vacio, usamos la fecha actual
		// findPriceProductIdBrandIdFechaRango procesa la fecha pasada, entre los rangos Start y End de la tabla, el productId, y brandId
		priceList = priceDao.findPriceProductIdBrandIdFechaRango(
				productId,
				brandId,
				(appDate != null && !appDate.isEmpty()) ? appDate : formatters.format(LocalDateTime.now()));
		
		return priceMapper.priceToDtos(priceList);
	}
	
	@Override
	public List<PriceDto> findPriceFechaRango() {
		logger.info("Llamada al servicio findPriceFechaRango");

		// Si uno de los parametros no esta definido correctamente,
		// usamos la fecha actual como sustitutivo de appDate, y no acotamos por productId y brandId 		
		return priceMapper.priceToDtos(priceDao.findPriceFechaRango(formatters.format(LocalDateTime.now())));
	}
	
	@Override
	public PriceDto savePrice(PriceDto priceDto) {
		logger.info("Llamada al servicio savePrice");
		
		// No es necesario realizar comprobaciones de registros existentes
		PriceEntity priceEntity = priceMapper.priceDtoToEntity(priceDto);
		
		// Valores por defecto al aderir. Se podria hacer en la implementacion del mapper tambien
        priceEntity.setCurr("EUR");
        priceEntity.setPriority(0);
        
        return priceMapper.priceToDto(priceDao.save(priceEntity));
	}

}
