package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sucursal {

    private int idsucursal;
    private String nombre;
    private String direccion;
    private Boolean estado;
}
