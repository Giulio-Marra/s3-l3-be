package Giulio_Marra;

import Giulio_Marra.dao.EventoDAO;
import Giulio_Marra.entities.Evento;
import Giulio_Marra.enums.TipoEvento;
import Giulio_Marra.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("s3-l2-be");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        Evento fieraDellaCastagna = new Evento("Fiera Della Castagna", LocalDate.of(2024, 10, 01), "Benvenuti alla 12 edizione della sagra della castagna", TipoEvento.PUBBLICO);
        Evento balloInMaschera = new Evento("Ballo in maschera Decorativo", LocalDate.of(2024, 8, 12), "ballo in maschera nell antico cstello circense ", TipoEvento.PRIVATO);

        List<Evento> listEventi = new ArrayList<>();

        listEventi.add(fieraDellaCastagna);
        listEventi.add(balloInMaschera);

        ed.saveArray(listEventi);


        //ed.save(fieraDellaCastagna);
        //ed.save(balloInMaschera);

        try {
            System.out.println(ed.getById(2));
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ed.delete(3);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
