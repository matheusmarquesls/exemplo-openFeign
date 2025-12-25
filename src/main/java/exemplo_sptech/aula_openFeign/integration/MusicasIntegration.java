package exemplo_sptech.aula_openFeign.integration;

import exemplo_sptech.aula_openFeign.dto.LogradouroResponseDto;
import exemplo_sptech.aula_openFeign.dto.MusicaRequestDto;
import exemplo_sptech.aula_openFeign.dto.MusicaResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "musicaIntegration", url = "${musica.url}")
public interface MusicasIntegration {

        @GetMapping
        List <MusicaResponseDto> listagem ();

        @GetMapping("/{id}")
        MusicaResponseDto buscarPorId(@PathVariable int id);

        @PostMapping
        MusicaResponseDto cadastrar(@RequestBody MusicaRequestDto dto);
}
