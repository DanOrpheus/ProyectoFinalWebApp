window.onload = function(){
    // GUARDAR DATOS
    const guardarComentario = () => {
        const btnGuardar = document.getElementById("btn-guardar");
        btnGuardar.disabled = true;
        // Obtener los datos del form de comentarios
        const contenido = document.getElementById("content").value;
        const fechaHoraCreacion = new Date();
        const comentario = {
            contenido,
            fechaHoraCreacion
        };
        // Enviar datos al server con FetchAPI
        fetch("http://localhost:8080/metweb/comments?action=create", {
            method: "POST",
            body: JSON.stringify(comentario),
            headers: {
                "content-type": "application/json"
            }
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