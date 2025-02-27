package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPago;
import java.io.Serializable;

public class TipoPagoBean extends AbstractDataPersist<TipoPago> implements Serializable {
    @PersistenceContext(unitName = "CinePU")
    public EntityManager em;

    public TipoPagoBean() {
        super(TipoPago.class);
    }


    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
