package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecretaPage extends BasePage {
    public SecretaPage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickMe() {
        //Validar que dentro do documento com class "me" está o texto "Hi, Cristiano Duro Marqu"
        navegador.findElement(By.className("me")).click();


        return new MePage(navegador);
    }
}
