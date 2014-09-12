package com.hootboard.dao;

import java.util.List;

import com.hootboard.form.Article;

public interface ArticlesDAO {
	public List<Article> getArticlesByCancerType(String cancerType);
}
