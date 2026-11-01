package pe.com.unfpg.finanzas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="unfpg-microservicio-catalogo", url="http://localhost:9091/unfpg/api/")
public interface CatalogoFeignClient {

    @GetMapping("/conceptopago/{id}")
    Object getConceptoPago(@PathVariable("id") Long id);

    @GetMapping("/metodopago/{id}")
    Object getMetodoPago(@PathVariable("id") Long id);

    @GetMapping("/estadopago/{id}")
    Object getEstadoPago(@PathVariable("id") Long id);

   
}