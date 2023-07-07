window.onload = function(){
    /* Método para buscar los posts*/
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
function toggleOptions(event) {
    const menuOptions = event.target.nextElementSibling;
    menuOptions.classList.toggle("show");
}

function eliminarPublicacion(id) {
    //AQUI SE PONE EL CÓDIGO PARA ELIMINAR PUBLICACIÓN CON Fetch API
    console.log(`Eliminar publicación con ID: ${id}`);
}

