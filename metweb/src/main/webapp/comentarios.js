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

    // ASIGNACIÓN SEMÁNTICA
    const btnGuardar = document.getElementById("btn-guardar");
    btnGuardar.onclick = guardarComentario;    
};