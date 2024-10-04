package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoProducto;
import java.io.Serializable;

@Stateless
public class TipoProductoBean extends AbstractDataPersist<TipoProducto> implements Serializable {
    @PersistenceContext(unitName = "CinePU")
    public EntityManager em;

    public TipoProductoBean() {
        super(TipoProducto.class);
    }


    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
