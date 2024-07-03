package br.gov.sp.fatec.domain.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface CarroMapper {
    CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);
    
    Carro map(CarroRequest source);

    AluguelResponse map(Carro source);
}
