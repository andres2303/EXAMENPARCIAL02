package examen.dao;

import examen.model.Usuario;
import java.util.List;
import java.util.Map;

public interface UsuarioDao {

    List<Map<String, Object>> readAll();
}
