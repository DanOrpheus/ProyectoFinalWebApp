function colorearR(elemento){
    elemento.className = "colorearNaranja";
}

function resaltarV(elemento){
    elemento.className = "resaltarVioleta";
}

function resaltar(evento){
    if (evento.type === "mouseenter"){
        this.className = "colorearNaranja";
    } else if (evento.type === "mouseleave"){
        this.className = "resaltarVioleta";
    }
}

function eliminarFila(input){
    // Método a corregir (eliminar parentNode)
    const indexRow = input.parentNode.parentNode.rowIndex;      
    const tabla = document.getElementById("tabla");
    tabla.deleteRow(indexRow);    
}

function insertarFila(){
    const tabla = document.getElementById("tabla");
    const fila = tabla.insertRow(0);
    const celda1 = fila.insertCell(0);
    const celda2 = fila.insertCell(1);
    const celda3 = fila.insertCell(2);
    celda1.innerHTML = "Celda 1";
    celda2.innerHTML = "Celda 2";
    // Crear un Button en una tabla
    const button = document.createElement("button");
    button.innerHTML = "Eliminar";
    button.onclick = eliminarFila;
    celda3.appendChild(button);
}

// ESPERAR A QUE SE TERMINE DE GENERAR EL DOM
window.onload = function(){
    // // let divs = document.getElementsByTagName("div");
    // let divs = document.getElementsByName("texto");
    // for (let div of divs){
    //     div.innerHTML = "Hola mundo";
    // }
    // let divId = document.getElementById("mensaje");
    // if (divId === null){
    //     throw Error("No existe la id que se intentó obtener");
    // }
    // divId.innerHTML = "Adios mundo";

    // let parrafosEnDivs = document.querySelectorAll("div > p");
    // for (let parrafo of parrafosEnDivs){
    //     parrafo.innerHTML = "Soy un párrafo de un div";
    // }

    // // let formId = document.getElementById("register-form");
    // const formId = document.querySelector("#register-form");
    // const inputs = formId.querySelectorAll("input");
    // for (let input of inputs){
    //     input.placeholder = "Escribe algo aquí";
    // }
    const parrafo = document.createElement("p");
    const texto = document.createTextNode("Adios mundo");
    parrafo.appendChild(texto);
    // document.body.appendChild(parrafo);
    const divTitulo = document.querySelector("#titulo");
    divTitulo.appendChild(parrafo);

    let inputBorrar = document.getElementById("mail");
    inputBorrar.parentNode.removeChild(inputBorrar);

    function mostrarAlerta(){
        alert('Soy botón semántico');
    }

    const btnCancel = document.getElementById("cancel");
    // btnCancel.onclick = () => mostrarAlerta;
    btnCancel.onclick = mostrarAlerta;

    // Función llenar tabla
    // const llenarTabla = () => {
    //     const tabla = document.getElementById("tabla");
    //     for (let i = 0; i < 10; i++){
    //         let fila = tabla.insertRow(i);
    //         let celda1 = fila.insertCell(0);
    //         let celda2 = fila.insertCell(1);
    //         celda1.innerHTML = "Celda 1 nueva";
    //         celda2.innerHTML = "Celda 2 nueva";
    //     }
    // }
    // llenarTabla();
}