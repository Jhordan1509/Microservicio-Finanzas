package pe.com.unfpg.finanzas.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="unfpg-microservicio-academico",url="http://localhost:9094/unfpg/api/")

public interface AcademicoFeignClient {

	@GetMapping("/matricula/{id}")
	Object getMatricula(@PathVariable("id") Long id);
	

}
