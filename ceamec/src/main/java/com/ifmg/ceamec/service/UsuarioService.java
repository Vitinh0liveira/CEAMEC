package com.ifmg.ceamec.service;

import com.ifmg.ceamec.model.Usuario;
import com.ifmg.ceamec.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void criarNovoUsuario(Usuario usuario, String senhaPura) {
        // Criptografa a senha antes de salvar no banco de dados
        usuario.setSenhaHash(passwordEncoder.encode(senhaPura));
        usuarioRepository.save(usuario);
    }
}
