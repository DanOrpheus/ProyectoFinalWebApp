window.onload = function(){
    // GUARDAR DATOS
    const guardarComentario = () => {
        const btnPublicar = document.getElementById("btn-publicar");
        btnPublicar.disabled = true;
        // Obtener los datos del form de comentarios
        const contenido = document.getElementById("content").value;
        const fechaHoraCreacion = new Date();
        const comentario = {
            contenido,
            fechaHoraCreacion
        };
        // Enviar datos al server con FetchAPI
        fetch({
            url: "http://localhost:8080/metweb/comments?action=create",
            method: "POST",
            body: comentario
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