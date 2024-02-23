/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.dao;

import Libreria.model.Libro;
import Libreria.model.Persona;
import java.util.List;

/**
 *
 * @author usuaria
 */
public interface PersonaDAO {

    void createPersona(Persona persona);

    void updatePersona(Persona persona);

    List<Libro> getLibrosLeidosByPersona(Persona persona);

}
