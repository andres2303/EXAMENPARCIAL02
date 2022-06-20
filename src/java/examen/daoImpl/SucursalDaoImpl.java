package examen.daoImpl;

import examen.config.Conexion;
import examen.dao.SucursalDao;
import examen.model.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDaoImpl implements SucursalDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public List<Sucursal> readAll() {
        String SQL = "select idsucursal, nombre from sucursal";
        List<Sucursal> sucursales = new ArrayList<>();

        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sucursal sucursals = new Sucursal();

                sucursals.setIdsucursal(rs.getInt("idsucursal"));
                sucursals.setNombre(rs.getString("nombre"));
                sucursales.add(sucursals);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return sucursales;
    }
}
