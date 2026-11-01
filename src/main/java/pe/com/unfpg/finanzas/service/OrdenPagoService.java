package pe.com.unfpg.finanzas.service;

import java.util.List;

import pe.com.unfpg.finanzas.entity.OrdenPagoEntity;

public interface OrdenPagoService {

	List<OrdenPagoEntity> findAll();

	List<OrdenPagoEntity> findAllCustom();

	OrdenPagoEntity findById(Long id);

	OrdenPagoEntity add(OrdenPagoEntity obj);

	OrdenPagoEntity update(OrdenPagoEntity obj, Long id);

	OrdenPagoEntity delete(Long id);

	OrdenPagoEntity enable(Long id);
}