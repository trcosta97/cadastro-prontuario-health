package com.telemedicina.pre_cadastro.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PreSavePacienteRequestDTO(

        @NotBlank(message = "O nome completo é obrigatório")
        @Size(max = 100, message = "O nome completo deve ter no máximo 100 caracteres")
        String nomeCompleto,

        @NotBlank(message = "O CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos")
        String cpf,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve ser no passado")
        LocalDate dataNascimento,

        @NotBlank(message = "O sexo é obrigatório")
        @Pattern(regexp = "^(M|F|O)$", message = "Sexo deve ser 'M', 'F' ou 'O'")
        String sexo,

        boolean gestante,
        boolean pueperia,

        @NotBlank(message = "O celular é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "O celular deve conter 11 dígitos (DDD + número)")
        String celular,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
        String senha,

        @NotNull(message = "O endereço é obrigatório")
        @Valid
        SaveEnderecoRequestDTO endereco,
        @NotBlank
        @Valid
        String cdProntuario

) {}
