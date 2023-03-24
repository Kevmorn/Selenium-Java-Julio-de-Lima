package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "/C:\\Users\\cristiano\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize(); //maximiza a tela para tamanho maximo
        navegador.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
        // navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        return  navegador;
    }
}
