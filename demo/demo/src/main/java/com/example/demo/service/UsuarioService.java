package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username);
    }

    public List<Usuario> acharTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario acharPorId(Long usuarioId){
        return usuarioRepository.findById(usuarioId).get();
    }

    public Usuario criarUsuario (Usuario usuarioNovo){
        return usuarioRepository.save(usuarioNovo);
    }

    public Usuario modificarUsuario(Long id, Usuario usuario){
        Usuario usuario1 = acharPorId(id);
        usuario1.setRole(usuario.getRole());
        usuario1.setPassword(usuario.getPassword());
        usuario1.setLogin(usuario.getUsername());

        return usuarioRepository.save(usuario1);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
