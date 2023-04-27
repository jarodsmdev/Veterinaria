/**
 * 
 */

let btnQuitarServicio = document.getElementById("quitarServicio");
let btnAgregarServicio = document.getElementById("agregarServicio");

btnAgregarServicio.addEventListener("click", function(){
	enviarServicio();
});

btnQuitarServicio.addEventListener("click", function(){
	let opcion = document.getElementById("opciones");
	let indiceSeleccionado = opcion.selectedIndex;
	opcion.remove(indiceSeleccionado);
});

function enviarServicio(){
	let servicio = document.getElementById("servicios");
	let opcion = document.getElementById("opciones");
	let valor = servicio.value;
	let texto = servicio.options[servicio.selectedIndex].text;
	opcion.innerHTML += '<option value="' + valor + '">' + texto + '</option>';
};

