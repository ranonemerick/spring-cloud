package io.github.ranonemerick.msclients.application;

import io.github.ranonemerick.msclients.domain.Client;
import io.github.ranonemerick.msclients.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getByCPF(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

}
