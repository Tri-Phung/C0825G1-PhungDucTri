function checkInput3() {
    let radius = document.getElementById("radius").value;
    if (radius === "") {
        alert("Vui lòng nhập vào bán kính.");
        return false;
    }
    if (isNaN(radius) || radius <= 0) {
        alert("Vui lòng nhập số hợp lệ cho bán kính.");
        return false;
    }
    return true;
}
function calculateArea() {
    if (!checkInput3()) {
        return;
    }
    let radius = parseFloat(document.getElementById("radius").value);
    let area = Math.PI * Math.pow(radius, 2);
    document.getElementById("area").innerHTML = area.toFixed(2);
}
function resetFields3() {
    document.getElementById("radius").value = "";
    document.getElementById("area").innerHTML = "";
}