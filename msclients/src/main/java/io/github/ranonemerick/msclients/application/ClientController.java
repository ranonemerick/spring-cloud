package io.github.ranonemerick.msclients.application;

import io.github.ranonemerick.msclients.application.representation.ClientSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientSaveRequest request) {
        var client = request.toModel();
        clientService.save(client);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).body(client);
    }

    @GetMapping
    public ResponseEntity<?> clientData(@RequestParam String cpf) {
        var client = clientService.getByCPF(cpf);
        if(client.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(client);
    }

}
