function checkInput2() {
    let celsius = document.getElementById("celsius").value;
    if (celsius === '') {
        alert("Bài tập 2: Vui lòng nhập độ C.");
        return false;
    }
    else if (isNaN(celsius)) {
        alert("Bài tập 2: Vui lòng nhập đúng định dạng số.");
        return false;
    }
    return true;
}
function convertCtoF() {
    if (!checkInput2()) {
        return;
    }
    let celsius = parseFloat(document.getElementById("celsius").value);
    let fahrenheit = (9 / 5) * celsius + 32;
    document.getElementById("fahrenheit").innerHTML = fahrenheit;
}
function resetFields2() {
    document.getElementById("celsius").value = '';
    document.getElementById("fahrenheit").innerHTML = '';
}