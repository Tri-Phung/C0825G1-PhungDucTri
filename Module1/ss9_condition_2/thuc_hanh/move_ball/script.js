let ball = document.getElementById("ball");
function moveBall() {
    ball.style.left = parseInt(ball.style.left) + 10 + 'px';
}
function upArrowPressed() {
    let element = document.getElementById("ball");
    element.style.top = parseInt(element.style.top) - 10 + 'px';
}
function downArrowPressed() {
    var element = document.getElementById("ball");
    element.style.top = parseInt(element.style.top) + 10 + 'px';
}
function leftArrowPressed() {
    var element = document.getElementById("ball");
    element.style.left = parseInt(element.style.left) - 10 + 'px';
}
function rightArrowPressed() {
    var element = document.getElementById("ball");
    element.style.left = parseInt(element.style.left) + 10 + 'px';

}
function moveSelection(evt) {
    switch (evt.keyCode) {
        case 37:
            leftArrowPressed();
            break;
        case 39:
            rightArrowPressed();
            break;
        case 38:
            upArrowPressed();
            break;
        case 40:
            downArrowPressed();
            break;
    }
}
function addListen() {
    window.addEventListener('keydown', moveSelection);
}