package ciclo3.mvc.repositories;


import ciclo3.mvc.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
}
