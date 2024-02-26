/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuaria
 */
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "numeroPaginas")
    private int numeroPaginas;

    @ManyToMany(mappedBy = "librosLeidos")
    private List<Persona> lectores = new ArrayList<>();

    @ManyToMany(mappedBy = "librosEscritos")
    private List<Persona> autores = new ArrayList<>();

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public Libro() {
    }

    public Libro(String titulo, int numeroPaginas) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public List<Persona> getLectores() {
        return lectores;
    }

    public void setLectores(List<Persona> lectores) {
        this.lectores = lectores;
    }

    public List<Persona> getAutores() {
        return autores;
    }

    public void setAutores(List<Persona> autores) {
        this.autores = autores;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Libro{" + "id: " + id + ", titulo: " + titulo + ", numeroPaginas: " + numeroPaginas + '}';
    }

}
