package com.formacionbdi.springboot.app.productos.services;

import java.util.List;

import com.formacionbdi.springboot.app.productos.entities.Producto;

public interface IProductoService {
	
	public List<Producto> allProducts();
	
	public Producto getProduct(Long id);	
	
}
