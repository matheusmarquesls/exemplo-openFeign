package exemplo_sptech.aula_openFeign.dto;

import java.time.LocalDateTime;

public record MusicaResponseDto(
        int id,
        String nome,
        String genero,
        String artista
) {
}
