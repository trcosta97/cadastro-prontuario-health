package com.telemedicina.pre_cadastro.domain.dto;

import java.util.List;

public record LoginResponseDTO(String accessToken, Long expiresIn, List<String> roles) {
}
