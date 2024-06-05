package Giulio_Marra.dao;

import Giulio_Marra.entities.Location;
import Giulio_Marra.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location" + location.getNome() + "è stato aggiunto");
    }


    public Location getById(long idLocation) {
        Location location = em.find(Location.class, idLocation);
        if (location == null) throw new NotFoundException(idLocation);
        return location;
    }

    public void delete(long idLocation) {
        Location location = this.getById(idLocation);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(location);
        transaction.commit();
    }
}
