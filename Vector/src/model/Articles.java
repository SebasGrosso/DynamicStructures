package model;

import java.util.Vector;

public class Articles {
	
	private Vector<Article> vectorArticles;
	
	public Articles() {
		vectorArticles = new Vector<Article>();
		predefinedArticles();
	}
	
	public void predefinedArticles() {
		vectorArticles.add(new Article("Chocolate", 2000));
		vectorArticles.add(new Article("Café", 1500));
		vectorArticles.add(new Article("Queso", 5000));
		vectorArticles.add(new Article("Huevos", 600));
		vectorArticles.add(new Article("Leche", 3000));
	}
	
	public int searchArticle(String nameArticle) {
		for (int i = 0; i < vectorArticles.size(); i++) {
			if(vectorArticles.get(i).getNameArticle().equals(nameArticle)) {
				return i;
			}
		}
		return -1;
	}

	public Vector<Article> getVectorArticles() {
		return vectorArticles;
	}

}
