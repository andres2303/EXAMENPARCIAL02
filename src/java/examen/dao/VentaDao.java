package examen.dao;

import examen.model.Venta;
import java.util.List;

public interface VentaDao {

    List<Venta> readAll();

    int create(Venta venta);

}
