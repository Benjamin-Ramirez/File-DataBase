package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repositories.RepositorioProductos;

@Service
public class Servicios {

	@Autowired
	private RepositorioProductos repositorio_productos;
	
	public Product save(Product producto) {
		return repositorio_productos.save(producto);
	}
	
}
