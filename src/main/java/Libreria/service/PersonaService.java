/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.service;

import Libreria.dao.PersonaDAO;
import Libreria.dao.PersonaImplDAO;
import Libreria.model.Libro;
import Libreria.model.Persona;

/**
 *
 * @author usuaria
 */
public class PersonaService {

    private final PersonaDAO pd;

    public PersonaService() {
        this.pd = new PersonaImplDAO();
    }

    public Persona createPersona(Persona persona) {
        pd.createPersona(persona);
        return persona;
    }

    public void addLibroLeido(Persona persona, Libro libro) {
        persona.getLibrosLeidos().add(libro);
        pd.updatePersona(persona);
    }
    public void addLibroEscrito(Persona persona, Libro libro) {
        persona.getLibrosEscritos().add(libro);
        pd.updatePersona(persona);
    }
   
}
