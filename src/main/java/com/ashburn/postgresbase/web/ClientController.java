package com.ashburn.postgresbase.web;

import com.ashburn.postgresbase.model.Client;
import com.ashburn.postgresbase.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    private final ClientRepository clientRepository;
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/clients")
    public List<Client> findAllClients() {
        List<Client> result = new ArrayList<Client>();
        this.clientRepository.findAll().forEach(result::add);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/clients/{id}")
    public Client findClient(@PathVariable Long id) {
        Client found = this.clientRepository.findById(id).orElse(null);
        if(found == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return found;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/clients")
    public Client addOneClient(@RequestBody Client prop) {
        return this.clientRepository.save(prop);
    }
}
