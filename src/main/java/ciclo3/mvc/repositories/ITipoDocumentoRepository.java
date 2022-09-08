package ciclo3.mvc.repositories;


import ciclo3.mvc.entities.TipoDocumento;
import org.springframework.data.repository.CrudRepository;

public interface ITipoDocumentoRepository extends CrudRepository<TipoDocumento, Long> {
}
