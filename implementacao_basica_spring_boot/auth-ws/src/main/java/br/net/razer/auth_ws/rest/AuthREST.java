package br.net.razer.auth_ws.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.net.razer.auth_ws.model.Login;
import br.net.razer.auth_ws.model.Usuario;

@CrossOrigin
@RestController
public class AuthREST {

    @PostMapping("/login")
    ResponseEntity<Usuario> login(@RequestBody Login login) {
// BD para verificar o login/senha
        if (login.getLogin().equals(login.getSenha())) {
            Usuario usu = new Usuario(1, login.getLogin(), login.getLogin(), "XXX", "ADMIN");
            return ResponseEntity.ok().body(usu);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
