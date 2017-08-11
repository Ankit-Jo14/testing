package com.websystique.springmvc.model;
// Generated Aug 8, 2017 11:50:21 AM by Hibernate Tools 5.1.0.Alpha1
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;

import org.hibernate.criterion.Example;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

/**
 * Home object for domain model class Cultivar.
 * @see websystique.springmvc.model.Cultivar
 * @author Hibernate Tools
 */
public class CultivarHome {

	private static final Log log = LogFactory.getLog(CultivarHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();


 
	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;;
		try {
			 Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		        ServiceRegistry registry = new StandardServiceRegistryBuilder()
		                .applySettings(configuration.getProperties())
		                .build();
		         sessionFactory = configuration
		                .addAnnotatedClass(Cultivar.class)
		                .buildSessionFactory(registry);
//        	Configuration cfg = new Configuration().configure("hibernate.cfg.xml"); 
//        	cfg.addAnnotatedClass(com.websystique.springmvc.model.Cultivar.class);
//        	StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
//        	sb.applySettings(cfg.getProperties());
//        	StandardServiceRegistry standardServiceRegistry = sb.build();           	
//        	sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);      	
        } catch (Throwable th) {
                System.err.println("Enitial SessionFactory creation failed" + th);
                throw new ExceptionInInitializerError(th);
        }
					
		return sessionFactory;
	}

	public void persist(Cultivar transientInstance) {
		log.debug("persisting Cultivar instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cultivar instance) {
		log.debug("attaching dirty Cultivar instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cultivar instance) {
		log.debug("attaching clean Cultivar instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cultivar persistentInstance) {
		log.debug("deleting Cultivar instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cultivar merge(Cultivar detachedInstance) {
		log.debug("merging Cultivar instance");
		try {
			Cultivar result = (Cultivar) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cultivar findById(int id) {
		log.debug("getting Cultivar instance with id: " + id);
		try {
			
			 String sql = "select version()";

			   // String result = (String) sessionFactory.openSession().createQuery(sql);
			   // System.out.println(result);

			Cultivar instance = (Cultivar) sessionFactory.openSession()
					.get("com.websystique.springmvc.model.Cultivar", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cultivar instance) {
		log.debug("finding Cultivar instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("websystique.springmvc.model.Cultivar")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
