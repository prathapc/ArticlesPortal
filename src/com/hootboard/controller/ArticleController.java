package com.hootboard.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import com.hootboard.dao.ArticlesDAO;
import com.hootboard.dao.ArticlesDAOImpl;
import com.hootboard.form.Article;

@ManagedBean
@SessionScoped
public class ArticleController implements ValueChangeListener {

	private static Set<String> cancerTypes;
	private static String typeOfCancer = "Select";
	
	private List<Article> articles = null;
	
	static {
		System.out.println("intializing dropdown with values");
		cancerTypes = new HashSet<String>();
		cancerTypes.add("Heart Cancer");
		cancerTypes.add("Brain Tumor");
		cancerTypes.add("Bone Cancer");
		cancerTypes.add("Leukemia");
	}
	
	@Override
	public void processValueChange(ValueChangeEvent e)
			throws AbortProcessingException {
		// TODO Auto-generated method stub
		typeOfCancer = e.getNewValue().toString();
		System.out.println("New value:"+typeOfCancer);
		
		ArticlesDAO artilcesDAO = new ArticlesDAOImpl();
		articles = artilcesDAO.getArticlesByCancerType(typeOfCancer);
		
		//need to put in session
		
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArtilces(List<Article> articles) {
		this.articles = articles;
	}


	public Set<String> getCancerTypesInSet() {
		return cancerTypes;
	}

	public String getTypeOfCancer() {
		return typeOfCancer;
	}

	public void setTypeOfCancer(String typeOfCancer) {
		ArticleController.typeOfCancer = typeOfCancer;
	}
	
}
