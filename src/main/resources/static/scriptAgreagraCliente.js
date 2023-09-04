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
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    form.addEventListener("submit", function (event) {
        let isValid = true;

        // Validate nombre and correo inputs
        if (nombreInput.value.trim() === "") {
            isValid = false;
            errorRaza.style.display = 'block'
            // alert("Nombre cannot be empty.");
        }
        else{

            errorRaza.style.display = 'none'
        }

        if (correoInput.value.trim() === "") {
            isValid = false;
            // alert("Raza cannot be empty.");
            errorNombre.style.display = 'block'
        }
        else{
            errorNombre.style.display = 'none'
        }

        

        if (carreraInput.value.trim() === "" || !emailRegex.test(carreraInput.value.trim())) {
            isValid = false;
            // alert("Edad must be a non-zero number.");
            errorEdad.style.display = 'block'
        }
        else{

            errorEdad.style.display = 'none'
        }

        if (semestreInput.value.trim() === "") {
            isValid = false;
            // alert("Peso must be a non-zero number.");
            errorPeso.style.display = 'block'
        }
        else{
            errorPeso.style.display = 'none'
        }

        if (!isValid) {
            event.preventDefault(); // Prevent form submission if validation fails
        }
    });
});