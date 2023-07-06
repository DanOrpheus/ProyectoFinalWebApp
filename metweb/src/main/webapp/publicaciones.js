window.onload = function(){
    // GUARDAR DATOS
    const guardarPublicacion = () => {
        const btnPublicar = document.getElementById("btn-publicar");
        btnGuardar.disabled = true;
        // Obtener los datos del form de publicaciones
        // Enviar datos al server con FetchAPI
    };
    
    fetch("http://localhost:8080/metweb/posts?action=findall")
    .then(response => {
        return response.text();
    }).then(text => {
        const divMensaje = document.getElementById("mensaje");
        divMensaje.innerHTML = text;
    }).catch(err => {
        console.error(err);
    });
};