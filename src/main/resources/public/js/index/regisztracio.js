function regisztracio(){
	var reg_felhasznalonev = document.getElementById("reg_felhasznalonev").value;
	var reg_jelszo = document.getElementById("reg_jelszo").value;
	var reg_email = document.getElementById("reg_email").value;

	var request = new XMLHttpRequest();
	request.open("POST", "register", 0);
	request.setRequestHeader("Content-Type", "application/json");
	request.setRequestHeader("Request-Type", "rest");

        if(reg_felhasznalonev == ""){
            notificationService.showError("Felhasznalonev megadasa kotelezo!");
            return;
        }else if(reg_felhasznalonev.length < 5){
            notificationService.showError("A felhasznalonev minimum 5 karakter kell legyen!");
            return;
        }else if(reg_felhasznalonev.length > 15){
            notificationService.showError("A felhasznalonev maximum 15 karakter lehet!");
            return;
        }else if(isUserNameExists(reg_felhasznalonev)){
            notificationService.showError("A felhasznalonevmár regisztrálva van.");
            return;
        }

        if(reg_jelszo == ""){
            notificationService.showError("Jelszo megadasa kotelezo!");
            return;
        }else if(reg_jelszo.length < 5){
            notificationService.showError("A Jelszo minimum 5 karakter kell legyen!");
            return;
        }else if(reg_jelszo.length > 15){
            notificationService.showError("A Jelszo maximum 15 karakter lehet!");
            return;
        }

        if(reg_email == ""){
            notificationService.showError("Email cim megadasa kotelezo!");
            return;
        }else if(!isEmailValid(reg_email)){
            notificationService.showError("Ervenytelen email!");
            return;
        }
        const data = {
        	    userName: reg_felhasznalonev,
        	    password: reg_jelszo,
        	    email: reg_email
        	};
        	request.send(JSON.stringify(data));

        if(request.responseText == 0){
            notificationService.showSuccess("Sikeres regisztráció!");
        }

    function isEmailValid(email){
        let result;
        if(email == null || email == undefined){
            result = false;
        }else if(email.indexOf("@") < 1){
            result = false;
        }else if(email.lenght < 4){
            result = false;
        }else if(email.indexOf(".") < 0){
            result = false;
        }else if(email.lastIndexOf(".") > email.length - 3){
            result = false;
        }else{
            result = true;
        }
        return result;
    }

    function isUserNameExists(userName){
        var request = new XMLHttpRequest();
        	request.open("POST", "/user/name/exist", 0);
        	request.setRequestHeader("Content-Type", "application/json");
        	request.setRequestHeader("Request-Type", "rest");

        	const data = {
        	    value: userName
        	};

        	request.send(JSON.stringify(data));

        	return request.status != 404;
    }
}