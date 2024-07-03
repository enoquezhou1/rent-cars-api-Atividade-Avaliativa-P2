package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.CarroStatus;
import lombok.Builder;

@Builder
public record CarroRequest(
    Long id,
    int ano,
    CarroStatus carroStatus,
    String marca,
    String modelo
) {}
