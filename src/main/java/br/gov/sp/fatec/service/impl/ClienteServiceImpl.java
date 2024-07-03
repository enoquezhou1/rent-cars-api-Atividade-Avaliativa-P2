package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponse findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
        return clienteMapper.map(cliente);
    }
    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.map(clienteRequest);
        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.map(savedCliente);
    }
    @Override
    public List<ClienteResponse> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponse> responses = new ArrayList<>();
        for (Cliente cliente : clientes) {
            responses.add(clienteMapper.map(cliente));
        }
        return responses;
    }
    @Override
    public void deleteById(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Cliente não encontrado!");
        }
        clienteRepository.deleteById(id);
    }
    @Override
    public void updateById(Long id, ClienteUpdateRequest clienteUpdateRequest) {
        Cliente clienteToUpdate = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

        clienteRepository.save(clienteToUpdate);
    }
}
