package io.github.ranonemerick.msclients.application.representation;

import io.github.ranonemerick.msclients.domain.Client;

public record ClientSaveRequest(String cpf,
                                String name,
                                Integer age) {

    public Client toModel() {
        return new Client(cpf, name, age);
    }
}
