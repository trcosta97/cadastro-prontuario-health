package com.telemedicina.pre_cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaginasController {

    @GetMapping("/login-page")  // Mudei para /login-page para evitar conflito com /login ou /token
    public String paginaLogin() {
        return "login";  // Renderiza o template Thymeleaf 'login.html'
    }

    @GetMapping("/home")
    public String paginaHome() {
        return "home";  // Renderiza o template Thymeleaf 'home.html'
    }

    @GetMapping("/cadastro-paciente")
    public String cadastroPaciente() {
        return "cadastro-paciente";  // Renderiza o template 'cadastro-paciente.html'
    }

    @GetMapping("/novo-prontuario")
    public String novoProntuario() {
        return "novo-prontuario";  // Renderiza o template 'novo-prontuario.html'
    }

    @GetMapping("/completar-cadastro")
    public String updateCadastro() {
        return "update-cadastro";  // Renderiza o template 'update-cadastro.html'
    }

    @GetMapping("/prontuario/{id}")
    public String prontuario(@PathVariable(required = false) Long id) {
        if (id == null) {
            // Redirecionar para a lista de prontuários ou página de erro
            return "redirect:/todos-prontuarios";
        }
        return "prontuario";
    }


    @GetMapping("/todos-prontuarios")
    public String todosProntuarios() {
        return "todos-prontuarios";
    }
}