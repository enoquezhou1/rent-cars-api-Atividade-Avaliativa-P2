package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Override
    public CarroResponse findById(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado!"));
        return carroMapper.map(carro);
    }
    @Override
    public CarroResponse save(CarroRequest carroRequest) {
        Carro carro = carroMapper.map(carroRequest);
        Carro savedCarro = carroRepository.save(carro);
        return carroMapper.map(savedCarro);
    }
    @Override
    public List<CarroResponse> findAll() {
        List<Carro> carros = carroRepository.findAll();
        List<CarroResponse> responses = new ArrayList<>();
        for (Carro carro : carros) {
            responses.add(carroMapper.map(carro));
        }
        return responses;
    }
    @Override
    public void deleteById(Long id) {
        if (!carroRepository.existsById(id)) {
            throw new EntityNotFoundException("Carro não encontrado!");
        }
        carroRepository.deleteById(id);
    }
    @Override
    public void updateById(Long id, CarroUpdateRequest carroUpdateRequest) {
        Carro carroToUpdate = carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não foi encontrado! por favor verifique se inseriu as credenciais corretamente"));

        carroRepository.save(carroToUpdate);
    }
}
