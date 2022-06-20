package examen.daoImpl;

import examen.config.Conexion;
import examen.dao.VentaDao;
import examen.model.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VentaDaoImpl implements VentaDao {

 private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;



    @Override
    public List<Venta> readAll() {

        String SQL = "select * from venta";

        List<Venta> ventas = new ArrayList<>();

        try {

            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {

                Venta venta = new Venta();

                venta.setIdventa(rs.getInt("idventa"));
                venta.setFecha(rs.getString("fecha"));
                venta.setIdcliente(rs.getInt("idclientes"));
                venta.setIdsucursal(rs.getInt("idsucursal"));
                venta.setIdusuario(rs.getInt("idusuario"));
                ventas.add(venta);

            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return ventas;

    }

    @Override
    public int create(Venta venta) {

        String SQL = "insert into venta(fecha, idclientes, idsucursal, idusuario) values(now(),?,?,?)";
        int respuesta = 0;

        try {

            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);

            ps.setString(1, venta.getFecha());
            ps.setInt(2, venta.getIdcliente());
            ps.setInt(3, venta.getIdsucursal());
            ps.setInt(4, venta.getIdusuario());


            respuesta = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return respuesta;

    }
}
