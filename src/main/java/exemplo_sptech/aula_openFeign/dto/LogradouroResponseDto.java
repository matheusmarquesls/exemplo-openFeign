package exemplo_sptech.aula_openFeign.dto;

// gera obj imutaveis... constantes...
public record LogradouroResponseDto(
        String cep,
        String logradouro,
        String complemento,
        String unidade,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao
) {
}
