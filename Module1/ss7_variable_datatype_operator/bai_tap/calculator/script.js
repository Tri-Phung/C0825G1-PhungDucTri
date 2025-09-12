let currentInput = '';
let previousInput = '';
let currentOperator = '';

function appendNumber(number) {
    currentInput += number;
    document.getElementById('display').value = `${previousInput} ${currentOperator} ${currentInput}`;
}
function appendOperator(operator) {
    if (currentInput === '') return;
    if (previousInput !== '') {
        calculate();
    }
    currentOperator = operator;
    previousInput = currentInput;
    currentInput = '';
    document.getElementById('display').value = `${previousInput} ${currentOperator}`;
}
function calculate() {
    if (previousInput === '' || currentInput === '') return;
    let result;
    let prev = parseFloat(previousInput);
    let curr = parseFloat(currentInput);
    switch (currentOperator) {
        case '+':
            result = prev + curr;
            break;
        case '-':
            result = prev - curr;
            break;
        case '*':
            result = prev * curr;
            break;
        case '/':
            if (curr === 0) {
                alert("Cannot divide by zero!");
                clearDisplay();
                return;
            }
            result = prev / curr;
            break;
        default:
            return;
    }
    currentInput = result.toString();
    previousInput = '';
    currentOperator = '';
    document.getElementById('display').value = currentInput;
    console.log(`crr: ${currentInput}`)
    console.log(`pre: ${previousInput}`)
    console.log(`crrO: ${currentOperator}`)
}
function clearDisplay() {
    currentInput = '';
    previousInput = '';
    currentOperator = '';
    document.getElementById('display').value = '';
}