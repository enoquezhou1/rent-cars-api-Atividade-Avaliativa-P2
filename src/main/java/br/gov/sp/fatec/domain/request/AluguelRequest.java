package br.gov.sp.fatec.domain.request;

import java.util.Date;
import br.gov.sp.fatec.domain.enums.AluguelStatus;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import lombok.Builder;

@Builder
public record AluguelRequest(
    Carro carro,
    Cliente cliente,
    Date dataInicio,
    Double valor,
    Date dataFim,
    AluguelStatus status
) {} 
