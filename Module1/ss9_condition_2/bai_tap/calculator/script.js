let input = "";
let result = "";
function hasRepeatedOperator(str) {
  return /([^0-9])\1{1,}/.test(str);
}
function checkInput() {
    if (input == "") {
        result = 0;
        return false;
    }
    else if (input.match("/0")) {
        result = "Cannot devide by zero";
        return false;
    }
    else if (hasRepeatedOperator(input)) {
        result = "Syntax error";
        return false;
    }
    else {
        return true
    }
}
function appendNumber(number) {
    input += number;
    document.getElementById("display").value = input;
}
function appendOperator(operator) {
    input += operator;
    document.getElementById("display").value = input;
}
function calculate() {
    if (!checkInput()) {
        document.getElementById("display").value = result;
        input = "";
        result = "";
        return
    }
    result = eval(input);
    input = result;
    document.getElementById("display").value = result;
}
function clearDisplay() {
    input = '';
    result = '';
    document.getElementById('display').value = '0';
}