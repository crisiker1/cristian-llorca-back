package com.cristianprueba.app.controller;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cristianprueba.app.dto.BodyPriceDto;

@SpringBootTest
public class PriceControllerImplTest {

	@Autowired
    private PriceController pricecontroller;


    @Test
	public void findPriceFechaRangoTest1() {
    	BodyPriceDto bodyDtoIn = new BodyPriceDto("2023-06-14 10:00:00", 1, 35455);

    	// Con los datos actuales en BBDD, la llamada no deberia ser nula.
    	// Y deberia de devolver al menos 1 registro (si decidimos aderir mas)
		assertNotNull(pricecontroller.findPriceFechaRango(bodyDtoIn));
		assertTrue(pricecontroller.findPriceFechaRango(bodyDtoIn).getBody().size() >= 1);
	}
    
    @Test
	public void findPriceFechaRangoTest2() {
    	BodyPriceDto bodyDtoIn = new BodyPriceDto("2023-06-14 16:00:00", 1, 35455);

    	// Con los datos actuales en BBDD, la llamada no deberia ser nula.
    	// Y deberia de devolver al menos 2 registros (si decidimos aderir mas)
		assertNotNull(pricecontroller.findPriceFechaRango(bodyDtoIn));
		assertTrue(pricecontroller.findPriceFechaRango(bodyDtoIn).getBody().size() >= 2);
	}
    
    @Test
	public void findPriceFechaRangoTest3() {
    	BodyPriceDto bodyDtoIn = new BodyPriceDto("2023-06-14 21:00:00", 1, 35455);

    	// Con los datos actuales en BBDD, la llamada no deberia ser nula.
    	// Y deberia de devolver al menos 1 registro (si decidimos aderir mas)
		assertNotNull(pricecontroller.findPriceFechaRango(bodyDtoIn));
		assertTrue(pricecontroller.findPriceFechaRango(bodyDtoIn).getBody().size() >= 1);
	}
    
    @Test
	public void findPriceFechaRangoTest4() {
    	BodyPriceDto bodyDtoIn = new BodyPriceDto("2023-06-15 10:00:00", 1, 35455);

    	// Con los datos actuales en BBDD, la llamada no deberia ser nula.
    	// Y deberia de devolver al menos 2 registros (si decidimos aderir mas)
		assertNotNull(pricecontroller.findPriceFechaRango(bodyDtoIn));
		assertTrue(pricecontroller.findPriceFechaRango(bodyDtoIn).getBody().size() >= 2);
	}
    
    @Test
	public void findPriceFechaRangoTest5() {
    	BodyPriceDto bodyDtoIn = new BodyPriceDto("2023-06-16 21:00:00", 1, 35455);

    	// Con los datos actuales en BBDD, la llamada no deberia ser nula.
    	// Y deberia de devolver al menos 2 registros (si decidimos aderir mas)
		assertNotNull(pricecontroller.findPriceFechaRango(bodyDtoIn));
		assertTrue(pricecontroller.findPriceFechaRango(bodyDtoIn).getBody().size() >= 2);
	}


}
