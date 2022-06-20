package examen.daoImpl;

import examen.config.Conexion;
import examen.dao.ProductoDao;
import examen.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public List<Producto> readAll() {

        String sql = "select * from producto";

        List<Producto> productos = new ArrayList<>();

        try {

            cx = Conexion.getConexion();
            ps = cx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();

                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setIdcategoria(rs.getInt("idcategoria"));

                productos.add(producto);

            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return productos;

    }

    @Override
    public int create(Producto producto) {

        String sql = "insert into productos(nombre, precio, stock, estado, idcategoria) values(?,?,?,?,?)";
        int respuesta = 0;

        try {

            cx = Conexion.getConexion();
            ps = cx.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setBoolean(4, producto.getEstado());
            ps.setInt(5, producto.getIdcategoria());

            respuesta = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return respuesta;

    }

}
