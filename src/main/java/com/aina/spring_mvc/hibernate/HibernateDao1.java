/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aina.spring_mvc.hibernate;



;
import com.aina.spring_mvc.model.BaseModel;
import com.aina.spring_mvc.model.Contenu;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import com.aina.spring_mvc.model.BaseModel;
import com.aina.spring_mvc.model.Validite;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import com.aina.spring_mvc.model.BaseModel;
import com.aina.spring_mvc.model.Contenu;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import com.aina.spring_mvc.model.BaseModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;



/**
 *
 * @author LEGION
 */
public class HibernateDao1 {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory; 
    }
    
    public void save(BaseModel basemodel) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction(); //changement dans la base de donne
        session.save(basemodel);  //enregistrement des donnees dans la base
        transaction.commit();
        session.close();
    }
    
  

    public  List findAll(BaseModel baseModel) {
         Session session = null;
        Transaction transaction =  null;
        //List<BaseModel> liste = null;
        List liste = null;
        try{
            liste = new ArrayList<>();
            session = this.sessionFactory.openSession();
            transaction  = session.beginTransaction();
            Criteria createCriteria = session.createCriteria(baseModel.getClass());
            liste = createCriteria.list();
           session.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }   
        return liste;        
    }
    

    
   

    public BaseModel findById(BaseModel baseModel) {
        Session session = this.sessionFactory.openSession();
        try{
            Criteria crite = session.createCriteria(baseModel.getClass());
            crite.add(Restrictions.eq("id" , baseModel.getId()));
            baseModel = (BaseModel) crite.uniqueResult();
            session.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return baseModel;
    }
 
    public void update(BaseModel baseModel) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try{
           session = this.sessionFactory.openSession();
           transaction = session.beginTransaction();
           session.saveOrUpdate(baseModel);
           transaction.commit();
           session.close();
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
      public List pagination(BaseModel basemodel,int offset,int numberOfElements) {
         Session session = null;
        Transaction transaction =  null;
        try{
         session = sessionFactory.openSession();
            transaction  = session.beginTransaction();
            Criteria createCriteria = session.createCriteria(basemodel.getClass());
            createCriteria.setFirstResult(offset);
            createCriteria.setMaxResults(numberOfElements);
            List list = createCriteria.list();
            return list;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }   
        return new ArrayList();
                
    }
      
      
      
      
      
      /////////////////////////////////////////////
      
      
          public <T> List<T> paginateWhere (T entity, int offset, int size){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Example example = Example.create(entity).ignoreCase();
            List<T> results = session.createCriteria(entity.getClass())
                    .add(example)
                    .setFirstResult(offset)
                    .setMaxResults(offset + size).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }

    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<T> results = session.createCriteria(clazz)
                    .setFirstResult(offset)
                    .setMaxResults(offset + size).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }

    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size, String orderBy, boolean orderAsc){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Order order = (orderAsc) ? Order.asc(orderBy) : Order.desc(orderBy);
            List<T> results = session.createCriteria(clazz)
                    .addOrder(order)
                    .setFirstResult(offset)
                    .setMaxResults(offset + size).list();

            return results;
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }

    }
    
        public List<Contenu> findAllContenuValide(Contenu contenu) {
        Session session = this.sessionFactory.openSession();
        List<Contenu> list = null;
        Validite validite = null;
        try{
            validite = new Validite();
            validite.setId(1);
            contenu.setValidite(validite);
            list = new ArrayList<>();
            Criteria crite = session.createCriteria(contenu.getClass());
            crite.add(Restrictions.eq("validite.id" , contenu.getValidite().getId()));
            crite.addOrder(Order.asc("id"));
            list = crite.list();
            session.close();
           
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
        
        
    public List<Contenu> findAllContenuInvalide(Contenu contenu) {
        Session session = this.sessionFactory.openSession();
        List<Contenu> list = null;
        Validite validite = null;
        try{
            validite = new Validite();
            validite.setId(2);
            contenu.setValidite(validite);
            list = new ArrayList<>();
            Criteria crite = session.createCriteria(contenu.getClass());
            crite.add(Restrictions.eq("validite.id" , contenu.getValidite().getId()));
            crite.addOrder(Order.asc("id"));
            list = crite.list();
            session.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }    
        /*
        public List<Utilisateur> findAllUtilisateurNonValide(Utilisateur utilisateur) {
        Session session = this.sessionFactory.openSession();
        List<Utilisateur> list = null;
        Statut statut = null;
        try{
            statut = new Statut();
            statut.setId(1);
            utilisateur.setStatut(statut);
            list = new ArrayList<>();
            Criteria crite = session.createCriteria(utilisateur.getClass());
            crite.add(Restrictions.eq("statut.id" , utilisateur.getStatut().getId()));
            list = crite.list();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    } 
        /*
        
        
    public int getSommeQuantiteByIdMatiere(Achat achat) {
        Session session = null;
        Transaction transaction =  null;
        int result = 0;
        try{
            session = this.sessionFactory.openSession();
            transaction  = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
            Root<Achat> root = query.from(Achat.class);
            Expression<Integer> sum = builder.sum(root.get("quantite"));
            query.select(sum);
            Predicate idMatierePredicate = builder.equal(root.get("matiere"), achat.getMatiere().getId());
            query.where(idMatierePredicate);
            result = session.createQuery(query).getSingleResult();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }   
        return result;        
    }         
        
        
        public List<Matiere> getidMatiereByAchat(Achat achat) {
        Session session = null;
        Transaction transaction =  null;
        Integer result = null;
        List<Matiere> list = null;
        try{
            list = new ArrayList<>();
            session = this.sessionFactory.openSession();
            transaction  = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Achat> query = builder.createQuery(Achat.class);
            Root<Achat> root = query.from(Achat.class);
            query.select(root.get("matiere")).distinct(true);
            //query.orderBy(builder.asc(root.get("matiere")));
           // list = session.createQuery(query).getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }   
        return list;        
    } 
        
    public List<Matiere> triIdMatiere(Matiere matiere) {
        Session session = null;
        Transaction transaction =  null;
        Integer result = null;
        List<Matiere> list = null;
        try{
            list = new ArrayList<>();
            session = this.sessionFactory.openSession();
            transaction  = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Matiere> query = builder.createQuery(Matiere.class);
            Root<Matiere> root = query.from(Matiere.class);
            //query.select(root.get("id")).distinct(true);
            //query.select(root);
            //query.select(root.get("id")).distinct(true);
            query.orderBy(builder.asc(root.get("id")));
            list = session.createQuery(query).getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }   
        return list;        
    }
    
        public List<Integer> triAchat(Achat achat) {
        Session session = null;
        Transaction transaction =  null;
        Integer result = null;
        List<Integer> list = null;
        try{
            list = new ArrayList<>();
            session = this.sessionFactory.openSession();
            transaction  = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
            Root<Achat> root = query.from(Achat.class);
            query.select(root.get("matiere")).distinct(true);//.orderBy(builder.asc(root.get("matiere")));
            list = session.createQuery(query).getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }   
        return list;        
    }
        
    public Seuil findSeuilByIdMatiere( Seuil seuil) {
        Session session = this.sessionFactory.openSession();
        try{
            Criteria crite = session.createCriteria(seuil.getClass());
            crite.add(Restrictions.eq("matiere.id" , seuil.getMatiere().getId()));
            seuil = (Seuil) crite.uniqueResult();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return seuil;
    }
       
    
        public Matiere findByIdAndNom(Matiere baseModel) {
        Session session = this.sessionFactory.openSession();
        
        try{
            
            Criteria crite = session.createCriteria(baseModel.getClass());
            crite.add(Restrictions.eq("id" , baseModel.getId()));
            crite.add(Restrictions.eq("nom" , baseModel.getNom()));
            baseModel = (Matiere) crite.uniqueResult();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return baseModel;
    }*/
    
}
