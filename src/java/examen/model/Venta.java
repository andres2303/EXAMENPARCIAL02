package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Venta {

    private int idventa;
    private String fecha;
    private int idcliente;
    private int idusuario;
    private int idsucursal;
}
