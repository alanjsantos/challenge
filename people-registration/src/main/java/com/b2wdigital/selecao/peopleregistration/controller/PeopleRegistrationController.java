package com.b2wdigital.selecao.peopleregistration.controller;

import com.b2wdigital.selecao.peopleregistration.model.People;
import com.b2wdigital.selecao.peopleregistration.request.PeopleRequest;
import com.b2wdigital.selecao.peopleregistration.service.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleRegistrationController {

    @Autowired
    public PeopleService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<PeopleRequest> register(@Valid @RequestBody PeopleRequest request) {
        People people = service.register(modelMapper.map(request, People.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(people, PeopleRequest.class));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<People>> list(@Valid Pageable pageable) {
        Page<People> body = service.list(pageable);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleRequest> get(@Valid @PathVariable Integer id) {
        People people = service.findById(id);
        PeopleRequest body = modelMapper.map(people, PeopleRequest.class);

        return ResponseEntity.ok(body);
    }
}
