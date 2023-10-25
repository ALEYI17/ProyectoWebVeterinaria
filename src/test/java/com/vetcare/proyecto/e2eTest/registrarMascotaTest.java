package com.vetcare.proyecto.e2eTest;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class registrarMascotaTest {


    private WebDriver driver;

    private WebDriverWait wait;

    private String UrlBase = "http://localhost:4200/";

    Logger log = LoggerFactory.getLogger(getClass());

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--disable-extensions");
        chromeoptions.addArguments("--disable-notifications");
        // chromeoptions.addArguments("--headless");
        this.driver = new ChromeDriver(chromeoptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void caso1() {
        driver.get(UrlBase + "home");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Loginbutton")));
        WebElement loginButton = driver.findElement(By.id("Loginbutton"));
        loginButton.click();
        WebElement loginVet = driver.findElement(By.id("loginVet"));
        loginVet.click();

        WebElement loginCedula = driver.findElement(By.id("cedulaLogIn"));
        WebElement loginContrasena = driver.findElement(By.id("ContrasnaLogIn"));
        WebElement buttonLogVet = driver.findElement(By.className("btn"));
        loginCedula.sendKeys("creedncial mala");
        loginContrasena.sendKeys("mal cubu");
        buttonLogVet.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("errorcito")));
        WebElement errorMesagge = driver.findElement(By.id("errorcito"));
        String expectedMessage ="Credenciales de inicio de sesión no válidas";
        Assertions.assertThat(errorMesagge.getText()).isEqualTo(expectedMessage);

        loginCedula.sendKeys("123");
        loginContrasena.sendKeys("123");
        buttonLogVet.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresMascotas = driver.findElements(By.className("nombresMascotas"));
        
        WebElement cleintesCrud = driver.findElement(By.id("crudClientes"));
        cleintesCrud.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresClientes = driver.findElements(By.className("nombresClientes"));

        WebElement agregarCliente = driver.findElement(By.className("agregar"));
        agregarCliente.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("container")));

        WebElement agregarClienteCedula = driver.findElement(By.id("cedula"));
        WebElement agregarClienteNombre = driver.findElement(By.id("nombre"));
        WebElement agregarClienteCorreo = driver.findElement(By.id("corre"));
        WebElement agregarClienteCelular = driver.findElement(By.id("celular"));
        WebElement agregarClienteEnviar= driver.findElement(By.id("enviarForm"));
        
        agregarClienteCedula.sendKeys("52397652367529");
        agregarClienteNombre.sendKeys("beto");
        agregarClienteCorreo.sendKeys("correomalo");
        agregarClienteCelular.sendKeys("3185234355");
        agregarClienteEnviar.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        WebElement errorEmailCliente = driver.findElement(By.className("error"));
        expectedMessage ="Correo no puede estar vacío.";
        Assertions.assertThat(errorEmailCliente.getText()).isEqualTo(expectedMessage);

        agregarClienteCorreo.clear();

        agregarClienteCorreo.sendKeys("correovalido@gmail.com");
        agregarClienteEnviar.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresClientesFinales = driver.findElements(By.className("nombresClientes"));
      

        Assertions.assertThat(nombresClientesFinales.size()).isEqualTo(nombresClientes.size()+1);


        WebElement mascotasCrud = driver.findElement(By.id("crudMascotas"));
        mascotasCrud.click();

        WebElement agregarMascota = driver.findElement(By.className("agregar"));
        agregarMascota.click();

        
        WebElement agregarMascotanombre = driver.findElement(By.id("nombre"));
        WebElement agregarMascotaraza = driver.findElement(By.id("correo"));
        WebElement agregarMascotaedad = driver.findElement(By.id("carrera"));
        WebElement agregarMascotapeso = driver.findElement(By.id("semestre"));
        WebElement agregarMascotaEnfermedad= driver.findElement(By.id("Enfermedad"));
        WebElement agregarMascotaFoto= driver.findElement(By.id("Foto"));
        WebElement agregarMascotasearchWrapper = driver.findElement(By.className("wrapper"));
        WebElement agregarMascotasearchInput= driver.findElement(By.id("searchInput"));
        WebElement agregarMascotaEnviar= driver.findElement(By.id("enviarForm"));

        String nombreMascota = "misifu";
        String razaMascota = "Pardo";
        String edadMascota = "3";
        String pesoMascota = "15.3";
        String enfermedadMascota = "Triste";
        String fotoMascota = "https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg";
        String busquedaMascota = "be";


        agregarMascotanombre.sendKeys(nombreMascota);
        agregarMascotaraza.sendKeys(razaMascota);
        agregarMascotaedad.sendKeys(edadMascota);
        agregarMascotapeso.sendKeys(pesoMascota);
        agregarMascotaEnfermedad.sendKeys(enfermedadMascota);
        agregarMascotaFoto.sendKeys(fotoMascota);
        agregarMascotasearchWrapper.click();
        agregarMascotasearchInput.sendKeys(busquedaMascota);


        

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nombresClientes")));
        List<WebElement> clienteElements = driver.findElements(By.className("nombresClientes"));

            for (WebElement clienteElement : clienteElements) {
                if ("beto".equals(clienteElement.getText())) {
                    clienteElement.click(); // Click the element if the text matches
                    break; // Break out of the loop once found
                }
            }

        agregarMascotaEnviar.click();


        //hace el assert de que crecio la lista
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresMascotasFinal = driver.findElements(By.className("nombresMascotas"));
        Assertions.assertThat(nombresMascotasFinal.size()).isEqualTo(nombresMascotas.size()+1);




        WebElement VOlverLanding = driver.findElement(By.id("logogato"));
        VOlverLanding.click();

        loginButton = driver.findElement(By.id("Loginbutton"));
        loginButton.click();

        
        WebElement loginCliCedula = driver.findElement(By.id("ContrasnaLogInCli"));
        loginCliCedula.sendKeys("52397652367529");

        buttonLogVet = driver.findElement(By.className("btn"));
        buttonLogVet.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("contenido")));
        WebElement Mascota = driver.findElement(By.className("cardclik"));
        Mascota.click();
        


    }
    
    
}
