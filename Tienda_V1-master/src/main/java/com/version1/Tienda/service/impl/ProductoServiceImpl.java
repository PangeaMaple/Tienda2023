
package com.version1.Tienda.service.impl;

import com.version1.Tienda.dao.ProductoDao;
import com.version1.Tienda.domain.Producto;
import com.version1.Tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    //Consulta JPA para traer info sobre precio inferior y superior 
    @Override
    @Transactional(readOnly=true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    //Consulta JPQL para traer info sobre precio inferior y superior 
    @Override
    @Transactional(readOnly=true)
    public List<Producto> metodoJPQL(double precioInf, double precioSup){
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
     //Consulta nativo para traer info sobre precio inferior y superior 
    @Override
    @Transactional(readOnly=true)
    public List<Producto> metodoNativo(double precioInf, double precioSup){
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
}
