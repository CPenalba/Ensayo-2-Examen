/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.dao;

import Libreria.model.Libro;
import Libreria.utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuaria
 */
public class LibroImplDAO implements LibroDAO {

    @Override
    public void createLibro(Libro libro) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(libro);
            transaction.commit();
        } catch (HibernateError e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al crear el libro. " + e);
        }
    }

    @Override
    public List<Libro> getAllLibros() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> cr = cb.createQuery(Libro.class);
            Root<Libro> root = cr.from(Libro.class);
            cr.select(root);
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException) {
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }
}