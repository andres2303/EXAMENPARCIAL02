package examen.daoImpl;

import examen.config.Conexion;
import examen.dao.CategoriaDao;
import examen.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDaoImpl implements CategoriaDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx = null;

    @Override

    public List<Categoria> readAll() {
        String SQL = "select * from cliente";

        List<Categoria> categorias = new ArrayList<>();
        try {

            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {

                Categoria cat = new Categoria();
                cat.setIdcategoria(rs.getInt("idcategoria"));
                cat.setNombre(rs.getString("nombre"));
                cat.setEstado(rs.getBoolean("estado"));
                categorias.add(cat);

            }
        } catch (SQLException a) {
            System.out.println("ERROR : " + a);
        }
        return categorias;
    }

}
