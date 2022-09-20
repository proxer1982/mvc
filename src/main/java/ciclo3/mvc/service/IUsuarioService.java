package ciclo3.mvc.service;

import ciclo3.mvc.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public Usuario findById(int id);

    public List<Usuario> findAll();

    public Usuario createUser(Usuario user);

    public Usuario updateUser(int id, Usuario user);

    public void deleteUser(int id);
}
