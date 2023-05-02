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
	        if (rolesAsignados.contains(option)) {
	            rolesAsignados.removeChild(option);
	        } else {
	            const parentElement = option.parentElement;
	            parentElement.removeChild(option);
	        }
	        const optionExists = Array.from(rolesDisponibles.options).some((item) => item.value === option.value);
	        if (!optionExists) {
	            rolesDisponibles.appendChild(option);
	        }
	    });
	});



    
	//----SCRIPT QUE CONTROLA EL CAMBIO DE VALUE DE 1 O 0 DEL CHECKBOX PARA LUEGO SER ENVIADO AL CONTROLADOR Y SETEE A ENABLED EL USUARIO.
	let enabledCheckbox = document.getElementById('enabled-visible');
	let enabledHidden = document.getElementById('enabled-hidden');
	
	//DEJO COMO PREDETERMINADO EL CHECKBOX COMO DESACTIVADO
	enabledHidden.value = 0;
	enabledCheckbox.value = 0;

	enabledCheckbox.addEventListener('click', function() {
		if (enabledCheckbox.checked) {
    		enabledHidden.value = 1;
   			//alert("on")
		} else {
    		enabledHidden.value = 0;
    		//alert("off")
		}
	 });
	 
	 //---OCULTAR MENSAJE AUTOMATICAMENTE---
	 // Obtener el elemento de la alerta
	const alerta = document.getElementById('alerta');

	if(alerta){
		// Establecer un tiempo de espera de 5 segundos antes de eliminar la alerta
		setTimeout(() => {
		  // Disminuir gradualmente la opacidad de la alerta
		  let opacity = 1;
		  const timer = setInterval(() => {
		    if (opacity <= 0.1) {
		      clearInterval(timer);
		      // Eliminar la alerta del DOM después de que se haya desvanecido completamente
		      alerta.style.display = 'none';
		    }
		    alerta.style.opacity = opacity;
		    opacity -= 0.1;
		  }, 50);
		}, 5000);
	}
	

	
	//---VALIDAR INPUTS PASSWORDS
	let inputPassword = document.getElementById("password");
	let inputPassword2 = document.getElementById("password2");
	let btnEnviar = document.getElementById("btnEnviar");
	let errorMessages = document.querySelectorAll(".errorMsg");
		
	inputPassword.addEventListener("input", checkPasswords);
	inputPassword2.addEventListener("input", checkPasswords);
		
	function checkPasswords(){

		if (inputPassword.value === inputPassword2.value) {
	    	btnEnviar.disabled = false;
			errorMessages.forEach((errorMsg) => {
            	errorMsg.style.display = "none";
        	});
	    } else {
	      	btnEnviar.disabled = true;
	      	errorMessages.forEach((errorMsg) => {
            	errorMsg.style.display = "block";
            	errorMsg.innerHTML = "Las Contraseñas deben ser iguales";
        	});
	    }
	}
})