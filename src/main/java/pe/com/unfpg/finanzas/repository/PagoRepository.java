package pe.com.unfpg.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.unfpg.finanzas.entity.PagoEntity;

public interface PagoRepository extends JpaRepository<PagoEntity, Long> {

	// pagos habilitados
	@Query("SELECT p FROM PagoEntity p WHERE p.estado = true")
	List<PagoEntity> findAllCustom();
}