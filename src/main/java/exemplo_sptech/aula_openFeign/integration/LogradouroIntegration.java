package exemplo_sptech.aula_openFeign.integration;

import exemplo_sptech.aula_openFeign.dto.LogradouroResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "logradouroIntegration", url = "${viacep.url}")
public interface LogradouroIntegration {
    // VIACEP: GET https://viacep.com.br/ws/{cep}/json/
@GetMapping("/{cep}/json/")
    LogradouroResponseDto buscarPorCep(@PathVariable String cep);










}
