package ciclo3.mvc.service;

import ciclo3.mvc.entities.*;

import java.util.List;

public interface ITipoDocumentoService {
    public TipoDocumento findById(int id);

    public List<TipoDocumento> findAll();

    public TipoDocumento createRol(TipoDocumento doc);

    public TipoDocumento updateRol(int id,TipoDocumento doc);

    public void deleteTipoDocumento(int id);
}
