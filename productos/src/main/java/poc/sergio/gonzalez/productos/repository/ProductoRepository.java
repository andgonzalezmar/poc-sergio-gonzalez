package poc.sergio.gonzalez.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.sergio.gonzalez.productos.entity.Categoria;
import poc.sergio.gonzalez.productos.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    public List<Producto> findByCategoria(Categoria categoria);
}
