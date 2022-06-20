package examen.dao;

import examen.model.Producto;
import java.util.List;

public interface ProductoDao {

    List<Producto> readAll();

    int create(Producto producto);
}
