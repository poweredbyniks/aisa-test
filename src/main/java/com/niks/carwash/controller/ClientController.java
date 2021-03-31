package com.niks.carwash.controller;

import com.niks.carwash.entity.Client;
import com.niks.carwash.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/client-management")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam final Client client) {
        clientService.create(client);
    }

    @GetMapping("/clients/{ID}")
    public Client findByID(@PathVariable("ID") final Long ID) {
        return clientService.findByID(ID);
    }

    @DeleteMapping("/clients/{ID}")
    public void deleteByID(@PathVariable("ID") final Long ID) {
        clientService.removeByID(ID);
    }
}
