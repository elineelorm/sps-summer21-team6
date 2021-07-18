/**
 * Function to display the hidden list content
 * @param {*} tabName 
 */
function openTab(tabName) {
  var i, container;
  container = document.getElementsByClassName("containerTab");
  for (i = 0; i < container.length; i++) {
    container[i].style.display = "none";
  }
  document.getElementById(tabName).style.display = "block";
}

async function addPatients(){
    const responsefromServer = await fetch('/patients');
    const textFromResponse = await responsefromServer.json();

    console.log(textFromResponse);
    console.log("hi");

    var json_to_html_tag = document.getElementById("json_to_html");

    for (let i = 0; i < textFromResponse.length; i++){
            var my_json = JSON.stringify(textFromResponse[i]);
            var parsed_obj = JSON.parse(my_json);
            
            console.log(textFromResponse[i]);

            const element = document.createElement('li');
            element.innerText = textFromResponse[i];

            console.log(element);

            json_to_html_tag.innerHTML =  "New Patient <br><br>" + 
                                "Name: " + element.name + 
                                "<br>Age: " + element.age +
                                "<br>May have: " + element.symptoms;
    }
}