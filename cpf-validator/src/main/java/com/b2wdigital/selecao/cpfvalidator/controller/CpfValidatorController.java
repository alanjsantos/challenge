package com.b2wdigital.selecao.cpfvalidator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("")
public class CpfValidatorController {

    @GetMapping("/{cpf}")
    public boolean isValid(@PathVariable String cpf) {
        Pattern p = Pattern.compile("([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");
        return p.matcher(cpf).matches();
    }
}
