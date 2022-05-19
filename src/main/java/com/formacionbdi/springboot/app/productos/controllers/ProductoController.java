package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.entities.Producto;
import com.formacionbdi.springboot.app.productos.services.ProductoServiceImpl;

@RestController
public class ProductoController {
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	private ProductoServiceImpl productServiceImpl;
	
	@GetMapping( "/listar" )
	public List<Producto> products(){
		return productServiceImpl.allProducts().stream().map(producto -> {
			producto.setPort( port );
			return producto;
		}).collect( Collectors.toList() );
	}
	
	@GetMapping( "/ver/{id}" )
	public Producto findProductById ( @PathVariable Long id ){
		
		Producto producto = productServiceImpl.getProduct(id);
		producto.setPort( port );
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return producto;
	}
	
	
	

}
