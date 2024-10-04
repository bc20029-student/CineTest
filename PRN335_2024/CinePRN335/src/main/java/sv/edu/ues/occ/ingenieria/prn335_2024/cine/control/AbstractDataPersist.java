package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDataPersist<T> {

    public abstract EntityManager getEntityManager();

    Class tipoDatos;

public AbstractDataPersist(Class tipoDatos) {
    this.tipoDatos = tipoDatos;
}

public void create(T entity) throws IllegalArgumentException, IllegalStateException {
    EntityManager em = null;
    if (entity == null) {

        throw new IllegalArgumentException("La entidad a persisitir no puede ser nula");
    }
    try {
        em = getEntityManager();
        if (em == null){
            throw new IllegalStateException("Error al acceder al repositorio");
        }
        em.persist(entity);
    }catch (Exception e){
        throw new IllegalStateException("Error al acceder al repositorio",e);
    }
}

public T findById(final Object id) throws IllegalArgumentException, IllegalStateException {
    EntityManager em = null;
    if (id == null) {

        throw new IllegalArgumentException("Parametros no validos: idTipoSala");
    }
    try {
        em = getEntityManager();
        if (em == null){
            throw new IllegalStateException("Error al acceder al repositorio");
        }
    }catch (Exception ex){
        throw new IllegalStateException("Error al acceder al repositorio");
    }
    return (T) em.find(tipoDatos, id);
    }


    public List<T> FindRange(int first, int max) throws IllegalStateException {

        EntityManager em = null;

        if (first >= 0 && max > 0) {

            try {
                em = getEntityManager();
                if (em != null) {
                    CriteriaBuilder cb = em.getCriteriaBuilder();
                    CriteriaQuery cq = cb.createQuery(tipoDatos);
                    Root<T> raiz = cq.from(tipoDatos);
                    cq.select(raiz);
                    TypedQuery q = em.createQuery(cq);

                    q.setFirstResult(first);
                    q.setMaxResults(max);
                    return q.getResultList();

                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
            throw new IllegalStateException();

        }
        return Collections.EMPTY_LIST;

    }

}