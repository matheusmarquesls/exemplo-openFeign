package exemplo_sptech.aula_openFeign.controller;

import exemplo_sptech.aula_openFeign.dto.LogradouroResponseDto;
import exemplo_sptech.aula_openFeign.service.LogradouroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/logradouros")
public class LogradouroController {


     private final LogradouroService service;

     @GetMapping("/{cep}")
    public ResponseEntity<LogradouroResponseDto>  BuscarPorCep(@PathVariable String cep){

         LogradouroResponseDto logradouroResponseDto = service.buscarPorCep(cep);

         return ResponseEntity.ok(logradouroResponseDto);
     }




}
