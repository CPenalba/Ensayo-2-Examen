/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria.dao;

import Libreria.model.Libro;
import Libreria.model.Persona;
import Libreria.utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuaria
 */
public class PersonaImplDAO implements PersonaDAO {

    @Override
    public void createPersona(Persona persona) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(persona);
            transaction.commit();
        } catch (HibernateError e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al crear la persona. " + e);
        }
    }

    @Override
    public void updatePersona(Persona persona) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(persona);
            transaction.commit();
        } catch (HibernateError e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar la persona. " + e);
        }
    }

    @Override
    public List<Libro> getLibrosLeidosByPersona(Persona persona) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Libro> criteriaQuery = builder.createQuery(Libro.class);
            Root<Libro> libroRoot = criteriaQuery.from(Libro.class);
            Join<Libro, Persona> userJoin = libroRoot.join("lectores");
            criteriaQuery.where(builder.equal(userJoin.get("id"), persona.getId()));
            return session.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException exception) {
            System.err.println("Error en getJobOffers(company). " + exception.getMessage());
            return new ArrayList<>();
        }

    }

}

