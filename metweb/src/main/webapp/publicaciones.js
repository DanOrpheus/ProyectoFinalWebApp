window.onload = function(){
    // GUARDAR DATOS
    const guardarPublicacion = () => {
        const btnPublicar = document.getElementById("btn-publicar");
        btnPublicar.disabled = true;
        // Obtener los datos del form de publicaciones
        const titulo = document.getElementById("title");
        const contenido = document.getElementById("content").value;
        const fechaHoraCreacion = new Date();
        const publicacion = {
            titulo,
            contenido,
            fechaHoraCreacion
        };
        // Enviar datos al server con FetchAPI
        fetch({
            url: "http://localhost:8080/metweb/posts?action=create",
            method: "POST",
            body: publicacion
        }).then(response => {
            return response.json();
        }).then(response => {
            alert(response);
        }).catch(err => {
            console.error(err);
        });
    };

    // ASIGNACIÓN SEMÁNTICA
    const btnPublicar = document.getElementById("btn-publicar");
    btnPublicar.onclick = guardarPublicacion;
};