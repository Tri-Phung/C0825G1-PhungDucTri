function checkInput4() {
    let radius2 = document.getElementById("radius2").value;
    if (radius2 === "") {
        alert("Vui lòng nhập vào bán kính.");
        return false;
    }
    if (isNaN(radius2) || radius2 <= 0) {
        alert("Vui lòng nhập số hợp lệ cho bán kính.");
        return false;
    }
    return true;
}
function calculatePerimeter() {
    if (!checkInput4()) {
        return;
    }
    let radius2 = parseFloat(document.getElementById("radius2").value);
    let perimeter = 2 * Math.PI * radius2;
    document.getElementById("perimeter").innerHTML = perimeter.toFixed(2);
}
function resetFields4() {
    document.getElementById("radius2").value = "";
    document.getElementById("perimeter").innerHTML = "";
}