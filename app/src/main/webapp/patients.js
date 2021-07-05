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