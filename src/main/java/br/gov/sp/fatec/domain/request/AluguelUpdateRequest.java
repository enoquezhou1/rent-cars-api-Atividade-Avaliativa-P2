package br.gov.sp.fatec.domain.request;

import java.util.Date;
import br.gov.sp.fatec.domain.enums.AluguelStatus;
import lombok.Builder;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.entity.Carro;

@Builder
public record AluguelUpdateRequest(
    AluguelStatus status,
    Date dataInicio,
    Double valor,
    Carro carro,
    Date dataFim,
    Cliente cliente
) {} 
