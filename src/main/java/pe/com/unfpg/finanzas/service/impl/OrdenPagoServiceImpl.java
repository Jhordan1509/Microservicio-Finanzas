package pe.com.unfpg.finanzas.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.finanzas.client.AcademicoFeignClient;
import pe.com.unfpg.finanzas.client.CatalogoFeignClient;
import pe.com.unfpg.finanzas.entity.OrdenPagoEntity;
import pe.com.unfpg.finanzas.repository.OrdenPagoRepository;
import pe.com.unfpg.finanzas.service.OrdenPagoService;

@Service
public class OrdenPagoServiceImpl implements OrdenPagoService {

	private final OrdenPagoRepository repositorio;
	private final CatalogoFeignClient catalogoFeignClient;
	private final AcademicoFeignClient academicoFeignClient;

	public OrdenPagoServiceImpl(
	        OrdenPagoRepository repositorio,
	        CatalogoFeignClient catalogoFeignClient,
	        AcademicoFeignClient academicoFeignClient) {

	    this.repositorio = repositorio;
	    this.catalogoFeignClient = catalogoFeignClient;
	    this.academicoFeignClient = academicoFeignClient;
	}
	@Override
	public List<OrdenPagoEntity> findAll() {
		List<OrdenPagoEntity> ordenes=repositorio.findAll();
		for(OrdenPagoEntity orden:ordenes) {
			orden.setConceptoPago(catalogoFeignClient.getConceptoPago(orden.getCodconp()));
			orden.setMatricula(academicoFeignClient.getMatricula(orden.getNummat()));
			orden.setMetodoPago(catalogoFeignClient.getMetodoPago(orden.getCodmetp()));
			orden.setEstadoPago(catalogoFeignClient.getEstadoPago(orden.getCodestp()));
		}
		return ordenes;
	}
	
	

	@Override
	public List<OrdenPagoEntity> findAllCustom() {
		List<OrdenPagoEntity> ordenes = repositorio.findAllCustom();
		for(OrdenPagoEntity orden:ordenes) {
			orden.setConceptoPago(catalogoFeignClient.getConceptoPago(orden.getCodconp()));
			orden.setMatricula(academicoFeignClient.getMatricula(orden.getNummat()));
			orden.setMetodoPago(catalogoFeignClient.getMetodoPago(orden.getCodmetp()));
			orden.setEstadoPago(catalogoFeignClient.getEstadoPago(orden.getCodestp()));
		}
		return ordenes;
	}
	
	
	
	

	@Override
	public OrdenPagoEntity findById(Long id) {
	    OrdenPagoEntity orden=repositorio.findById(id).get();
	    orden.setConceptoPago(catalogoFeignClient.getConceptoPago(orden.getCodconp()));
		orden.setMatricula(academicoFeignClient.getMatricula(orden.getNummat()));
	    orden.setMetodoPago(catalogoFeignClient.getMetodoPago(orden.getCodmetp()));
	    orden.setEstadoPago(catalogoFeignClient.getEstadoPago(orden.getCodestp()));
	    return orden;
	}
	
	
	@Override
	public OrdenPagoEntity add(OrdenPagoEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public OrdenPagoEntity update(OrdenPagoEntity obj, Long id) {
		// buscar el valor que se va a actualizar
		OrdenPagoEntity objord = repositorio.findById(id).get();
		// actualizamos los valores, sin pisar el codigo
		BeanUtils.copyProperties(obj, objord, "codigo");
		return repositorio.save(objord);
	}

	@Override
	public OrdenPagoEntity delete(Long id) {
		// borrado logico: cambiamos el estado
		OrdenPagoEntity objord = repositorio.findById(id).get();
		objord.setEstado(false);
		return repositorio.save(objord);
	}

	@Override
	public OrdenPagoEntity enable(Long id) {
		// habilitar: cambiamos el estado
		OrdenPagoEntity objord = repositorio.findById(id).get();
		objord.setEstado(true);
		return repositorio.save(objord);
	}
}