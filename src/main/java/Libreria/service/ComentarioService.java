/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.service;

import Libreria.dao.ComentarioDAO;
import Libreria.dao.ComentarioImplDAO;
import Libreria.model.Comentario;
import Libreria.model.Libro;
import Libreria.model.Persona;

/**
 *
 * @author usuaria
 */
public class ComentarioService {

    private final ComentarioDAO cd;

    public ComentarioService() {
        this.cd = new ComentarioImplDAO();
    }

    public Comentario createComentario(Comentario comentario) {
        if (comentario.getValoracion() < 0 || comentario.getValoracion() > 5) {
            throw new IllegalArgumentException("La valoración debe estar en el rango de 0 a 5");
        }
        cd.createComentario(comentario);
        return comentario;
    }

    public void addComentario(Persona persona, Libro libro, Comentario comentario) {
        comentario.setAutor(persona);
        persona.getComentarios().add(comentario);
        comentario.setLibro(libro);
        libro.getComentarios().add(comentario);
        cd.updateComentario(comentario);
        
    }
    
}
