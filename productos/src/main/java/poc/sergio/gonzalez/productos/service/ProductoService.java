package poc.sergio.gonzalez.productos.service;

import java.util.List;


import poc.sergio.gonzalez.productos.entity.Categoria;
import poc.sergio.gonzalez.productos.entity.Producto;

public interface ProductoService {
    public List<Producto> listAllProductos();

    public Producto getProducto(Long id);

    public Producto createProducto(Producto producto);

    public Producto updateProducto(Producto producto);

    //public Producto deleteProducto(Long id);

    public List<Producto> findByCategoria(Categoria categoria);

    public Producto updateCantidad(Long id, Double cantidad);
}
