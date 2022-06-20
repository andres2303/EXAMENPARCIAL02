package examen.daoImpl;

import examen.config.Conexion;
import examen.dao.ClienteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteDaoImpl implements ClienteDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public List<Map<String, Object>> readAll() {
        String SQL = "select c.idclientes, x.apellidos from cliente c inner join persona x on c.idpersonas=x.idpersonas";
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> recorr = new HashMap<>();
                recorr.put("idclientes", rs.getInt("idclientes"));
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

    public List<Cliente> readAll() {
        String SQL = "select c.idclientes, x.apellidos from cliente c inner join persona x on c.idpersonas=x.idpersonas ";

        List<Cliente> clientes = new ArrayList<>();
        try {

            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {

                Cliente client = new Cliente();
                client.setIdclientes(rs.getInt("idclientes"));
                client.setDireccion(rs.getString("direccion"));
                client.setHobby(rs.getString("hobby"));
                client.setIdpersonas(rs.getInt("idpersonas"));
                clientes.add(client);

            }
        } catch (SQLException a) {
            System.out.println("ERROR : " + a);
        }
        return clientes;
    }

     */

