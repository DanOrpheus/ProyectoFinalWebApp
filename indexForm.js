
window.onload = function(){

    // OBTENER DATOS DE UN RADIO
    const getSexoSeleccionado = () => {
        const radiosSex = document.getElementsByName("rad-sexo");
        for (let radio of radiosSex){
            if (radio.checked){
                return radio.value;
            }
        }
        // Return Explicito
        return undefined;
    };

    // OBTENER DATOS DE UN CHECKBOX
    const getGenerosSeleccionados = () => {
        const checksGeneros = document.getElementsByName("chk-generos");
        const listaGeneros = [];
        for (let checkbox of checksGeneros){
            if (checkbox.checked){
                listaGeneros.push(checkbox.value);
            }
        }
        // Return Explicito
        return listaGeneros;
    };

    // OBTENER DATOS DE UN SELECT
    const getComidaSeleccionada = () => {
        const selectComidas = document.getElementById("sel-comidas");
        let valorSeleccionado = selectComidas.options[
            selectComidas.selectedIndex].value;
        return valorSeleccionado;
    };

    // GUARDAR DATOS
    const guardarUsuario = () => {
        const btnGuardar = document.getElementById("btn-guardar");
        btnGuardar.disabled = true;
        // Obtener los datos del form
        const nombre = document.getElementById("txt-nombre").value;
        const correo = document.getElementById("txt-correo").value;
        const sexo = getSexoSeleccionado();
        const generos = getGenerosSeleccionados();
        const comida = getComidaSeleccionada();
        const usuario = { 
            nombre, 
            correo,
            sexo,
            generos,
            comida
        };
        // Enviar datos al server con FetchAPI
        console.table(usuario);
    };

    // ASIGNACIÓN SEMÁNTICA
    const btnGuardar = document.getElementById("btn-guardar");
    btnGuardar.onclick = guardarUsuario;
}