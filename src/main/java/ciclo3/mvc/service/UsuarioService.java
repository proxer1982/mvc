package ciclo3.mvc.service;

import ciclo3.mvc.entities.*;
import ciclo3.mvc.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public Usuario findById(int id){
        Optional<Usuario> usuarios = usuarioRepository.findById((long) id);

        return usuarios.get();
    }

    @Override
    public List<Usuario> findAll(){
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();

        return usuarios;
    }

    @Override
    public Usuario createUser(Usuario user){
        return usuarioRepository.save(user);
    }

    @Override
    public Usuario updateUser(int id, Usuario user){
        return usuarioRepository.save(user);
    }

    @Override
    public void deleteUser(int id){
        usuarioRepository.deleteById((long) id);
    }
}
