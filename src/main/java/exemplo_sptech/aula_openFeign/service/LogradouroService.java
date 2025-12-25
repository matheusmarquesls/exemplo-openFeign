package exemplo_sptech.aula_openFeign.service;

import exemplo_sptech.aula_openFeign.dto.LogradouroResponseDto;
import exemplo_sptech.aula_openFeign.integration.LogradouroIntegration;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LogradouroService {

    private  final LogradouroIntegration integration;

    public LogradouroResponseDto buscarPorCep(String cep){

        try {
            LogradouroResponseDto logradouroResponseDto = integration.buscarPorCep(cep);
            return logradouroResponseDto;
        }catch (FeignException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }


    }
}
