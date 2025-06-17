package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<List<Usuario>> acharTodosUsuarios(){
        List<Usuario> usuarioList = usuarioService.acharTodosUsuarios();
        if (usuarioList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioList);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Usuario> acharUsuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.acharPorId(id);
        if (usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    private ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.criarUsuario(usuario);
        if (usuario1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario1);
    }

    @PutMapping("/ADMIN/{id}/alterar")
    private ResponseEntity<Usuario> modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.modificarUsuario(id,usuario);
        if (usuario1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario1);

    }

    @DeleteMapping("/{id}")
    private void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }

}
