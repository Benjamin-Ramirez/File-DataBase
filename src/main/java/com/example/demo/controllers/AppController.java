package com.example.demo.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Product;
import com.example.demo.services.Servicios;

@Controller
public class AppController {
	
	@Autowired
	private Servicios service;

	@GetMapping("/")
	public String dashboard(@ModelAttribute("admin") Product producto) {
		return "admin.jsp";
	}
	
	
	@PostMapping("/crear/img")
    public String guardar(@Valid @ModelAttribute("admin") Product producto, @RequestParam("file") MultipartFile imagen) {
		
		
        if (!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src/main/resources/static/images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "/" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                
                producto.setImg(imagen.getOriginalFilename());
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        service.save(producto);
        return "redirect:/";
    }
	
	
	
}
