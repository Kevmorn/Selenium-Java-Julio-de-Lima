package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String capturarTextoToast() {
       return navegador.findElement(By.id("toast-container")).getText();

    }
}











//  private WebDriver navegador; // propriedade privada do webdriver responsavel por navegar entre os metodos

//   public LoginPage(WebDriver navegador) { //Metodo construtor tem que obrigatoriamente receber uma instancia do web driver
//   this.navegador = navegador; // pega a instancia navegador e joga para o atributo navegador

     // toda pagina do page objects precisa ter isso ae