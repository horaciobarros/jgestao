package controleInterno.model; 

import java.io.*;
import java.util.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Transaction;
import controleInterno.model.AuditoriaDocumentoIrregularidades;
import controleInterno.dao.*;

@Repository 
public class AuditoriaDocumentoIrregularidadesDaoImpl implements AuditoriaDocumentoIrregularidadesDao{

   private static final long serialVersionUID = 1L;

   @Autowired 
   private SessionFactory sessionFactory;

   @Autowired 
   private Dao<AuditoriaDocumentoIrregularidades> dao;

   StringBuilder hql; 

   public boolean existe(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades){
      Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
      Query query = sessionFactory.getCurrentSession().createQuery("from AuditoriaDocumentoIrregularidades e where e.id = :pId ");
      query.setParameter("pId", auditoriadocumentoirregularidades.getId());
      List lista = query.list();
tx.commit()
;boolean encontrado = !lista.isEmpty();
return encontrado;
   }
   public void adiciona(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades){
      dao.save(auditoriadocumentoirregularidades);
   }
   public void exclui(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades){
      dao.delete(auditoriadocumentoirregularidades);
   }
   public void altera(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades){
      dao.update(auditoriadocumentoirregularidades);
   }
   public List<AuditoriaDocumentoIrregularidades> lista(){
      return (List<AuditoriaDocumentoIrregularidades>) this.dao.find("FROM AuditoriaDocumentoIrregularidades e ");
    }
   public Object buscaAuditoriaDocumentoIrregularidadesPeloId(long id){
      Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
      Query query = sessionFactory.getCurrentSession().createQuery("from AuditoriaDocumentoIrregularidades e where e.id = :pId ");
      query.setParameter("pId", id);
      List lista = query.list();
 return (AuditoriaDocumentoIrregularidades) lista.get(0);
   }
}