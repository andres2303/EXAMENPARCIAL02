package examen.daoImpl;

import examen.config.Conexion;
import examen.dao.CasoDao;
import examen.daoImpl.CasoDaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasoDaoImpl implements CasoDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public List<Integer> ListIds() {
        String SQL = "select * from ventas";

        List<Integer> lista = new ArrayList<>();
        try {

            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(rs.getInt("idventa"));

            }
        } catch (SQLException a) {
            System.out.println("ERROR : " + a);
        }
        return lista;
    }

    @Override
    public List<Map<String, Object>> readAllcaso(int id) {
        String SQL = "";
        List<Map<String, Object>> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Map<String, Object>>  map = new HashMap<>();
                //map.put("iddetalle", rs.getInt("iddetalle"));
            }
        } catch (SQLException a) {
            System.out.println("ERROR : " + a);
        }
        return lista;
    }
}
