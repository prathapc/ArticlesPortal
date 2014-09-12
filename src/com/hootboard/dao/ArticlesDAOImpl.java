package com.hootboard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hootboard.form.Article;

public class ArticlesDAOImpl implements ArticlesDAO {
	
	@Override
	public List<Article> getArticlesByCancerType(String cancerType) {
		// TODO Auto-generated method stub
		System.out.println("type:" +cancerType);
		List<Article> articless = null;
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		
		org.hibernate.Query query = session.createQuery("From Article where articleType like :type");
		query.setParameter("type",cancerType);
		try {
			articless = (List<Article>)query.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		System.out.println(articless.size());
		return articless;
	}

}
