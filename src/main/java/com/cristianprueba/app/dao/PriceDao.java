package com.cristianprueba.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cristianprueba.app.model.PriceEntity;

@Repository
public interface PriceDao extends JpaRepository<PriceEntity, Long>{

	
	/**
	 * Obtencion de la tabla acotando la fecha de aplicacion dentro del rango a aplicar, productId y brandId
	 * @param productId int
	 * @param brandId int
	 * @param fechaAplicacion String
	 * @return List PriceEntity
	 */
	@Query("SELECT h FROM PriceEntity h WHERE h.productId LIKE LOWER(:productId) AND h.brandId LIKE LOWER(:brandId) AND (h.startDate <= LOWER(:fechaAplicacion) AND h.endDate >= LOWER(:fechaAplicacion)) ORDER BY h.priority DESC")
	List<PriceEntity> findPriceProductIdBrandIdFechaRango(@Param("productId") int productId, @Param("brandId") int brandId, @Param("fechaAplicacion") String fechaAplicacion);

	/**
	 * Obtencion de la tabla acotando la fecha de aplicacion dentro del rango a aplicar
	 * @param fechaAplicacion String
	 * @return List PriceEntity
	 */
	@Query("SELECT h FROM PriceEntity h WHERE h.startDate <= LOWER(:fechaAplicacion) AND h.endDate >= LOWER(:fechaAplicacion) ORDER BY h.priority DESC")
	List<PriceEntity> findPriceFechaRango(@Param("fechaAplicacion") String fechaAplicacion);

}
