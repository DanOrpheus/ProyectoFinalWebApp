window.onload = function () {
    
    // GUARDAR DATOS
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
            alert("Publicación guardada exitosamente");
        }).catch(err => {
            btnPublicar.disabled = false;
            alert("Error al guardar la publicación");
            console.error(err);
        });
    };

    //Eliminar publicación con FetchAPI
    var publicacionId;

    function confirmarEliminacion(id) {
        publicacionId = id;
        var modal = document.getElementById("confirm-modal");
        modal.style.display = "block";
    }

    function eliminarPublicacion() {
        //FetchAPI 
        fetch("/eliminar-publicacion?id=" + publicacionId, {
            method: "DELETE"
        })
                .then(function (response) {
                    if (response.ok) {
                        location.reload();
                    } else {
                        console.log("Error al eliminar la publicación");
                    }
                })

                .catch(function (error) {
                    console.log("Error de red:", error);
                });

        cancelarEliminacion();

    }
    function cancelarEliminacion() {
        var modal = document.getElementById("confirm-modal");
        modal.style.display = "none";
    }

    // ASIGNACIÓN SEMÁNTICA
    const btnPublicar = document.getElementById("btn-publicar");
    btnPublicar.onclick = guardarPublicacion;
};