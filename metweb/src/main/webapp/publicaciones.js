window.onload = function () {
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

//Guardar publicación con FetchAPI
document.getElementById("form_publicaciones").addEventListener("submit", function(event) {
  event.preventDefault(); // Evita que se envíe el formulario automáticamente

  // Obtiene los valores del formulario
  var title = document.getElementById("title").value;
  var content = document.getElementById("content").value;

  // Crea objeto con los datos de la publicación
  var publicacion = {
    title: title,
    content: content
  };

  // Solicitud POST al servidor para guardar la publicación
  fetch("/guardar-publicacion", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(publicacion)//Se convierte el objeto en JSON
  })
  .then(function(response) {
    if (response.ok) {
      console.log("Publicación guardada exitosamente");
    } else {
      console.log("Error al guardar la publicación");
    }
  })
  .catch(function(error) {
    console.log("Error de red:", error);
  });
});

    // ASIGNACIÓN SEMÁNTICA
    const btnPublicar = document.getElementById("btn-publicar");
    btnPublicar.onclick = guardarPublicacion;
};