package poc.sergio.gonzalez.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import poc.sergio.gonzalez.productos.entity.Categoria;
import poc.sergio.gonzalez.productos.entity.Producto;
import poc.sergio.gonzalez.productos.repository.ProductoRepository;

@DataJpaTest
public class ProductoRepositoryMockTest {

    @Autowired
    private ProductoRepository productoRepository;

    public void whenFindByCategory_thenReturnListProductos() {
        Producto producto1 = Producto.builder()
                .producto("Computador")
                .descripcion("Buen compu")
                .categoria(Categoria.builder().id(1L).build())
                .precio(Double.parseDouble("12.5"))
                .cantidad(Double.parseDouble("5"))
                .build();

        productoRepository.save(producto1);

        List<Producto> productosCategoria = productoRepository.findByCategoria(producto1.getCategoria());
    }
}
