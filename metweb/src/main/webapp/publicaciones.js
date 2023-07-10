window.onload = function () {
    // GUARDAR PUBLICACIONES
    const guardarPublicacion = () => {
        const btnPublicar = document.getElementById("btn-publicar");
        btnPublicar.disabled = true;
        // Obtener los datos del form de publicaciones
        const titulo = document.getElementById("title").value;
        const contenido = document.getElementById("content").value;
        const fechaHoraCreacion = new Date();
        const publicacion = {
            fechaHoraCreacion,
            titulo,
            contenido
        };
        console.log(JSON.stringify(publicacion));
        // Enviar datos al server con FetchAPI (Formato JSON)
        fetch("http://localhost:8080/metweb/posts?action=create", {
            method: "POST",
            body: JSON.stringify(publicacion),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            btnPublicar.disabled = false;
            return response.json();
        }).then(response => {
            alert("Publicación creada exitosamente");
        }).catch(err => {
            btnPublicar.disabled = false;
            alert("Error al guardar la publicación");
            console.error(err);
        });
    };

    // ASIGNACIÓN SEMÁNTICA
    const btnPublicar = document.getElementById("btn-publicar");
    btnPublicar.onclick = guardarPublicacion;
};