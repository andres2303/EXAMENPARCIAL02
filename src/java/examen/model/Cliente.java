package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    private int idclientes;
    private String direccion;
    private String hobby;
    private int idpersonas;
}
