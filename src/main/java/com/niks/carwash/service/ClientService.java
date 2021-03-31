package com.niks.carwash.service;

import com.niks.carwash.entity.Client;
import com.niks.carwash.repository.ClientRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @NotNull
    public void create(@NotNull final Client client) {
        clientRepository.save(client);
    }

    @NotNull
    public Client findByID(@NotNull final Long ID) {
        Client client = null;
        if (clientRepository.findById(ID).isPresent()) {
            client = clientRepository.findById(ID).get();
        }
        return client;
    }

    @NotNull
    public void removeByID(@NotNull final Long ID) {
        clientRepository.deleteById(ID);
    }
}
