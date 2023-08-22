package model;

import java.util.Vector;

public class ShoppingCart {
	
	private Vector<Article> vectorArticlesCart;
	private Articles articles;
	
	public ShoppingCart () {
		vectorArticlesCart = new Vector<Article>();
		articles = new Articles();
	}
	
	
	public int searchArticle(String nameArticle) {
		return articles.searchArticle(nameArticle);
	}
	
	public void addArticlesToShoppingCart(String nameArticle) {
		int i = searchArticle(nameArticle);
		vectorArticlesCart.add(articles.getVectorArticles().get(i));
	}
	
	public int totalPriceArticles() {
		int totalPrice = 0;
		for (Article article : vectorArticlesCart) {
			totalPrice = totalPrice + article.getPriceArticle();
		}
		return totalPrice;
	}

	public Vector<Article> getVectorArticlesCart() {
		return vectorArticlesCart;
	}
	
	

}
