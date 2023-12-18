package poc.sergio.gonzalez.productos.controller;

import org.springframework.web.bind.annotation.RestController;

import poc.sergio.gonzalez.productos.entity.Producto;
import poc.sergio.gonzalez.productos.service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService; 

    @GetMapping    
    public ResponseEntity<List<Producto>> listProductos(){
        List<Producto> productos = productoService.listAllProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }
}
