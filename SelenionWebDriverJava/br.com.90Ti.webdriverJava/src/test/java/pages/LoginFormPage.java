package pages;

import org.apache.poi.ss.formula.ptg.ScalarConstantPtg;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormPage extends BasePage {

    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    //abordagem estrtural desvangem aumenta a quantidade de codigo mas é possivel interagir com objetos que aparecam no caminho
    public LoginFormPage typeLogin(String login) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }
    public LoginFormPage typePassoword(String password) {
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this;
    }

    /* public LoginFormPage Teste(String id, String name, String conteudo) {
        navegador.findElement(By.id(id)).findElement(By.name(name)).sendKeys(conteudo);
        return this;
    }*/
    public SecretaPage clickSing() { // Nome dos Metodos Tambem São classes a serem criadas pensando sempre a onde devemos ir depois de uma ação ser feita
        navegador.findElement(By.id("btn-submit-sign-in")).click();
        return new SecretaPage(navegador);
    }

    public SecretaPage todoLogin(String login, String password) {
        typeLogin(login);
        typePassoword(password);
        clickSing();
        return new SecretaPage(navegador);
         //nessa abordagem o Julio Mescla FUncional e Estrutural Abusando da melhor parte dos DOis.
    }   //abordagem funcional todas as funçoes dentro desse metodo  a desavantagem é que não é possivel capturar nenhuma mensagem que acontece no intervalo
       //escreve menos codigo.

}
