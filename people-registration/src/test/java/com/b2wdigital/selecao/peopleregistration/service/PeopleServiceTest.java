package com.b2wdigital.selecao.peopleregistration.service;

import com.b2wdigital.selecao.peopleregistration.model.People;
import com.b2wdigital.selecao.peopleregistration.repository.PeopleRepository;
import com.b2wdigital.selecao.peopleregistration.service.exception.ObjectNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PeopleServiceTest {

    @MockBean
    private PeopleRepository repository;

    @SpyBean
    private PeopleService service;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void peopleSaveSuccess() {
        People p = People.builder()
                .id(1)
                .name("ALAN SANTOS")
                .email("alansantos@gmail.com")
                .cpf("11278230432")
                .age(null)
                .gender("MASCULINO")
                .build();

        when(repository.save(any())).thenReturn(p);
        service.register(p);

    }

    @Test
    public void peopleFindByIdSuccess() {
        People p = People.builder()
                .id(1)
                .name("ALAN SANTOS")
                .email("alansantos@gmail.com")
                .cpf("11278230432")
                .age(null)
                .gender("MASCULINO")
                .build();

        when(repository.findById(p.getId())).thenReturn(Optional.of(p));
        Optional<People> result = Optional.ofNullable(service.findById(p.getId()));
        Assertions.assertThat(result.isPresent()).isTrue();
    }

    @Test
    public void peopleFindByIdException() {
        People p = People.builder()
                .id(1)
                .name("ALAN SANTOS")
                .email("alansantos@gmail.com")
                .cpf("11278230432")
                .age(null)
                .gender("MASCULINO")
                .build();

        Assertions.catchThrowableOfType(() -> service.findById(2), ObjectNotFoundException.class);
        verify(repository, Mockito.never()).findById(p.getId());
    }
}
