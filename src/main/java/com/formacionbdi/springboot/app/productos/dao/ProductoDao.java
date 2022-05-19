package com.formacionbdi.springboot.app.productos.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.productos.entities.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{
    
}
