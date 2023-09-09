document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const nombreInput = document.getElementById("nombre");
    const correoInput = document.getElementById("correo");
    const carreraInput = document.getElementById("carrera");
    const semestreInput = document.getElementById("semestre");
    const errorNombre = document.getElementById("errorNombre");
    const errorRaza = document.getElementById("errorRaza");
    const errorEdad = document.getElementById("errorEdad");
    const errorPeso = document.getElementById("errorPeso");
    const errorCliente = document.getElementById("errorCliente");
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    
    const selectedClient = document.querySelector(".select-btn span");

    form.addEventListener("submit", function (event) {
        let isValid = true;

        // Validate nombre and correo inputs
        if (nombreInput.value.trim() === "") {
            isValid = false;
            errorNombre.style.display = 'block'
            // alert("Nombre cannot be empty.");
        }
        else{

            errorNombre.style.display = 'none'
        }

        if (correoInput.value.trim() === "") {
            isValid = false;
            // alert("Raza cannot be empty.");
            errorRaza.style.display = 'block'
        }
        else{

            errorRaza.style.display = 'none'
        }

        // Validate carrera and semestre inputs
        const carreraValue = parseFloat(carreraInput.value);
        const semestreValue = parseFloat(semestreInput.value);

        if (isNaN(carreraValue) || carreraValue === 0 ) {
            isValid = false;
            // alert("Edad must be a non-zero number.");
            errorEdad.style.display = 'block'
        }
        else{

            errorPeso.style.display = 'none'
        }

        if (isNaN(semestreValue) || semestreValue === 0) {
            isValid = false;
            // alert("Peso must be a non-zero number.");
            errorPeso.style.display = 'block'
        }
        else{

            errorEdad.style.display = 'none'
        }

        // Check if a client has been selected
        if (selectedClient.textContent.trim() === "Selecciona Dueño:") {
            isValid = false;
            errorCliente.style.display='block'
        }else{

            errorCliente.style.display = 'none'
        }

        if (!isValid) {
            event.preventDefault(); // Prevent form submission if validation fails
        }
    });


    const wrapper = document.querySelector(".wrapper")
    selectbtn = document.querySelector(".select-btn")

    selectbtn.addEventListener("click",() =>{
        wrapper.classList.toggle("active")


    });


    // Obtén la lista de clientes y los elementos de la lista
    const optionsList = document.querySelector(".options");
    const optionItems = optionsList.querySelectorAll("li");
    
    // Obtén el campo de entrada de búsqueda
    const searchInput = document.getElementById("searchInput");
    
    // Agrega un evento de escucha para el campo de entrada de búsqueda
    searchInput.addEventListener("input", function () {
        const searchTerm = searchInput.value.toLowerCase();
        
        // Itera a través de los elementos de la lista
        optionItems.forEach(function (item) {
            const text = item.textContent.toLowerCase();
            
            // Si el texto del elemento coincide con el término de búsqueda, muestra el elemento, de lo contrario, ocúltalo
            if (text.includes(searchTerm)) {
                item.style.display = "block";
            } else {
                item.style.display = "none";
            }
        });
    });


});

function selectClient(element) {
    // Get the client ID from the clicked list item's data attribute
    var clientId = element.getAttribute("data-client-id");

    // Update the hidden input field with the selected client's ID
    document.getElementById("clientId").value = clientId;

    // Update the content of the <span> element
    document.querySelector(".select-btn span").textContent = "Dueño: " + element.textContent;

    // Close the client list
    document.querySelector(".wrapper").classList.remove("active");
}
