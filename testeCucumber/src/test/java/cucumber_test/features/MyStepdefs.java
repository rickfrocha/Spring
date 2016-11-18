package cucumber_test.features;

import com.example.TesteCucumberApplication;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ricardo on 30/08/16.
 */
@SpringApplicationConfiguration(TesteCucumberApplication.class)
@IntegrationTest
public class MyStepdefs {

    @Dado("^Usuario deseja acessar a api$")
    public void usuarioDesejaAcessarAApi() throws Throwable {
        System.out.println("iniciando ");

    }

    @Quando("^Acessar a URL$")
    public void acessarAURL() throws Throwable {
        System.out.println("quando");
    }

    @Entao("^Retorna ok$")
    public void retornaOk() throws Throwable {
        System.out.println("entao");
    }
}
