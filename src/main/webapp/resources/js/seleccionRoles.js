//FUNCION QUE PERMITE ESPERAR A QUE EL DOM ESTE COMPLETAMENTE CARGADO PARA DISPONER DE LAS FUNCIONES
document.addEventListener("DOMContentLoaded", () => {
	const rolesDisponibles = document.getElementById('roles-disponibles');
    const rolesAsignados = document.getElementById('roles-asignados');
    const btnAddRole = document.getElementById('btn-add-role');
    const btnRemoveRole = document.getElementById('btn-remove-role');


	//SCRIPT PARA AGREGAR ROLES
	btnAddRole.addEventListener('click', () => {
	  const selectedOptions = Array.from(rolesDisponibles.selectedOptions);
	  selectedOptions.forEach((option) => {
	    // Verificar si el elemento ya existe en la lista de roles asignados
	    const roleExists = Array.from(rolesAsignados.options).some((item) => item.value === option.value);
	    if (!roleExists) {
	      rolesAsignados.appendChild(option);
	    }
	  });
	});

  	//SCRIPT PARA REMOVER ROLES
	btnRemoveRole.addEventListener('click', () => {
	    const selectedOptions = Array.from(rolesAsignados.selectedOptions);
	    selectedOptions.forEach((option) => {
	        const optionExists = Array.from(rolesDisponibles.options).some((item) => item.value === option.value);
	        if (!optionExists) {
	            rolesDisponibles.appendChild(option);
	        }
	        rolesAsignados.removeChild(option);
	    });
	});


    
	//SCRIPT QUE CONTROLA EL CAMBIO DE VALUE DE 1 O 0 DEL CHECKBOX PARA LUEGO SER ENVIADO AL CONTROLADOR Y SETEE A ENABLED EL USUARIO.
	let enabledCheckbox = document.getElementById('enabled-visible');
	let enabledHidden = document.getElementById('enabled-hidden');

	enabledCheckbox.addEventListener('click', function() {
		if (enabledCheckbox.checked) {
    		enabledHidden.value = 1;
   			//alert("on")
		} else {
    		enabledHidden.value = 0;
    		//alert("off")
		}
	 });
})