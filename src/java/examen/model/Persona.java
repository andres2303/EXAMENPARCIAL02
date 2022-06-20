package examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
     private int idpersona;
   private String nombres;
   private String apellidos;
   private char dni;
   private char telefono;
}
