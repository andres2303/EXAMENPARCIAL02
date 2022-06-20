package examen.daoImpl;

import examen.config.Conexion;
import examen.dao.UsuarioDao;
import examen.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioDaoImpl implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

@Override
    public List<Map<String, Object>> readAll() {
        String SQL = "select l.idusuario, c.apellidos from  usuario l,  persona c, empleado r where l.idempleado=r.idempleado and r.idpersonas=c.idpersonas";
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> recorr = new HashMap<>();
                recorr.put("idusuario", rs.getInt("idusuario"));
                recorr.put("Apellidos", rs.getString("apellidos"));
                list.add(recorr);

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }




















}

    /*@Override
    public List<Usuario> readAll() {
        String SQL = "select * from usuario";
        List<Usuario> usuarioss = new ArrayList<>();

        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEstado(rs.getBoolean("estado"));
                usuario.setIdrol(rs.getInt("idrol"));
                usuario.setIdempleado(rs.getInt("idempleado"));

                usuarioss.add(usuario);
            }
        } catch (SQLException a) {
            System.out.println("ERROR: " + a);
        }
        return usuarioss;
    }
*/
