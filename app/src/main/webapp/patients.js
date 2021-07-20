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

    var json_to_html_tag = document.getElementsByClassName("patient-profile profile");
    for (i = 0; i < json_to_html_tag.length; i++) {
        var my_json = JSON.stringify(textFromResponse[i]);
        var patient = JSON.parse(my_json);

        console.log(patient);

        json_to_html_tag[i].appendChild(createPatient(patient));
    }

}

function createPatient(patient) {
    let patientDiv = document.createElement('div');
    
    let nameDiv = document.createElement('div');
    patientDiv.appendChild(nameDiv);
    nameDiv.textContent = "Name: " + patient.name;
    
    let ageDiv = document.createElement('div');
    patientDiv.appendChild(ageDiv);
    ageDiv.textContent = "Age: " + patient.age;
    
    let symptomsDiv = document.createElement('div');
    patientDiv.appendChild(symptomsDiv);
    symptomsDiv.textContent = "May have: " + patient.symptoms;
    
    return patientDiv;
}

function on() {
  document.getElementById("myProfileOverlay").style.display = "block";
}

function off() {
  document.getElementById("myProfileOverlay").style.display = "none";
}