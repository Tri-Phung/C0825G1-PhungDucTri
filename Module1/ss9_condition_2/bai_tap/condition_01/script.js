function checkIfANumber(input) {
    if (isNaN(input)) {
        return false;
    }
    else if (input === '') {
        return false;
    }
    return true;
}
//Bai 1
function checkIfDivisible() {
    let input_a = document.getElementById("inputA").value;
    let input_b = document.getElementById("inputB").value;
    if (!checkIfANumber(input_a)||!checkIfANumber(input_b)) {
        document.getElementById("output1").innerHTML = "Please input a number!";
        return;
    }
    if (input_b == 0) {
        document.getElementById("output1").innerHTML = 'can not devide by zero';
    }
    else if ((input_a%input_b) == 0) {
        document.getElementById("output1").innerHTML = 'a is divisible by b';
    }
    else {
        document.getElementById("output1").innerHTML = 'a is not divisible by b';
    }
}

//Bai 2
function checkIfAgeEnough() {
    let age = document.getElementById("inputAge").value;
    if (!checkIfANumber(age)) {
        document.getElementById('output2').innerHTML = 'Please input a number of age';
        return;
    }
    if (age >= 15) {
        document.getElementById('output2').innerHTML = 'Pass';
    }
    else {
        document.getElementById('output2').innerHTML = 'Fail';
    }
}

//Bai 3
function compareToZero() {
    let int = +document.getElementById('inputInteger').value;
    if (!checkIfANumber(int)) {
        document.getElementById('output3').innerHTML = 'Please input a number';
        return;
    }
    if (!Number.isInteger(int)) {
        document.getElementById('output3').innerHTML = 'Please input an integer';
    }
    else if (int > 0) {
        document.getElementById('output3').innerHTML = "Input number is greater than 0";

    }
    else if (int == 0) {
        document.getElementById('output3').innerHTML = "Input number is equal to 0";

    }
    else if (int < 0) {
        document.getElementById('output3').innerHTML = "Input number is less than 0";

    }
}

//Bai 4
function findMax() {
    let num1 = document.getElementById('inputNum1').value;
    let num2 = document.getElementById('inputNum2').value;
    let num3 = document.getElementById('inputNum3').value;
    if (!checkIfANumber(num1) || !checkIfANumber(num2) || !checkIfANumber(num3)) {
        document.getElementById('output4').innerHTML = 'Please input a number';
        return;
    }
    let max = num1;
    if (num2 > max) {
        max = num2;
    }
    if (num3 > max) {
        max = num3
    }
    document.getElementById('output4').innerHTML = `Max is ${max}`;
}

//Bai 5
function checkScore(score) {
    if (score < 0 || score >10) {
        return false;
    }
    return true;
}

function ranking() {
    let score1 = +document.getElementById('inputScore1').value;
    let score2 = +document.getElementById('inputScore2').value;
    let score3 = +document.getElementById('inputScore3').value;
    if (!checkIfANumber(score1) || !checkIfANumber(score2) || !checkIfANumber(score3)) {
        document.getElementById('output5').innerHTML = 'Please input a score';
        return;
    }
    if (!checkScore(score1) || !checkScore(score2) || !checkScore(score3)) {
        document.getElementById('output5').innerHTML = 'Please input a score from 0 to 10';
        return
    }
    let average = (score1 + score2 * 2 + score3 * 3)/6;
    if (average >= 9) {
        document.getElementById('output5').innerHTML = "Excellent";
    }
    else if (average >= 7) {
        document.getElementById('output5').innerHTML = "Good";
    }
    else if (average >= 5) {
        document.getElementById('output5').innerHTML = "Average";
    }
    else {
        document.getElementById('output5').innerHTML = "Poor";
    }
}

//Bai 6
function commission() {
    let sale = +document.getElementById('sale').value;
    let percent = +document.getElementById('percentageCommission').value;
    if (!checkIfANumber(sale)) {
        document.getElementById('output6').innerHTML = 'Please input a number of Money ($)';
        return;
    }
    if (!checkIfANumber(percent) || percent < 0 ) {
        document.getElementById('output6').innerHTML = 'Please input a number of percentage > 0';
        return;
    }
    let commission = sale * (percent/100);
    document.getElementById("output6").innerHTML = `Commission is ${commission}`;
}

//Bai 7
function phoneBill() {
    let callin = +document.getElementById('callInternal').value;
    let callex = +document.getElementById('callExternal').value;
    let data = +document.getElementById('data').value;
    let smsin = +document.getElementById('smsInternal').value;
    let smsex = +document.getElementById('smsExternal').value;
    let callin_price = 1190;
    let callex_price = 1390;
    let data_price = 60;
    let smsin_price = 300;
    let smsex_price = 350;
    let bill = callin*callin_price + callex*callex_price + data*data_price + smsin*smsin_price + smsex*smsex_price
    if (!checkIfANumber(callin) || !checkIfANumber(callex) || !checkIfANumber(data) || !checkIfANumber(smsin) || !checkIfANumber(smsex)) {
        document.getElementById('output7').innerHTML = 'Invalid input';
        return;
    }
    if (callin < 0 || callex < 0 || data < 0 || smsin < 0 || smsex < 0) {
        document.getElementById('output7').innerHTML = 'Input must be greater than 0';
        return;
    }
    document.getElementById('output7').innerHTML = `${bill} VND`;
}