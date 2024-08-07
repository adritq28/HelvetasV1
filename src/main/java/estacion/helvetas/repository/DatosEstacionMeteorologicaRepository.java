package estacion.helvetas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import estacion.helvetas.model.DatosEstacionMeteorologica;

public interface DatosEstacionMeteorologicaRepository extends JpaRepository<DatosEstacionMeteorologica, Integer> {

        Optional<DatosEstacionMeteorologica> findByIdDatosEst(Integer id);

        // Optional<DatosEstacion> obtenerDatosEstacionPorId(int id);
        // Optional<DatosEstacionDTO> datosId(int id);

        @Query("SELECT t1.idUsuario AS id, t5.nombre AS municipio, t3.nombre AS nombreEstacion, t3.tipoEstacion, " +
                        "CONCAT(t1.nombre, ' ', t1.apePat, ' ', COALESCE(t1.apeMat, '')) AS nombreCompleto, t4.fechaReg, "
                        +
                        "t4.tempMin, t4.tempMax, t4.tempAmb, t4.pcpn, t4.taevap, t4.dirViento, t4.velViento, t3.idEstacion, t3.codTipoEstacion "
                        +
                        "FROM Usuario t1 " +
                        "JOIN Observador t2 ON t1.idUsuario = t2.idUsuario " +
                        "JOIN Estacion t3 ON t2.idEstacion = t3.idEstacion " +
                        "JOIN DatosEstacionMeteorologica t4 ON t3.idEstacion = t4.idEstacion " +
                        "JOIN Municipio t5 ON t3.idMunicipio = t5.idMunicipio " +
                        "WHERE t1.idUsuario = :idUsuario order by t4.idDatosEst desc")

        List<Object[]> obtenerDatosEstacion(@Param("idUsuario") int idUsuario);

        // List<DatosEstacionDTO> obtenerDatos();
        @Query("SELECT t5.idMunicipio AS id, t5.nombre AS municipio, t3.nombre AS nombreEstacion, t3.tipoEstacion, " +
                        "CONCAT(t1.nombre, ' ', t1.apePat, ' ', COALESCE(t1.apeMat, '')) AS nombreCompleto, t4.fechaReg, "
                        +
                        "t4.tempMin, t4.tempMax, t4.tempAmb, t4.pcpn, t4.taevap, t4.dirViento, t4.velViento, t3.idEstacion, t3.codTipoEstacion "
                        +
                        "FROM Usuario t1 " +
                        "JOIN Observador t2 ON t1.idUsuario = t2.idUsuario " +
                        "JOIN Estacion t3 ON t2.idEstacion = t3.idEstacion " +
                        "JOIN DatosEstacionMeteorologica t4 ON t3.idEstacion = t4.idEstacion " +
                        "JOIN Municipio t5 ON t3.idMunicipio = t5.idMunicipio " +
                        "WHERE t5.idMunicipio = :idMunicipio")

        List<Object[]> obtenerDatosMunicipio(@Param("idMunicipio") int idMunicipio);

        @Query("SELECT t1.idUsuario AS id, t5.nombre AS municipio, t3.nombre AS nombreEstacion, t3.tipoEstacion, " +
                        "CONCAT(t1.nombre, ' ', t1.apePat, ' ', COALESCE(t1.apeMat, '')) AS nombreCompleto, t4.fechaReg, "
                        +
                        "t4.tempMin, t4.tempMax, t4.tempAmb, t4.pcpn, t4.taevap, t4.dirViento, t4.velViento, t3.idEstacion, t3.codTipoEstacion "
                        +
                        "FROM Usuario t1 " +
                        "JOIN Observador t2 ON t1.idUsuario = t2.idUsuario " +
                        "JOIN Estacion t3 ON t2.idEstacion = t3.idEstacion " +
                        "JOIN DatosEstacionMeteorologica t4 ON t3.idEstacion = t4.idEstacion " +
                        "JOIN Municipio t5 ON t3.idMunicipio = t5.idMunicipio " +
                        "WHERE t3.idEstacion = :idEstacion")

        List<Object[]> obtenerEstacion(@Param("idEstacion") int idEstacion);

}
