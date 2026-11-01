package pe.com.unfpg.finanzas.service;

import java.util.List;

import pe.com.unfpg.finanzas.entity.PagoEntity;

public interface PagoService {

	List<PagoEntity> findAll();

	List<PagoEntity> findAllCustom();

	PagoEntity findById(Long id);

	PagoEntity add(PagoEntity obj);

	PagoEntity update(PagoEntity obj, Long id);

	PagoEntity delete(Long id);

	PagoEntity enable(Long id);
}