package com.version1.Tienda.dao;

import com.version1.Tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//Se envia toda la informacion de Producto (o la tabla que se use) a la interfaz ProductoDao
public interface ProductoDao extends JpaRepository<Producto, Long> {

    //Consulta tipo JPA
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Consulta JPQL
    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
