package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {
    public AddContactPage(WebDriver navegador) {
        super(navegador);
    }

    public AddContactPage selectTypeContact(String tipo) {
        WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        return this;
    }

    public AddContactPage typeContact(String contato) {
        navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

        return this;
    }

    public MePage clickAndSave() {
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();
        return new MePage(navegador);
    }

    public MePage addContact(String tipo, String contato) {
        selectTypeContact(tipo);
        typeContact(contato);
        clickAndSave();
        return new MePage(navegador);
    }
}
