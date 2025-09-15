function checkIfANumber(input) {
    if (isNaN(input)) {
        return false;
    }
    return true;
}
function checkIfaNumberIsInteger(input) {
    if (!Number.isInteger(parseFloat(input))) {
        return false;
    }
    return true;
}

//Bai 1
function convertCtoF() {
    let celsius = document.getElementById("inputC").value;
    if (!checkIfANumber(celsius)) {
        document.getElementById("output1").innerHTML = "Please input a number";
        return;
    }
    else if (celsius === '') {
        document.getElementById("output1").innerHTML = "Please input a number";
        return;
    }
    let fahrenheit = (9 / 5) * celsius + 32;
    document.getElementById("output1").innerHTML = `${celsius}°C = ${fahrenheit}°F`;
}

//Bai 2
function convertMtoFeet() {
    let meter = document.getElementById("inputM").value;
    if (!checkIfANumber(meter)) {
        document.getElementById("output2").innerHTML = "Please input a number";
        return;
    }
    else if (meter === '') {
        document.getElementById("output2").innerHTML = "Please input a number";
        return;
    }
    let feet = meter * 3.2808;
    document.getElementById("output2").innerHTML = `${meter}m = ${feet}ft`;
}

//Bai 3
function calculateSquareArea() {
    let side = document.getElementById("inputSide").value;
    if (!checkIfANumber(side)) {
        document.getElementById("output3").innerHTML = "Please input a number";
        return;
    }
    else if (side === '') {
        document.getElementById("output3").innerHTML = "Please input a number";
        return;
    }
    else if (side <= 0) {
        document.getElementById("output3").innerHTML = "Please input a number greater than 0";
        return;
    }
    let area = side * side;
    document.getElementById("output3").innerHTML = `Diện tích hình vuông là ${area}`;
}

//Bai 4
function calculateRectangleArea() {
    let sideA = document.getElementById("inputSideA").value;
    let sideB = document.getElementById("inputSideB").value;
    if (!checkIfANumber(sideA) || !checkIfANumber(sideB)) {
        document.getElementById("output4").innerHTML = "Please input a number";
        return;
    }
    else if (sideA === '' || sideB === '') {
        document.getElementById("output4").innerHTML = "Please input a number";
        return;
    }
    else if (sideA <= 0 || sideB <= 0) {
        document.getElementById("output4").innerHTML = "Please input a number greater than 0";
        return;
    }
    let area = sideA * sideB;
    document.getElementById("output4").innerHTML = `Diện tích hình chữ nhật là ${area}`;
}

//Bai 5
function calculateTriangleArea() {
    let side1 = document.getElementById("inputSide1").value;
    let side2 = document.getElementById("inputSide2").value;
    if (!checkIfANumber(side1) || !checkIfANumber(side2)) {
        document.getElementById("output5").innerHTML = "Please input a number";
        return;
    }
    else if (side1 === '' || side2 === '') {
        document.getElementById("output5").innerHTML = "Please input a number";
        return;
    }
    else if (side1 <= 0 || side2 <= 0) {
        document.getElementById("output5").innerHTML = "Please input a number greater than 0";
        return;
    }
    let area = (side1 * side2) / 2;
    document.getElementById("output5").innerHTML = `Diện tích hình tam giác vuông là ${area}`;
}

//Bai 6
function solveLinearEquation() {
    let a = document.getElementById("inputA").value;
    let b = document.getElementById("inputB").value;
    if (!checkIfANumber(a) || !checkIfANumber(b)) {
        document.getElementById("output6").innerHTML = "Please input a number";
        return;
    }
    else if (a === '' || b === '') {
        document.getElementById("output6").innerHTML = "Please input a number";
        return;
    }
    else if (a == 0) {
        if (b == 0) {
            document.getElementById("output6").innerHTML = "Phương trình có vô số nghiệm";
        }
        else {
            document.getElementById("output6").innerHTML = "Phương trình vô nghiệm";
        }
    }
    else {
        let x = -b / a;
        document.getElementById("output6").innerHTML = `Phương trình bậc 1 có nghiệm là ${x}`;
    }
}
function resetField6() {
    document.getElementById("inputA").value = '';
    document.getElementById("inputB").value = '';
    document.getElementById("output6").innerHTML = '';
}

//Bai 7
function solveQuadraticEquation() {
    let a = document.getElementById("inputA2").value;
    let b = document.getElementById("inputB2").value;
    let c = document.getElementById("inputC2").value;
    let delta = b*b - 4*a*c;
    if (!checkIfANumber(a) || !checkIfANumber(b) || !checkIfANumber(c)) {
        document.getElementById("output7").innerHTML = "Please input a number";
        return;
    }
    else if (a === '' || b === '' || c === '') {
        document.getElementById("output7").innerHTML = "Please input a number";
        return;
    }
    else if (a == 0) {
        document.getElementById("output7").innerHTML = "a must not be 0";
        return;
    }
    else if (delta < 0) {
        document.getElementById("output7").innerHTML = "Phương trình vô nghiệm";
        return;
    }
    else if (delta == 0) {
        let x = -b / (2*a);
        document.getElementById("output7").innerHTML = `Phương trình bậc 2 có nghiệm kép là ${x}`;
        return;
    }
    else {
        let x1 = (-b + Math.sqrt(delta)) / (2*a);
        let x2 = (-b - Math.sqrt(delta)) / (2*a);
        document.getElementById("output7").innerHTML = `Phương trình bậc 2 có 2 nghiệm là ${x1} và ${x2}`;
        return;
    }
}
function resetField7() {
    document.getElementById("inputA2").value = '';
    document.getElementById("inputB2").value = '';
    document.getElementById("inputC2").value = '';
    document.getElementById("output7").innerHTML = '';
}

//Bai 8
function checkIfAge() {
    let age = document.getElementById("inputInteger").value;
    if (!checkIfANumber(age)) {
        document.getElementById("output8").innerHTML = "Please input a number";
        return;
    }
    else if (age === '') {
        document.getElementById("output8").innerHTML = "Please input a number";
        return;
    }
    else if (!checkIfaNumberIsInteger(age)) {
        document.getElementById("output8").innerHTML = "Please input an integer";
        return;
    }
    else if (age <= 0 || age >= 120) {
        document.getElementById("output8").innerHTML = "Please input a number between 0 and 120";
        return;
    }
    else {
        document.getElementById("output8").innerHTML = "Đây là tuổi của một người";
    }
}
function resetField8() {
    document.getElementById("inputInteger").value = '';
    document.getElementById("output8").innerHTML = '';
}

//Bai 9
function checkIfTriangle() {
    let a = +document.getElementById("inputSideA9").value;
    let b = +document.getElementById("inputSideB9").value;
    let c = +document.getElementById("inputSideC9").value;

    if (!checkIfANumber(a) || !checkIfANumber(b) || !checkIfANumber(c)) {
        document.getElementById("output9").innerHTML = "Please input a number";
        return;
    }
    else if (a === '' || b === '' || c === '') {
        document.getElementById("output9").innerHTML = "Please input a number";
        return;
    }
    else if (a <= 0 || b <= 0 || c <= 0) {
        document.getElementById("output9").innerHTML = "Please input a number greater than 0";
        return;
    }
    else if (a + b > c && a + c > b && b + c > a) {
        document.getElementById("output9").innerHTML = "Đây là 3 cạnh của một tam giác";
        return;
    }
    else {
        document.getElementById("output9").innerHTML = "Đây không phải là 3 cạnh của một tam giác";
        return;
    }
}
function resetField9() {
    document.getElementById("inputSideA9").value = '';
    document.getElementById("inputSideB9").value = '';
    document.getElementById("inputSideC9").value = '';
    document.getElementById("output9").innerHTML = '';
}

//Bai 10
function calculateElectricityBill() {
    let kWh = document.getElementById("inputKWh").value;
    let VAT = 1.08;
    let price1 = 1984;
    let price2 = 2050;
    let price3 = 2380;
    let price4 = 2998;
    let price5 = 3350;
    let price6 = 3460;
    let bill = 0;
    if (!checkIfANumber(kWh)) {
        document.getElementById("output10").innerHTML = "Please input a number";
        return;
    }
    else if (kWh === '') {
        document.getElementById("output10").innerHTML = "Please input a number";
        return;
    }
    else if (kWh <= 0) {
        document.getElementById("output10").innerHTML = "Please input a number greater than 0";
        return;
    }
    else if (kWh <= 50) {
        bill = kWh * price1;
    }
    else if (kWh <= 100) {
        bill = 50 * price1 + (kWh - 50) * price2;
    }
    else if (kWh <= 200) {
        bill = 50 * price1 + 50 * price2 + (kWh - 100) * price3;
    }
    else if (kWh <= 300) {
        bill = 50 * price1 + 50 * price2 + 100 * price3 + (kWh - 200) * price4;
    }
    else if (kWh <= 400) {
        bill = 50 * price1 + 50 * price2 + 100 * price3 + 100 * price4 + (kWh - 300) * price5;
    }
    else {
        bill = 50 * price1 + 50 * price2 + 100 * price3 + 100 * price4 + 100 * price5 + (kWh - 400) * price6;
    }
    document.getElementById("output10").innerHTML = `Tổng tiền điện cả thuế VAT là ${bill * VAT} VND`;
}
function resetField10() {
    document.getElementById("inputKWh").value = '';
    document.getElementById("output10").innerHTML = '';
}

//Bai 11
function calculatePersonalIncomeTax() {
    let totalIncome = document.getElementById("totalIncome").value;
    let dependents = document.getElementById("dependents").value;
    let insurance = document.getElementById("insurance").value;
    let charity = document.getElementById("charity").value;
    
    if (!checkIfANumber(totalIncome) || totalIncome === '') {
        document.getElementById("output11").innerHTML = "Invalid total income input";
        return;
    }
    
    if (!checkIfANumber(insurance) || insurance === '') {
        document.getElementById("output11").innerHTML = "Invalid insurance input";
        return;
    }
    
    if (!checkIfANumber(charity)) {
        document.getElementById("output11").innerHTML = "Invalid charity input";
        return;
    }
    if (charity === '') {
        charity = 0;
    }

    if (!checkIfANumber(dependents)) {
        document.getElementById("output11").innerHTML = "Invalid dependents input";
        return;
    }
    if (dependents === '') {
        dependents = 0;
    }
    
    totalIncome = parseFloat(totalIncome);
    dependents = parseInt(dependents);
    insurance = parseFloat(insurance);
    charity = parseFloat(charity);
    
    if (totalIncome < 0 || insurance < 0 || charity < 0 || dependents < 0) {
        document.getElementById("output11").innerHTML = "Values cannot be less than 0";
        return;
    }
    
    let personalDeduction = 11000000;
    let dependentDeduction = dependents * 4400000;
    let totalDeductions = personalDeduction + dependentDeduction + insurance + charity;
    
    let incomeToTax = totalIncome - totalDeductions;
    
    if (incomeToTax <= 0) {
        document.getElementById("output11").innerHTML = "Thuế TNCN phải nộp: 0 VND";
        return;
    }
    
    let tax = 0;
    let remainingIncome = incomeToTax;
    
    if (remainingIncome > 5000000) {
        tax += 5000000 * 0.05;
        remainingIncome -= 5000000;
    } else {
        tax += remainingIncome * 0.05;
        remainingIncome = 0;
    }
    
    if (remainingIncome > 0) {
        if (remainingIncome > 5000000) {
            tax += 5000000 * 0.10;
            remainingIncome -= 5000000;
        } else {
            tax += remainingIncome * 0.10;
            remainingIncome = 0;
        }
    }

    if (remainingIncome > 0) {
        if (remainingIncome > 8000000) {
            tax += 8000000 * 0.15;
            remainingIncome -= 8000000;
        } else {
            tax += remainingIncome * 0.15;
            remainingIncome = 0;
        }
    }

    if (remainingIncome > 0) {
        if (remainingIncome > 14000000) {
            tax += 14000000 * 0.20;
            remainingIncome -= 14000000;
        } else {
            tax += remainingIncome * 0.20;
            remainingIncome = 0;
        }
    }

    if (remainingIncome > 0) {
        if (remainingIncome > 20000000) {
            tax += 20000000 * 0.25;
            remainingIncome -= 20000000;
        } else {
            tax += remainingIncome * 0.25;
            remainingIncome = 0;
        }
    }

    if (remainingIncome > 0) {
        if (remainingIncome > 28000000) {
            tax += 28000000 * 0.30;
            remainingIncome -= 28000000;
        } else {
            tax += remainingIncome * 0.30;
            remainingIncome = 0;
        }
    }

    if (remainingIncome > 0) {
        tax += remainingIncome * 0.35;
    }
    
    document.getElementById("output11").innerHTML = `Thuế TNCN phải nộp: ${tax} VND`;
}

function resetField11() {
    document.getElementById("totalIncome").value = '';
    document.getElementById("dependents").value = '';
    document.getElementById("insurance").value = '';
    document.getElementById("charity").value = '';
    document.getElementById("output11").innerHTML = '';
}

//Bai 12
function calculateCompoundInterest() {
    let principal = document.getElementById("principal").value;
    let months = document.getElementById("months").value;
    let monthlyRate = document.getElementById("monthlyRate").value;

    if (!checkIfANumber(principal) || principal === '') {
        document.getElementById("output12").innerHTML = "Invalid principal amount input";
        return;
    }
    
    if (!checkIfANumber(months) || months === '') {
        document.getElementById("output12").innerHTML = "Invalid months input";
        return;
    }
    
    if (!checkIfANumber(monthlyRate) || monthlyRate === '') {
        document.getElementById("output12").innerHTML = "Invalid monthly rate input";
        return;
    }
    
    principal = parseFloat(principal);
    months = parseInt(months);
    monthlyRate = parseFloat(monthlyRate);

    if (principal <= 0) {
        document.getElementById("output12").innerHTML = "Principal amount must be greater than 0";
        return;
    }
    
    if (months <= 0) {
        document.getElementById("output12").innerHTML = "Number of months must be greater than 0";
        return;
    }
    
    if (monthlyRate < 0) {
        document.getElementById("output12").innerHTML = "Monthly rate cannot be negative";
        return;
    }

    let rate = monthlyRate / 100;
    let finalAmount = principal * Math.pow(1 + rate, months);
    let compoundInterest = finalAmount - principal;
    document.getElementById("output12").innerHTML = `Lãi kép: ${compoundInterest} VND`;
}

function resetField12() {
    document.getElementById("principal").value = '';
    document.getElementById("months").value = '';
    document.getElementById("monthlyRate").value = '';
    document.getElementById("output12").innerHTML = '';
}
