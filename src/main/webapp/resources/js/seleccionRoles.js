    const rolesDisponibles = document.getElementById('roles-disponibles');
    const rolesAsignados = document.getElementById('roles-asignados');
    const btnAddRole = document.getElementById('btn-add-role');
    const btnRemoveRole = document.getElementById('btn-remove-role');

    btnAddRole.addEventListener('click', () => {
        const selectedOptions = Array.from(rolesDisponibles.selectedOptions);
        selectedOptions.forEach((option) => {
            rolesAsignados.appendChild(option);
        });
    });

    btnRemoveRole.addEventListener('click', () => {
        const selectedOptions = Array.from(rolesAsignados.selectedOptions);
        selectedOptions.forEach((option) => {
            rolesDisponibles.appendChild(option);
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