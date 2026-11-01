package pe.com.unfpg.finanzas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.unfpg.finanzas.entity.OrdenPagoEntity;
import pe.com.unfpg.finanzas.service.OrdenPagoService;

@RestController
@RequestMapping("/api/ordenpago")
public class OrdenPagoRestController {

	@Autowired
	private OrdenPagoService servicio;

	@GetMapping
	public List<OrdenPagoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<OrdenPagoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public OrdenPagoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public OrdenPagoEntity add(@RequestBody OrdenPagoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public OrdenPagoEntity update(@RequestBody OrdenPagoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public OrdenPagoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public OrdenPagoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}