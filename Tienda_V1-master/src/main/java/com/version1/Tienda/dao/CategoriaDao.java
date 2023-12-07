package com.version1.Tienda.dao;

import com.version1.Tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


//Se envia toda la informacion de Categoria (o la tabla que se use) a la interfaz CategoriaDao
public interface CategoriaDao extends JpaRepository <Categoria, Long> {
    
}
