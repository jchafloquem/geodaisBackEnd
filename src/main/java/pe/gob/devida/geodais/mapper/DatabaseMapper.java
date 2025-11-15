package pe.gob.devida.geodais.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DatabaseMapper {

    @Select("SELECT SYSDATE FROM DUAL")
    String getOracleServerTime();
}