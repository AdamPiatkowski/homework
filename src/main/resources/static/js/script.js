const hamburger = document.querySelector(".hamburger");
const nameListBar = document.querySelector(".nav-links");
const links = document.querySelectorAll(".nav-links li");
const menuButton = document.querySelector(".nameLists")
const menuBar = document.querySelector(".menu-bar");
const pageContent = document.querySelector(".myButton");

const listAnswer = document.getElementById("listAnswer");

let nameList;

const nameRequest = new XMLHttpRequest();
nameRequest.open('GET','http://localhost:8080/nameLists/maleList');
nameRequest.onload = function() {
    let res = nameRequest.responseText
    res.insertAdjacentText("afterend","aja");
    rendererHtml(res);
    alert("nie udalo sie")
}
nameRequest.send();

function rendererHtml(data) {
    listAnswer.insertAdjacentText("afterend", data);
}

menuButton.addEventListener("click", () => {
    menuBar.classList.toggle("open");
    pageContent.classList.toggle("open");
})

hamburger.addEventListener("click", () => {
    nameListBar.classList.toggle("open");
    links.forEach(link => {
        link.classList.toggle("fade");
    })});
