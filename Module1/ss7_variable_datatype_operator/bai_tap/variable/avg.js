function checkInput1() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let num3 = document.getElementById("num3").value;
    if (num1 === '' || num2 === '' || num3 === '') {
        alert("Bài tập 1: Vui lòng nhập đầy đủ điểm cho 3 môn.");
        return false;
    }
    else if (isNaN(num1) || isNaN(num2) || isNaN(num3)) {
        alert("Bài tập 1: Vui lòng nhập đúng định dạng số.");
        return false;
    }
    else if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10 || num3 < 0 || num3 > 10) {
        alert("Bài tập 1: Điểm phải nằm trong khoảng từ 0 đến 10.");
        return false;
    }
    return true;
}
function calculateAverage() {
    if (!checkInput()) {
        return;
    }
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let num3 = parseFloat(document.getElementById("num3").value);
    let average = (num1 + num2 + num3) / 3;
    document.getElementById("result1").innerHTML = `Trung bình: ${average.toFixed(2)}`;
}
function resetFields1() {
    document.getElementById("num1").value = '';
    document.getElementById("num2").value = '';
    document.getElementById("num3").value = '';
    document.getElementById("result1").innerHTML = '';
}