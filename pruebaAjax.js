window.onload = function(){

    setTimeout(()=>{
        console.log("Hola mundo");
    }, 5000);

    console.log("Fin del archivo");

    /* Método de consulta remota con AJAX */
    // const consultarRemoto = () => {
    //     const xmlhttp = new XMLHttpRequest();

    //     const manejadorEstados = () => {
    //         // Cuando la petición se haya completado con estado 200
    //         if (xmlhttp.readyState === 4 && xmlhttp.status === 200){
    //             const divMensaje = document.getElementById("mensaje");
    //             divMensaje.innerHTML = xmlhttp.responseText;
    //         }
    //         if (xmlhttp.readyState === 4 && xmlhttp.status === 404){
    //             const divMensaje = document.getElementById("mensaje");
    //             divMensaje.innerHTML = "No se encontró el archivo";
    //         }
    //     }

    //     xmlhttp.onreadystatechange = manejadorEstados;
    //     xmlhttp.open (
    //         "GET",
    //         "http://localhost:8080/arcweb/Users?action=find-all",
    //         true
    //     );
    //     xmlhttp.send();
    // };

    /* Método de consulta remota con FetchAPI */
    fetch("http://localhost:8080/arcweb/Users?action=find-all")
    .then(response => {
        return response.text();
    }).then(text => {
        const divMensaje = document.getElementById("mensaje");
        divMensaje.innerHTML = text;
    }).catch(err => {
        console.error(err);
    });

    const btnConsultar = document.getElementById("btn-consultar");
    btnConsultar.onclick = consultarRemoto;
}