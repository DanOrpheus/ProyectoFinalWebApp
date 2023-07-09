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
    
//    // Obtener referencia al elemento donde se mostrará la foto de perfil en cada publicación
//const profileImageElement = document.getElementById('profileImage');
//
//// Función para crear una nueva publicación
//function createPost(content, profileImage) {
//    const postContainer = document.createElement('div');
//    postContainer.classList.add('post');
//
//    const profileImageElement = document.createElement('img');
//    profileImageElement.src = profileImage;
//    profileImageElement.alt = 'Foto de perfil';
//    postContainer.appendChild(profileImageElement);
//
//    const contentElement = document.createElement('p');
//    contentElement.textContent = content;
//    postContainer.appendChild(contentElement);
//
//    // Agregar la nueva publicación al DOM
//    const mainElement = document.querySelector('main');
//    mainElement.appendChild(postContainer);
//}
//
//// Manejar la publicación de la publicación
//const postButton = document.getElementById('postButton');
//postButton.addEventListener('click', function(event) {
//    event.preventDefault();
//
//    const postContentElement = document.getElementById('postContent');
//    const postContent = postContentElement.value;
//
//    // Obtener el usuario almacenado
//    const savedUser = localStorage.getItem('user');
//
//    if (savedUser) {
//        const user = JSON.parse(savedUser);
//        createPost(postContent, user.profileImage);
//        postContentElement.value = '';
//    }
//});


    // ASIGNACIÓN SEMÁNTICA
    const btnPublicar = document.getElementById("btn-publicar");
    btnPublicar.onclick = guardarPublicacion;
};