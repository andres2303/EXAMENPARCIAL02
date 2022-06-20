package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // contiene el get y set, to string y mas cosas...
@AllArgsConstructor
@NoArgsConstructor

public class Categoria {
      private Integer idcategoria;
    private String nombre;
    private Boolean estado;
}
