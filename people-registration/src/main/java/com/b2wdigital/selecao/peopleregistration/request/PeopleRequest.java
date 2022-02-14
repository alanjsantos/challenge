package com.b2wdigital.selecao.peopleregistration.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeopleRequest {

    @NotBlank(message = "Campo obrigatório.")
    @Size(min = 3, max = 80, message = "O campo NAME deve ter 3 a 80 caracteres.")
    private String name;

    @Email(message = "Email incorreto.")
    @NotBlank(message = "Campo obrigatório.")
    private String email;

    @CPF(message = "CPF incorreto.")
    private String cpf;

    private Integer age;
    private String gender;

}
