package testes;

import static org.junit.Assert.*; //faz uma importacção implicita

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Web;
import suporte.generator;
import suporte.ScreenShot;

import java.util.concurrent.TimeUnit;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class InformacoesUsuarioTest {
private WebDriver navegador; //expor a propriedade navegador a todos os metodos da classe
@Rule
public TestName test = new TestName();


    @Before
public void setUp() {
            navegador = Web.createChrome();

        //Clickar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();
        //Identificando o formulário de login
        WebElement formularaiosSingInBox = navegador.findElement(By.id("signinbox"));
        //digitar no campo com name "Login" que está dentro do formulario de id "singinbox" o texto "crismarxs"
        formularaiosSingInBox.findElement(By.name("login")).sendKeys("crismarxs");
        //digitar no campo com name "password" que está dentro do formulario de id "singinbox" o texto "852456cris"
        formularaiosSingInBox.findElement(By.name("password")).sendKeys("852456cris");
        //clickar no "link" pois começa a div com <a href com o texto "SING IN"
        navegador.findElement(By.id("btn-submit-sign-in")).click();
        //Validar que dentro do documento com class "me" está o texto "Hi, Cristiano Duro Marqu"
        WebElement me = navegador.findElement(By.className("me"));
        // getTEXT pega o que tem dentro de um Abrir e fechar de uma TAG
        String textoNoElementoME = me.getText();
        assertEquals("Hi, Cristiano Duro Marqu", textoNoElementoME);
        //clicar em um link que possui a classe "me"
        navegador.findElement(By.className("me")).click();
        //Clickar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
}

@Test //para o teste ser valido é necessario ter o @Test ao clickar em executar


    public void testAdicionarUmaInformacaoAdicionalDoUsuario () {


    //Clickar no link que possui o texto "Sign in"
    navegador.findElement(By.linkText("Sign in")).click();


    //Identificando o formulário de login
    WebElement formularaiosSingInBox = navegador.findElement(By.id("signinbox"));

    //digitar no campo com name "Login" que está dentro do formulario de id "singinbox" o texto "crismarxs"
    formularaiosSingInBox.findElement(By.name("login")).sendKeys("crismarxs");

    //digitar no campo com name "Login" que está dentro do formulario de id "singinbox" o texto "852456cris"
    formularaiosSingInBox.findElement(By.name("password")).sendKeys("852456cris");


    //clickar no "link" pois começa a div com <a href com o texto "SING IN"
    navegador.findElement(By.id("btn-submit-sign-in")).click();

    //Validar que dentro do documento com class "me" está o texto "Hi, Cristiano Duro Marqu"
    WebElement me = navegador.findElement(By.className("me"));
// getTEXT pega o que tem dentro de um Abrir e fechar de uma TAG
    String textoNoElementoME = me.getText();
    assertEquals("Hi, Cristiano Duro Marqu", textoNoElementoME);



    }


    @Test //para o teste ser valido é necessario ter o @Test ao clickar em executar


    public void testAdicionarUmaInformacaoAdicionalDoUsuario002 (@Param(name="tipo")String tipo, @Param(name="contato")String contato, @Param(name="mensagem")String mensagemesperada) {
        //Clickar no botão através do seu Xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
        //Identificar a popup onde está o formulário de id addmoredata
        WebElement popuAddMoreData = navegador.findElement(By.id("addmoredata"));
        //na Combo de name "type" escolher a opção "Phone" ou [1]
         WebElement campoType  =   popuAddMoreData.findElement(By.name("type"));
         new Select(campoType).selectByVisibleText(tipo);
        //no campo de name "contact" digitar "5511999999999"
        popuAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        //clickar no Link de text "SAVE" que está na popup
      //  paopuAddMoreData.findElement(By.linkText("SAVE")).click();

        //na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals(mensagemesperada, mensagem);

    }

@Test
public void removerUmContatoDeUmUsuario() {
    //cliclar no elemento pelo seu xpath //span[text()="5511999999999"]/following-sibling::a
    navegador.findElement(By.xpath("//span[text()=\"5511999999999\"]/following-sibling::a")).click();

    //confirmar a janela javascript
    navegador.switchTo().alert().accept();


    //validar que a mensagem apresentada foi "Rest in peace, dear phone!"
    WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
    String mensagem = mensagemPop.getText();
    assertEquals("Rest in peace, dear phone!", mensagem);
    String screenshotArquivo = "C:\\Fotos Selenium" + generator.dataHoraParaArquivo() + test.getMethodName() + "png";
    ScreenShot.tirar(navegador, screenshotArquivo);

    //Aguardar até 10 segundos para a janela desapareça
    WebDriverWait aguardar = new WebDriverWait(navegador, 10);
    aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

    //Clicker no link com texto "Logout"
    navegador.findElement(By.linkText("Logout")).click();
}













    @After
    public void tearDown() {
        //Fechar o navegador
        navegador.quit(); //fechar todas as abas enquanto close fecha 1 aba.
    }


}



//WebElement linkSingIn //linkSingIn.click(); outra forma de realizar a captura do texto Sing IN