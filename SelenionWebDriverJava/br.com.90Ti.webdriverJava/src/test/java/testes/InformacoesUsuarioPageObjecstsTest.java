package testes;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class) //permite uso de arquivos externos de informação
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")

public class InformacoesUsuarioPageObjecstsTest {
        private WebDriver navegador;


    @Before
    public void setUp() {
        navegador = Web.createChrome();

    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name = "login")String login,
            @Param(name = "senha")String senha,
            @Param(name = "tipo")String tipo,
            @Param(name = "contato")String contato,
            @Param(name = "mensagem")String mensagem
    ){
        String textoToast = new LoginPage(navegador)
                .clickSingin()
                 .typeLogin(login)
                .typePassoword(senha)
                .clickSing()
                .clickMe()
                .clickOnTabMoreDataAboutYou()
                .clickOnButtonAddMoreDataAboutYou()
                .addContact(tipo, contato)
                .capturarTextoToast();

        assertEquals(mensagem, textoToast);

    }

//duas opçoes asserção fora da page ou dentro da page sendo a mais recomendada fazer asserção fora.






    @After
    public void tearDown() {
        navegador.quit();
    }



}

