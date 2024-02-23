/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.service;

import Libreria.dao.LibroDAO;
import Libreria.dao.LibroImplDAO;
import Libreria.model.Libro;

/**
 *
 * @author usuaria
 */
public class LibroService {
    private final LibroDAO ld;

    public LibroService() {
        this.ld = new LibroImplDAO();
    }
    
    public Libro createLibro(Libro libro) {
        ld.createLibro(libro);
        return libro;
    }
    
}
