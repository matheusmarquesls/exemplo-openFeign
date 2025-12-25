package exemplo_sptech.aula_openFeign.controller;

import exemplo_sptech.aula_openFeign.dto.LogradouroResponseDto;
import exemplo_sptech.aula_openFeign.dto.MusicaRequestDto;
import exemplo_sptech.aula_openFeign.dto.MusicaResponseDto;
import exemplo_sptech.aula_openFeign.service.MusicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/musicas")
public class MusicasController {

    private final MusicaService service;


    @GetMapping
    public ResponseEntity<List<MusicaResponseDto>>  listar() {

       List <MusicaResponseDto> ResponseDto = service.listar();

        return ResponseEntity.status(200).body(ResponseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity <MusicaResponseDto> buscarPorId(@PathVariable int id) {

        MusicaResponseDto ResponseDto = service.buscarPorId(id);

        return ResponseEntity.status(200).body(ResponseDto);
    }
    @PostMapping
    public ResponseEntity<MusicaResponseDto> cadastrar(
            @RequestBody MusicaRequestDto dto
            ){
        MusicaResponseDto responseDto = service.cadastrar(dto);
        return ResponseEntity.created(null).body(responseDto);
    }



}
