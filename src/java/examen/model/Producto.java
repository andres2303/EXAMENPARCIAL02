package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Producto {

    private int idproducto;
    private String nombre;
    private Float precio;
    private int stock;
    private Boolean estado;
    private int idcategoria;

}
