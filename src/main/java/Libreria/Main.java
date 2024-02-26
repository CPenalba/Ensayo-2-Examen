/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

import Libreria.dao.LibroImplDAO;
import Libreria.dao.PersonaImplDAO;
import Libreria.model.Comentario;
import Libreria.model.Libro;
import Libreria.model.Persona;
import Libreria.service.ComentarioService;
import Libreria.service.LibroService;
import Libreria.service.PersonaService;
import java.util.List;

/**
 *
 * @author usuaria
 */
public class Main {

    public static void main(String[] args) {
        PersonaService ps = new PersonaService();
        PersonaImplDAO pid = new PersonaImplDAO();
        LibroService ls = new LibroService();
        LibroImplDAO lid = new LibroImplDAO();
        ComentarioService cs = new ComentarioService();

        Persona p1 = new Persona("Carolina", "carolina.penalba", "penalba12", "carolina@gmail.com");
        ps.createPersona(p1);

        Libro l1 = new Libro("El Quijote", 134);
        ls.createLibro(l1);

        Comentario c1 = new Comentario(5, "Muy bueno");
        cs.createComentario(c1);

        Libro l2 = new Libro("Culpa mia", 45);
        Persona p2 = new Persona("Maisaa", "maisaa.aharti", "maissa123", "maissa@gmail.com");
        ps.addLibroEscrito(p1, l2);
        ps.addLibroEscrito(p1, l1);
        ps.addLibroEscrito(p1, l2);
        ps.addLibroEscrito(p2, l2);

        ps.addLibroLeido(p2, l2);
        ps.addLibroLeido(p2, l1);
        ps.addLibroLeido(p1, l2);
        ps.addLibroLeido(p2, l2);

        Comentario c2 = new Comentario(3, "No me ha gustado");
        cs.addComentario(p1, l1, c2);

        Comentario c3 = new Comentario(1, "Horrible");
        cs.addComentario(p1, l2, c3);

        Libro l3 = new Libro("Corazon roto", 147);
        Persona p3 = new Persona("Juan", "juan_perez", "juan78", "juan@gmail.com");
        Comentario c4 = new Comentario(5, "Me encanta");
        Comentario c5 = new Comentario(2, "Muy aburrido");
        cs.addComentario(p2, l3, c4);
        cs.addComentario(p3, l3, c5);

        Persona userLogged = ps.logIn("carolina.penalba", "penalba12");
        if (userLogged != null) {
            System.out.println("Usuario y contraseña correctos");
        } else {
            System.out.println("Error en el usuario o en la contraseña");
        }

        Comentario c6 = new Comentario(4);
        cs.addComentario(p3, l2, c6);

        Comentario c7 = new Comentario("Muy bonito");
        cs.addComentario(p3, l1, c7);

        List<Libro> list1 = pid.getLibrosLeidosByPersona(p2);
        for (Libro libro : list1) {
            System.out.println("Libros leidos de este usuario: " + libro.toString());
        }

        System.out.println("Todos los libros: " + lid.getAllLibros());

    }
}
