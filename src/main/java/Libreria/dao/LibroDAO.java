/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.dao;

import Libreria.model.Libro;
import java.util.List;

/**
 *
 * @author usuaria
 */
public interface LibroDAO {
    
    void createLibro(Libro libro);
    
    List<Libro> getAllLibros();
    
}
