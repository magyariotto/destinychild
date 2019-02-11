function betoltes(){
    var universenumberinput = document.getElementById("universenumber").value;
    var systemnumberinput = document.getElementById("systemnumber").value;

    var request = new XMLHttpRequest();
    request.open("POST", "fullsolarsearch", 0);
    request.setRequestHeader("Content-Type", "application/json");
    request.setRequestHeader("Request-Type", "rest");

    const data = {
        universenumber: universenumberinput,
        systemnumber: systemnumberinput
    };
    request.send(JSON.stringify(data));
    document.getElementById('datum').innerHTML=Date();
    window.mapnavigator = new function(){
        this.fullsolar = null;
        this.returnfoundsolarlist = null;
        $(document).ready(function(){

            loadFullSolar();


            document.getElementById("fullsolar").innerHTML = "";
            for(i=0; i<=10; i++) {
                var coordinateFullsolar = pageController.fullsolar[i].coordinateFull;
                var tr = document.createElement("tr");
                var td = document.createElement("td");
                td.innerHTML = coordinateFullsolar;
                td.setAttribute("class", "planet_coordinate");
                tr.appendChild(td);
                tr.setAttribute("class", "solarlist_tr");
                document.getElementById("fullsolar").appendChild(tr);
            }
        })
    }
    function loadFullSolar(){
        var request = new XMLHttpRequest();
        request.open("GET", "/fullsolar", 0);
        request.setRequestHeader("Content-Type", "application/json");
        request.setRequestHeader("Request-Type", "rest");

        request.send();
        pageController.fullsolar = JSON.parse(request.responseText);
    }
    function loadReturnFound(){
        var request = new XMLHttpRequest();
        request.open("POST", "fullsolarsearch", 0);
        request.setRequestHeader("Content-Type", "application/json");
        request.setRequestHeader("Request-Type", "rest");

        request.send();
        pageController.returnfoundsolarlist= JSON.parse(request.responseText);
    }
}
