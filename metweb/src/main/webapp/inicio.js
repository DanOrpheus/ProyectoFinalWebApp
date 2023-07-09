function toggleOptions(event) {
    const menuOptions = event.target.nextElementSibling;
    menuOptions.classList.toggle("show");
}

window.onload = function(){
    // GUARDAR COMENTARIOS
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
        console.log(JSON.stringify(comentario));        
        // Enviar datos al server con FetchAPI
        fetch("http://localhost:8080/metweb/comm?action=create", {
            method: "POST",
            body: JSON.stringify(comentario),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            btnGuardar.disabled = false;
            return response.json();
        }).then(response => {
            alert("Comentario creado exitosamente");
        }).catch(err => {
            btnGuardar.disabled = false;
            alert("Error al guardar el comentario");
            console.error(err);
        });
    };
    
    // CONSULTAR COMENTARIOS
    const consultarComentarios = () => {
        
    };

    // ELIMINAR PUBLICACIÓN
    const eliminarPublicacion = () => {
        const btnEliminar = document.getElementById("btn-eliminar");
        btnEliminar.disabled = true;
        const postId = obtenerId();
        // URL de la API para eliminar la publicación
        const url = `http://localhost:8080/metweb/posts/${postId}`;
        // Configuración de la solicitud de eliminación
        const options = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        };
        // Envío de la solicitud de eliminación
        fetch(url, options)
        .then(response => {
            btnEliminar.disabled = false;
            return response.json();
        }).then(response => {
            alert("Publicación eliminar exitosamente");
        }).catch(err => {
            btnEliminar.disabled = false;
            alert("La publicación no se pudo eliminar");
            console.error(err);
        });
    };

    // ASIGNACIÓN SEMÁNTICA
    const btnGuardar = document.getElementById("btn-guardar");
    btnGuardar.onclick = guardarComentario;    

    const btnEliminar = document.getElementById("btn-eliminar");
    btnEliminar.onclick = eliminarPublicacion;
};