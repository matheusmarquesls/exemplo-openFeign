package exemplo_sptech.aula_openFeign.service;

import exemplo_sptech.aula_openFeign.dto.LogradouroResponseDto;
import exemplo_sptech.aula_openFeign.dto.MusicaRequestDto;
import exemplo_sptech.aula_openFeign.dto.MusicaResponseDto;
import exemplo_sptech.aula_openFeign.integration.LogradouroIntegration;
import exemplo_sptech.aula_openFeign.integration.MusicasIntegration;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class MusicaService {

    private final MusicasIntegration integration;

    public List<MusicaResponseDto> listar(){
        return integration.listagem();

    }
    public MusicaResponseDto buscarPorId(int id) {

        try {
            return integration.buscarPorId(id);
        } catch (FeignException ex) {
            log.error("erro ao buscar Musica {}", ex.getMessage());
            int status = ex.status();
            switch (status) {
                case 404:
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                case 400:
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                default:
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    public MusicaResponseDto cadastrar (@RequestBody MusicaRequestDto dto)
    {
        return integration.cadastrar(dto);
    }
}
