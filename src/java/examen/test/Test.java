package examen.test;

import examen.config.Conexion;
import examen.dao.ProductoDao;
import examen.daoImpl.ProductoDaoImpl;
import com.google.gson.Gson;
import examen.dao.ClienteDao;
import examen.dao.SucursalDao;
import examen.dao.UsuarioDao;
import examen.dao.VentaDao;
import examen.daoImpl.ClienteDaoImpl;
import examen.daoImpl.SucursalDaoImpl;
import examen.daoImpl.UsuarioDaoImpl;
import examen.daoImpl.VentaDaoImpl;

public class Test {

    // static Gson g = new Gson();
    static ClienteDao clienteDao = new ClienteDaoImpl();
    static ProductoDao productoDao = new ProductoDaoImpl();
    static UsuarioDao usuarioDao = new UsuarioDaoImpl();
    static SucursalDao sucursalDao = new SucursalDaoImpl();
    static VentaDao ventaDao = new VentaDaoImpl();
    static Gson gson = new Gson();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        if (Conexion.getConexion() != null) {
            System.out.println("dale paaaaa");
        } else {
            System.out.println("nou :(");
        }
        System.out.println(gson.toJson(clienteDao.readAll()));
        System.out.println(gson.toJson(usuarioDao.readAll()));
        System.out.println(gson.toJson(productoDao.readAll()));
        System.out.println(gson.toJson(sucursalDao.readAll()));
        System.out.println(gson.toJson(ventaDao.readAll()));
    }
}
