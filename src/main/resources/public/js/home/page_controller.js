(function PageController(){
	window.pageController = new function(){
	    this.user = null;
	    this.solar = null;

		$(document).ready(function(){
		    logService.log(pageController.user);
			loadUser();
            logService.log(pageController.user);
            var userid = pageController.user.id;
            var username = pageController.user.userName;
            var planetnumber = pageController.user.planetNumber;


            document.getElementById("userid").innerHTML = userid;
            document.getElementById("username").innerHTML = username;
            document.getElementById("planetnumber").innerHTML = planetnumber;

            logService.log(pageController.solar);
            loadSolar();
            logService.log(pageController.solar);


            for(i=0; i<=planetnumber; i++) {
            var coordinateFull = pageController.solar[i].coordinateFull;
            var div = document.createElement("div");
            div.style.cssText = "border-width: 4px;border-style: outset;border-color: rgb(38, 38, 38);border-radius: 10px 10px 10px 10px;height: 30px;width: 170px;color: white;";
            div.innerHTML = coordinateFull;
            document.getElementById("coordinateFull").appendChild(div);
            }


		})
	}

	function loadUser(){
		var request = new XMLHttpRequest();
        	request.open("GET", "/user", 0);
        	request.setRequestHeader("Content-Type", "application/json");
        	request.setRequestHeader("Request-Type", "rest");

        	request.send();

        	pageController.user = JSON.parse(request.responseText);
	}
	function loadSolar(){
        var request = new XMLHttpRequest();
            request.open("GET", "/solar", 0);
            request.setRequestHeader("Content-Type", "application/json");
            request.setRequestHeader("Request-Type", "rest");

            request.send();

            pageController.solar = JSON.parse(request.responseText);
    }
})();