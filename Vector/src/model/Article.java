package model;

public class Article {
	
	private String nameArticle;
	private int priceArticle;
	
	public Article(String nameArticle, int priceArticle) {
		this.nameArticle = nameArticle;
		this.priceArticle = priceArticle;
	}

	public String getNameArticle() {
		return nameArticle;
	}

	public int getPriceArticle() {
		return priceArticle;
	}

	@Override
	public String toString() {
		return "Articulo: " + nameArticle + ", Precio: " + priceArticle+"$";
	}
	
	
	
	

}
