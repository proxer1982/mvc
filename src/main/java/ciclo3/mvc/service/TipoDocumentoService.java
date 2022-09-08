package ciclo3.mvc.service;

import ciclo3.mvc.entities.*;
import ciclo3.mvc.repositories.ITipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoService implements ITipoDocumentoService {
    @Autowired
    private ITipoDocumentoRepository tipoDocumentoRepository;
    @Override
    public TipoDocumento findById(int id) {
        Optional<TipoDocumento> docs = tipoDocumentoRepository.findById((long) id);
        return docs.get();
    }

    @Override
    public List<TipoDocumento> findAll(){
        List<TipoDocumento> documentos = (List<TipoDocumento>) tipoDocumentoRepository.findAll();
        return documentos;
    }

    @Override
    public TipoDocumento createRol(TipoDocumento doc){
       return tipoDocumentoRepository.save(doc);
    }

    @Override
    public TipoDocumento updateRol(int id, TipoDocumento doc){
        return tipoDocumentoRepository.save(doc);
    }

    @Override
    public void deleteTipoDocumento(int id){
        tipoDocumentoRepository.deleteById((long) id);
    }
}
