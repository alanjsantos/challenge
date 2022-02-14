package com.b2wdigital.selecao.peopleregistration.service;

import com.b2wdigital.selecao.peopleregistration.model.People;
import com.b2wdigital.selecao.peopleregistration.repository.PeopleRepository;
import com.b2wdigital.selecao.peopleregistration.service.exception.BadRequestException;
import com.b2wdigital.selecao.peopleregistration.service.exception.DbException;
import com.b2wdigital.selecao.peopleregistration.service.exception.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Service
public class PeopleService {

    @Autowired
    public PeopleRepository repository;

    @Value("${mailer.username}")
    public String mailerUsername;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ms-cpf-validator.path}")
    private String baseUrl;

    @Transactional
    public People register(People people) {
            isValidCpf(people);
            repository.save(people);
            log.info("Dado salvo com sucesso!");

        return people;
    }

    public People findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("O ID " + id + " não se encontra na base de dados."));
    }

    public Page<People> list(Pageable pageable) {

        return repository.findAll(pageable);
    }

    private void isValidCpf (People people) {
        log.info("Chamando API cpf-validator");
        ResponseEntity<Boolean> response = restTemplate
                .exchange(baseUrl + people.getCpf(), HttpMethod.GET,null, Boolean.class);

        if(Objects.nonNull(response)  && !response.getBody()) {
            throw new BadRequestException("Erro ao chamar a API cpf-validator");
        }
    }
}
