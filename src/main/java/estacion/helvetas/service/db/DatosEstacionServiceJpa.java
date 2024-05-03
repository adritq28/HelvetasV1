package estacion.helvetas.service.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import estacion.helvetas.model.DatosEstacion;
import estacion.helvetas.repository.DatosEstacionRepository;
import estacion.helvetas.services.IDatosEstacion;

@Service
@Primary
public class DatosEstacionServiceJpa implements IDatosEstacion {

    @Autowired
    private DatosEstacionRepository datosEstacionRepo;

    @Override
    public DatosEstacion buscarPorIdDatosEstacion(int idDatosEstacion) {
        Optional<DatosEstacion> datosEstacion = datosEstacionRepo.findById(idDatosEstacion);
        return datosEstacion.get();
    }

    @Override
    public void guardar(DatosEstacion estacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public void eliminarDatosEstacionId(int idDatosEstacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarDatosEstacionId'");
    }

    @Override
    public void deleteDatosEstacion(int idDatosEstacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDatosEstacion'");
    }

    public DatosEstacion obtenerDatosEstacionPorId(int id) {
        Optional<DatosEstacion> datosEstacionOptional = datosEstacionRepo.findById(id);
        return datosEstacionOptional.orElse(null);
    }

    public void guardarDatosEstacion(DatosEstacion datosEstacion) {
        datosEstacionRepo.save(datosEstacion);
    }

}