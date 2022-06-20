/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examen.dao;

import examen.model.Cliente;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface ClienteDao {
   List<Map<String, Object>> readAll();
}
