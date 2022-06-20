package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Detalle {
       private int iddetalles;
    private Float precio;
    private int cantidad;
    private int idventa;
    private int idproducto;

}
