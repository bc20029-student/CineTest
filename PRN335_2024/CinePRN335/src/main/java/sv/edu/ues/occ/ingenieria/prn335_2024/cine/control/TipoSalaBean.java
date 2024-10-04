package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;
import java.io.Serializable;

@Stateless
public class TipoSalaBean extends AbstractDataPersist<TipoSala> implements Serializable {
    @PersistenceContext(unitName = "CinePU")
    public EntityManager em;

    public TipoSalaBean() {
        super(TipoSala.class);
    }


    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
