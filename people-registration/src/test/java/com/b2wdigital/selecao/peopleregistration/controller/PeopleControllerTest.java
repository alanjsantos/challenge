package com.b2wdigital.selecao.peopleregistration.controller;

import com.b2wdigital.selecao.peopleregistration.model.People;
import com.b2wdigital.selecao.peopleregistration.request.PeopleRequest;
import com.b2wdigital.selecao.peopleregistration.service.PeopleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PeopleRegistrationController.class)
@AutoConfigureMockMvc
public class PeopleControllerTest {
    private static MediaType JSON = MediaType.APPLICATION_JSON;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PeopleService service;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void peopleSaveSuccess() throws Exception {
         String path = "/people/register";

        PeopleRequest dto = PeopleRequest.builder()
                .name("ALAN SANTOS")
                .email("alansantos@gmail.com")
                .cpf("50263940004")
                .age(1993)
                .gender("MASCULINO")
                .build();

        People p = People.builder()
                .name("ALAN SANTOS")
                .email("alansantos@gmail.com")
                .cpf("50263940004")
                .age(1993)
                .gender("MASCULINO")
                .build();
        when(service.register(p)).thenReturn(p);
        mvc.perform(MockMvcRequestBuilders.post(path)
                .contentType(JSON)
                .content(asJsonString(dto)))
                        .andExpect(status().isCreated());

    }

    @Test
    public void peopleFindByIdSuccess() throws Exception {
        String path = "/people/";

        Integer id = 1;
        PeopleRequest dto = PeopleRequest.builder()
                .name("ALAN SANTOS")
                .email("alansantos@gmail.com")
                .cpf("50263940004")
                .age(1993)
                .gender("MASCULINO")
                .build();

        People p = People.builder()
                .name("ALAN SANTOS")
                .email("alansantos@gmail.com")
                .cpf("50263940004")
                .age(1993)
                .gender("MASCULINO")
                .build();
        when(service.findById(id)).thenReturn(p);
        mvc.perform(MockMvcRequestBuilders.get(path + id)
                        .contentType(JSON)
                        .content(asJsonString(dto)))
                .andExpect(status().isOk());

    }
}
