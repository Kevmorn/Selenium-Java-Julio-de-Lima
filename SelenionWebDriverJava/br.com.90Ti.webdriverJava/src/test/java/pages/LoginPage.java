package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage clickSingin() {
        navegador.findElement(By.linkText("Sign in")).click(); //vai clicar na pagina atraves do metodo ja definido
        return new LoginFormPage(navegador);
    }
}