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

    pageController.solarList= JSON.parse(request.responseText);

    pageController.solarList.sort(function(a,b) {
        return a.coordinatePlanetNumber - b.coordinatePlanetNumber;
    });

    window.mapnavigator = new function(){
        this.fullsolar = null;
        this.returnfoundsolarlist = null;
        $(document).ready(function(){

            document.getElementById("planetCoordinate").innerHTML = "";

            var akarmi = pageController.solarList.length;
            var tomb = new Array();
            for(szam=0; szam<akarmi; szam++){
                tomb.push(pageController.solarList[szam].coordinatePlanetNumber);
            }
            console.log(tomb);

            var coordinateFullSolar = "Bolygo";
            var planetName = "nev";
            var mon = "hold";
            var debris = "tormelek";
            var name = "jatekosnev";
            var covenant = "szovetseg";
            var operation = "muvelet";
            var tr = document.createElement("tr");
            var td = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");
            var td5 = document.createElement("td");
            var td6 = document.createElement("td");
            var td7 = document.createElement("td");
            td.innerHTML = coordinateFullSolar;
            td2.innerHTML = planetName;
            td3.innerHTML = mon;
            td4.innerHTML = debris;
            td5.innerHTML = name;
            td6.innerHTML = covenant;
            td7.innerHTML = operation;
            td.setAttribute("class", "planetCoordinate");
            td2.setAttribute("class", "planetName");
            td3.setAttribute("class", "mon");
            td4.setAttribute("class", "debris");
            td5.setAttribute("class", "name");
            td6.setAttribute("class", "covenant");
            td7.setAttribute("class", "operation");
            tr.appendChild(td);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);
            tr.appendChild(td6);
            tr.appendChild(td7);
            tr.setAttribute("class", "solarList_tr_menu");
            document.getElementById("planetCoordinate").appendChild(tr);

            for(i=1; i<=12; i++) {
                if(tomb.indexOf(i)>-1){
                    var coordinateFullSolar = pageController.solarList[tomb.indexOf(i)].coordinateFull;
                    var planetName = "nev";
                    var mon = "hold";
                    var debris = "tormelek";
                    var name = pageController.solarList[tomb.indexOf(i)].userName;
                    var covenant = "szovetseg";
                    var operation = "muvelet";
                    var tr = document.createElement("tr");
                    var td = document.createElement("td");
                    var td2 = document.createElement("td");
                    var td3 = document.createElement("td");
                    var td4 = document.createElement("td");
                    var td5 = document.createElement("td");
                    var td6 = document.createElement("td");
                    var td7 = document.createElement("td");
                    td.innerHTML = coordinateFullSolar;
                    td2.innerHTML = planetName;
                    td3.innerHTML = mon;
                    td4.innerHTML = debris;
                    td5.innerHTML = name;
                    td6.innerHTML = covenant;
                    td7.innerHTML = operation;
                    td.setAttribute("class", "planetCoordinate");
                    td2.setAttribute("class", "planetName");
                    td3.setAttribute("class", "mon");
                    td4.setAttribute("class", "debris");
                    td5.setAttribute("class", "name");
                    td6.setAttribute("class", "covenant");
                    td7.setAttribute("class", "operation");
                    tr.appendChild(td);
                    tr.appendChild(td2);
                    tr.appendChild(td3);
                    tr.appendChild(td4);
                    tr.appendChild(td5);
                    tr.appendChild(td6);
                    tr.appendChild(td7);
                    tr.setAttribute("class", "solarList_tr_busy");
                    document.getElementById("planetCoordinate").appendChild(tr);
                }else{
                    var coordinateFullSolar = i;
                    var planetName = "";
                    var mon = "";
                    var debris = "";
                    var name = "";
                    var covenant = "";
                    var operation = "muvelet";
                    var tr = document.createElement("tr");
                    var td = document.createElement("td");
                    var td2 = document.createElement("td");
                    var td3 = document.createElement("td");
                    var td4 = document.createElement("td");
                    var td5 = document.createElement("td");
                    var td6 = document.createElement("td");
                    var td7 = document.createElement("td");
                    td.innerHTML = coordinateFullSolar;
                    td2.innerHTML = planetName;
                    td3.innerHTML = mon;
                    td4.innerHTML = debris;
                    td5.innerHTML = name;
                    td6.innerHTML = covenant;
                    td7.innerHTML = operation;
                    td.setAttribute("class", "planetCoordinate");
                    td2.setAttribute("class", "planetName");
                    td3.setAttribute("class", "mon");
                    td4.setAttribute("class", "debris");
                    td5.setAttribute("class", "name");
                    td6.setAttribute("class", "covenant");
                    td7.setAttribute("class", "operation");
                    tr.appendChild(td);
                    tr.appendChild(td2);
                    tr.appendChild(td3);
                    tr.appendChild(td4);
                    tr.appendChild(td5);
                    tr.appendChild(td6);
                    tr.appendChild(td7);
                    tr.setAttribute("class", "solarList_tr_free");
                    document.getElementById("planetCoordinate").appendChild(tr);
                }
            }
        })
    }
}
