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