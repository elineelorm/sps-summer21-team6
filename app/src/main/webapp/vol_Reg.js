
var currentTab = 0; 
showTab(currentTab); 
console.log(currentTab);

function showTab(n) {
var tab = document.getElementsByClassName("tab");
tab[n].style.display = "block";
if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
} else {
    document.getElementById("prevBtn").style.display = "inline";
}
if (n == (tab.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
} else {
    document.getElementById("nextBtn").innerHTML = "Next";
}
fixStepIndicator(n)
}

function nextPrev(n) {
var tab = document.getElementsByClassName("tab");
if (n == 1 && !validateForm()) return false;
tab[currentTab].style.display = "none";
currentTab = currentTab + n;
if (currentTab >= tab.length) {
    document.getElementById("v_regForm").submit();
    return false;
}
showTab(currentTab);
}

function validateForm() {
var tab, input, i, valid = true;
tab = document.getElementsByClassName("tab");
input = tab[currentTab].getElementsByTagName("input");
for (i = 0; i < input.length; i++) {
    if (input[i].value == "") {
    input[i].className += " invalid";
    valid = false;
    }
}
if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
}
return valid;
}

function fixStepIndicator(n) {
var i, step = document.getElementsByClassName("step");
for (i = 0; i < step.length; i++) {
    step[i].className = step[i].className.replace(" active", "");
}
step[n].className += " active";
}

function showPassword() {
    var password = document.getElementById("myInput");
    if (password.type === "password") {
        password.type = "text";
    } else {
        password.type = "password";
  }
}