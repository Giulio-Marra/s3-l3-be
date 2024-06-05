package Giulio_Marra;

import Giulio_Marra.dao.EventoDAO;
import Giulio_Marra.entities.Evento;
import Giulio_Marra.entities.Location;
import Giulio_Marra.entities.Partecipazione;
import Giulio_Marra.entities.Persona;
import Giulio_Marra.enums.Sesso;
import Giulio_Marra.enums.Stato;
import Giulio_Marra.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s3-l3-be");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        Location cocoloco = new Location("cocoloco", "frattamaggiore");
        Evento newwave = new Evento("newwave", LocalDate.of(2025, 12, 10), "Benvenuto nella wave", TipoEvento.PUBBLICO);
        Persona giulio = new Persona("Giulio", "Marra", "giuliomarramail@gmail.com", LocalDate.of(1995, 01, 21), Sesso.MASCHIO);
        Partecipazione partecipazionegiulio = new Partecipazione(Stato.CONFERMATA);


    }
}
