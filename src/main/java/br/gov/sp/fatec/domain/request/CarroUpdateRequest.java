package br.gov.sp.fatec.domain.request;

import lombok.Builder;
import br.gov.sp.fatec.domain.enums.CarroStatus;

@Builder
public record CarroUpdateRequest(
    Long id,
    int ano,
    String marca,
    String modelo,
    CarroStatus carroStatus    
) {}
