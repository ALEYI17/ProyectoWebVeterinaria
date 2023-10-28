package com.vetcare.proyecto.e2eTest;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
        //conseguir pagina principal
        driver.get(UrlBase + "home");
        driver.manage().window().maximize();

        //oprimir el boton de login
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Loginbutton")));
        WebElement loginButton = driver.findElement(By.id("Loginbutton"));
        loginButton.click();

        //entrar login veterinario
        WebElement loginVet = driver.findElement(By.id("loginVet"));
        loginVet.click();

        //llenar el form de log in
        WebElement loginCedula = driver.findElement(By.id("cedulaLogIn"));
        WebElement loginContrasena = driver.findElement(By.id("ContrasnaLogIn"));
        WebElement buttonLogVet = driver.findElement(By.className("btn"));
        //malas credenciales
        loginCedula.sendKeys("creedncial mala");
        loginContrasena.sendKeys("mal cubu");
        buttonLogVet.click();

        //assert error
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("errorcito")));
        WebElement errorMesagge = driver.findElement(By.id("errorcito"));
        String expectedMessage ="Credenciales de inicio de sesión no válidas";
        Assertions.assertThat(errorMesagge.getText()).isEqualTo(expectedMessage);

        //entrar con credenciales valdias
        loginCedula.sendKeys("123");
        loginContrasena.sendKeys("123");
        buttonLogVet.click();


        //conseguir la lista de mascotasa antes de crear macota
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresMascotas = driver.findElements(By.className("nombresMascotas"));
        
        //ir a crud de cleitnes
        WebElement cleintesCrud = driver.findElement(By.id("crudClientes"));
        cleintesCrud.click();

        //conseguir la lista de clientes antes de crear cliente
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresClientes = driver.findElements(By.className("nombresClientes"));


        //entrar a crear cliente
        WebElement agregarCliente = driver.findElement(By.className("agregar"));
        agregarCliente.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("container")));


        //llenar form de creacion
        WebElement agregarClienteCedula = driver.findElement(By.id("cedula"));
        WebElement agregarClienteNombre = driver.findElement(By.id("nombre"));
        WebElement agregarClienteCorreo = driver.findElement(By.id("corre"));
        WebElement agregarClienteCelular = driver.findElement(By.id("celular"));
        WebElement agregarClienteEnviar= driver.findElement(By.id("enviarForm"));
        
        //crear cleitne con correo erroneo
        agregarClienteCedula.sendKeys("52397652367529");
        agregarClienteNombre.sendKeys("beto");
        agregarClienteCorreo.sendKeys("correomalo");
        agregarClienteCelular.sendKeys("3185234355");
        agregarClienteEnviar.click();


        //assert error de creacion
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        WebElement errorEmailCliente = driver.findElement(By.className("error"));
        expectedMessage ="Correo no puede estar vacío.";
        Assertions.assertThat(errorEmailCliente.getText()).isEqualTo(expectedMessage);

        agregarClienteCorreo.clear();

        //correo valido
        agregarClienteCorreo.sendKeys("correovalido@gmail.com");
        agregarClienteEnviar.click();

        //assert numero de cleitnes aumenta por 1 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresClientesFinales = driver.findElements(By.className("nombresClientes"));
      

        Assertions.assertThat(nombresClientesFinales.size()).isEqualTo(nombresClientes.size()+1);


        //volver crud de mascota
        WebElement mascotasCrud = driver.findElement(By.id("crudMascotas"));
        mascotasCrud.click();


        //agregar mascota
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



        // volver a la landing page
        WebElement VOlverLanding = driver.findElement(By.id("logogato"));
        VOlverLanding.click();

        loginButton = driver.findElement(By.id("Loginbutton"));
        loginButton.click();

        //entrar como cliente
        WebElement loginCliCedula = driver.findElement(By.id("ContrasnaLogInCli"));
        loginCliCedula.sendKeys("52397652367529");

        buttonLogVet = driver.findElement(By.className("btn"));
        buttonLogVet.click();

        //encontrar mascota creada
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("contenido")));
        WebElement Mascota = driver.findElement(By.className("cardclik"));
        Mascota.click();

        //assert creacion de mascota con datos correctos
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("user-details")));
        WebElement nombreMascotaAssert = driver.findElement(By.id("nombre"));
        WebElement razaMascotaAssert = driver.findElement(By.id("raza"));
        WebElement edadMascotaAssert = driver.findElement(By.id("edad"));
        WebElement pesoMascotaAssert = driver.findElement(By.id("peso"));
        WebElement enfermedadMascotaAssert = driver.findElement(By.id("enfermedad"));

        Assertions.assertThat(nombreMascotaAssert.getText()).isEqualTo(nombreMascota);
        Assertions.assertThat(razaMascotaAssert.getText()).isEqualTo(razaMascota);
        Assertions.assertThat(edadMascotaAssert.getText()).isEqualTo(edadMascota);
        Assertions.assertThat(pesoMascotaAssert.getText()).isEqualTo(pesoMascota);
        Assertions.assertThat(enfermedadMascotaAssert.getText()).isEqualTo(enfermedadMascota);
        


    }

    @Test
    public void caso2(){
        // ir a la url para ver las estadisticas
        driver.get(UrlBase + "admin/dashboard");
        driver.manage().window().maximize();

        //Esperar hasta que se vea la informacion de las tarjetas de dashbord
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ventas")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ganancias")));

        //Conseguir el objeto web de estas estadisticas
        WebElement ventas = driver.findElement(By.id("ventas"));
        WebElement ganancias = driver.findElement(By.id("ganancias"));
        // pasar el textoa dato string y quitar los caracteres no numericos
        String ventasText = ventas.getText().replaceAll("[^0-9]", ""); // Removes non-numeric characters
        // Quitar los dos últimos ceros
        String stringWithoutZeros = ganancias.getText().replaceAll("\\.00$", "");
        String gananciasText = stringWithoutZeros.replaceAll("[^0-9]", ""); // Removes non-numeric characters
        // Convertir a números de punto flotante (double)
        Long ventasNumero = Long.parseLong(ventasText);
        Double gananciasNumero = Double.parseDouble(gananciasText);

        log.info(ventasNumero.toString());
        log.info(gananciasNumero.toString());
        // volver a home para comenzar con la prueba 
        WebElement buttonSideNav = driver.findElement(By.id("buttonSidenav"));
        buttonSideNav.click(); 
        WebElement buttonHome = wait.until(ExpectedConditions.elementToBeClickable(By.id("buttonHome")));
        buttonHome.click();
        // oprimir el boton que lleva a login
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Loginbutton")));
        WebElement loginButton = driver.findElement(By.id("Loginbutton"));
        loginButton.click();

         //entrar login veterinario
        WebElement loginVet = driver.findElement(By.id("loginVet"));
        loginVet.click();

        //llenar el form de log in
        WebElement loginCedula = driver.findElement(By.id("cedulaLogIn"));
        WebElement loginContrasena = driver.findElement(By.id("ContrasnaLogIn"));
        WebElement buttonLogVet = driver.findElement(By.className("btn"));

        //entrar con credenciales valdias
        loginCedula.sendKeys("123");
        loginContrasena.sendKeys("123");
        buttonLogVet.click();

        //conseguir la lista de mascotasa 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
       

        //Esperar a que cargue la searchbar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));
        WebElement barraBusqueda = driver.findElement(By.id("searchInput"));

        //Escribir en la barra de busqueda
        barraBusqueda.sendKeys("Quin");
        List<WebElement> botonesTratamiento = driver.findElements(By.className("tratamiento-button"));

        //Oprimir el boton para ir a tratmientos
        botonesTratamiento.get(0).click();
        //esperar hasta que se cargue la pagina
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("input-box")));
        
        //Oprimir el wrapper para que sse muestre la lista de medicamentos
        WebElement agregarMascotasearchWrapper = driver.findElement(By.className("wrapper"));
        agregarMascotasearchWrapper.click();

        //buscar en la lista de medicamentos
        String nombreMedicamento = "AMOX";
        WebElement agregarMascotasearchInput= driver.findElement(By.id("searchInput"));
        agregarMascotasearchInput.sendKeys(nombreMedicamento);

        // Se espera que se muestre la lista y despues se selecciona el medicamento en la lista que tiene el nombre elegido  
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nombresClientes")));
        List<WebElement> clienteElements = driver.findElements(By.className("nombresClientes"));

        for (WebElement clienteElement : clienteElements) {
            if ("AMOXICILINA".equals(clienteElement.getText())) {
                clienteElement.click(); // Click the element if the text matches
                break; // Break out of the loop once found
            }
        }
        

        WebElement inputFecha = driver.findElement(By.id("fecha"));

        // Borrar cualquier texto existente (si es necesario)
        inputFecha.clear();

        // Establecer la fecha deseada en el campo de entrada
        String fechaDeseada = "27/10/2023"; // Reemplazar con la fecha deseada en formato dd/MM/yy
        inputFecha.sendKeys(fechaDeseada);

        //Guardamos el precio del medicamento
        // Buscar el elemento por su ID
        WebElement precioElement = driver.findElement(By.id("precioo"));

        // Obtener el valor del atributo "value" (ya que es un campo de solo lectura)
        String precioValue = precioElement.getAttribute("value");

        // Parsear el valor si es necesario
        Double precio = Double.parseDouble(precioValue);
        log.info("Preciooooooooooooooooooooooo");
        log.info(precio.toString());

        Assertions.assertThat(precio).isEqualTo(182900);

        WebElement buttonSubmit = driver.findElement(By.id("enviarForm"));

        buttonSubmit.click();

        //conseguir la lista de mascotasa 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("delete-button")));
        List<WebElement> nombresMascotas = driver.findElements(By.cssSelector(".nombresMascotas a"));

        // Buscar la mascota para ver que se anadio el tratamiento
        for(WebElement mascotas:nombresMascotas){
            if("Quinta".equals(mascotas.getText())){
                mascotas.click();
                break;
            }
        }

        //Ver que la lista existe en la mascota
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("medicamentos")));
        List<WebElement> medicamenbtos= driver.findElements(By.className("medicamentos"));
        // Ver que se anadio el medicamento correcto 
        Assertions.assertThat(medicamenbtos.size()).isGreaterThan(0);
        Assertions.assertThat(medicamenbtos.size()).isEqualTo(1);
        Assertions.assertThat(medicamenbtos.get(0).getText()).isEqualTo("AMOXICILINA");
        // volver a la lista de mascotas
        WebElement botonVolver = driver.findElement(By.id("botonAtras"));
        botonVolver.click();

        // volver a la landing page
        WebElement VOlverLanding = driver.findElement(By.id("logogato"));
        VOlverLanding.click();

        // ir a el login del admin e ingresar
        driver.get(UrlBase + "login/admin");
        WebElement loginUsername = driver.findElement(By.id("username"));
        WebElement loginContra = driver.findElement(By.id("contra"));
        WebElement buttonLogAdmin = driver.findElement(By.className("btn"));
        loginUsername.sendKeys("123");
        loginContra.sendKeys("123");
        buttonLogAdmin.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("buttonSidenav")));
        // Abrir la sidenav
        WebElement buttonSideNav2 = driver.findElement(By.id("buttonSidenav"));
        buttonSideNav2.click();

        WebElement buttonEstadisticas= driver.findElement(By.id("Estadisticas"));
        buttonEstadisticas.click();

        //Esperar hasta que se vea la informacion de las tarjetas de dashbord
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ventas")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ganancias")));

        //Conseguir el objeto web de estas estadisticas
        WebElement ventas2 = driver.findElement(By.id("ventas"));
        WebElement ganancias2 = driver.findElement(By.id("ganancias"));

        // pasar el textoa dato string y quitar los caracteres no numericos
        String ventasText2 = ventas2.getText().replaceAll("[^0-9]", ""); // Removes non-numeric characters
        String stringWithoutZeros2 = ganancias2.getText().replaceAll("\\.00$", "");
        String gananciasText2 = stringWithoutZeros2.replaceAll("[^0-9]", ""); // Removes non-numeric characters

        // Convertir a números de punto flotante (double)
        Long ventasNumero2 = Long.parseLong(ventasText2);
        Double gananciasNumero2 = Double.parseDouble(gananciasText2);

        //Assert
        Double precioFinal = gananciasNumero + precio;
        Assertions.assertThat(ventasNumero2).isEqualTo(ventasNumero + 1);
        Assertions.assertThat(gananciasNumero2).isEqualTo(precioFinal);


    }
    
    
}
