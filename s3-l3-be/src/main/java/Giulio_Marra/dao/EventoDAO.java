package Giulio_Marra.dao;

import Giulio_Marra.entities.Evento;
import Giulio_Marra.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'evento" + evento.getTitoloEventp() + "è stato aggiunto");
    }


    public Evento getById(long idEvento) {
        Evento evento = em.find(Evento.class, idEvento);
        if (evento == null) throw new NotFoundException(idEvento);
        return evento;
    }

    public void delete(long idEvento) {
        Evento evento = this.getById(idEvento);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(evento);
        transaction.commit();
    }
}
