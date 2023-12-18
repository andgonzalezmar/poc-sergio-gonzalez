package poc.sergio.gonzalez.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import poc.sergio.gonzalez.productos.entity.Categoria;
import poc.sergio.gonzalez.productos.entity.Producto;
import poc.sergio.gonzalez.productos.repository.ProductoRepository;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Producto validarProducto = getProducto(producto.getId());
        if(validarProducto == null){
            return null;
        }
        validarProducto.setProducto(producto.getProducto());
        validarProducto.setDescripcion(producto.getDescripcion());
        validarProducto.setPrecio(producto.getPrecio());

        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findByCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public Producto updateCantidad(Long id, Double cantidad) {
        Producto validarProducto = getProducto(id);
        if(validarProducto == null){
            return null;
        }
        Double cantidadTotal = validarProducto.getCantidad() + cantidad;
        validarProducto.setCantidad(cantidadTotal);

        return productoRepository.save(validarProducto);
    }
    
}
