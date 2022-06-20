package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rol {
     private int idrol;
    private String nombre;
    private Boolean estado;
}
