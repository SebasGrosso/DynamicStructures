package presenter;

import java.util.Vector;

import model.Article;
import model.Articles;
import model.ShoppingCart;
import view.View;

public class Presenter {
	
	private ShoppingCart shoppingCart;
	private Articles articles;
	private View view;
	
	public Presenter() {
		shoppingCart = new ShoppingCart();
		articles = new Articles();
		view = new View();
	}
	
	public void showArticles () {
		String assistant = "";
		Vector<Article> articlesAssistant = articles.getVectorArticles();
		for (Article article : articlesAssistant) {
			assistant = assistant+article+"\n";
		}
		view.showMessage(assistant);
	}
	
	public void addArticlesToShoppingCart() {
		String nameArticle = view.readString("Ingrese el nombre del articulo que desea agergar al carrito:");
		shoppingCart.addArticlesToShoppingCart(nameArticle);
		view.showMessage("Articulo "+nameArticle+" fue agregado al carrito de forma exitosa.");
	}
	
	public void showArticlesInCart() {
		String assistant = "";
		Vector<Article> articlesAssistant = shoppingCart.getVectorArticlesCart();
		for (Article article : articlesAssistant) {
			assistant = assistant+article+"\n";
		}
		view.showMessage("~~~CONTENIDO DEL CARRITO~~~\n"+assistant);
	}
	
	public void showTotalPriceCart() {
		view.showMessage("~~~PRECIO TOTAL DEL CARRITO~~~\n"+shoppingCart.totalPriceArticles()+"$");
	}
	
	public int showMenu() {
		int option = view.readInt("Digite una opcion: \n1.Mostar articulos. \n2.Agregar articulos al carrito. \n3.Mostrar contenido del carrito. \n4.Mostar precio total del carrito. \n5.Salir.");
		return option;
	}
	
	public void run() {
		int option = 0;
		do {
			option = showMenu();
			switch (option) {
			case 1:
				showArticles();
				break;
			case 2:
				addArticlesToShoppingCart();
				break;
			case 3:
				showArticlesInCart();
				break;
			case 4:
				showTotalPriceCart();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				view.showMessage("La opcion digitada no es correcta. ");
				break;
			}

		} while (option != 5);
	}

}
