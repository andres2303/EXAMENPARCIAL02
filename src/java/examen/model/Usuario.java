package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    private int idusuario;
    private String username;
    private String password;
    private Boolean estado;
    private int idrol;
    private int idempleado;
}
