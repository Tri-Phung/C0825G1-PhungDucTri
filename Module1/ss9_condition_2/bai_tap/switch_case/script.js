function checkInput() {
    let inputMonth = document.getElementById("inputMonth").value;
    if (inputMonth === "") {
        alert("input a number")
        return false;
    }
    if (inputMonth < 1 || inputMonth > 12 || isNaN(inputMonth) || !Number.isInteger(parseFloat(inputMonth))){
        alert("number is an integer from 1 to 12")
        return false;
    }
    else {
        return true;
    }
}
function countDay() {
    if (!checkInput()) {
        return;
    }
    let inputMonth = parseInt(document.getElementById("inputMonth").value);
    switch(inputMonth) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            document.writeln(`Tháng ${inputMonth} có 31 ngày`);
            break;
        case 2:
            document.writeln(`Tháng ${inputMonth} có 28 hoặc 29 ngày`);
            break;
        default:
            document.writeln(`Tháng ${inputMonth} có 30 ngày`);
    }
}