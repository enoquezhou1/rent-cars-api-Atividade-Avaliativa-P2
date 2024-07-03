package br.gov.sp.fatec.domain.response;

import java.time.LocalDate;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.enums.AluguelStatus;

public record CarroResponse(
    Long id,
    Cliente cliente,
    LocalDate dataInicio,
    Double valor,
    Carro carro,
    LocalDate dataFim,
    AluguelStatus status
) {}
