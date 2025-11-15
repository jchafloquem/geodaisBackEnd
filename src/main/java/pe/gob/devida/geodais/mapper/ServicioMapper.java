package pe.gob.devida.geodais.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pe.gob.devida.geodais.model.Servicio; 

@Mapper 
public interface ServicioMapper {

    @Select("SELECT ID, NOMBRE, URL, ESTADO FROM T_SERVICIO WHERE NOMBRE = #{nombre} AND ESTADO = 'ACTIVO'")
    Servicio findByNombre(String nombre);
}