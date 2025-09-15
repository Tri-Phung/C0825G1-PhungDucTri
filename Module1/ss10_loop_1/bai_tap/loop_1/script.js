//Bai 1
function countTo100() {
    let result = "";
    for (let i = 1; i < 100; i++) {
        result += i + " ";
        if (i === 99) {
            alert("Đã hoàn thành");
        }
    }
    document.getElementById("output1").innerHTML = "Kết quả đếm:" + result;
}

//Bai 2
function checkTemperature() {
    let temperature = prompt("Nhập nhiệt độ hiện tại:");
    if (temperature === null || temperature === "") {
        document.getElementById("output2").innerHTML = "Vui lòng nhập nhiệt độ!";
        return;
    }
    if (isNaN(temperature)) {
        document.getElementById("output2").innerHTML = "Vui lòng nhập một số hợp lệ.";
        return;
    }
    temperature = parseFloat(temperature);
    if (temperature > 100) {
        document.getElementById("output2").innerHTML = "Nhiệt độ: " + temperature + "°C - Quá cao, cần giảm nhiệt độ.";
    } else if (temperature < 20) {
        document.getElementById("output2").innerHTML = "Nhiệt độ: " + temperature + "°C - Quá thấp, cần tăng nhiệt độ.";
    } else {
        document.getElementById("output2").innerHTML = "Nhiệt độ: " + temperature + "°C - Nhiệt độ phù hợp.";
    }
}

//Bai 3
function displayFibonacci() {
    fibonacci_1 = 0;
    fibonacci_2 = 1;
    let result = "20 số đầu tiên trong dãy Fibonacci: ";
    for (let i = 0; i < 20; i++) {
        result += fibonacci_1 + ' ';
        let next = fibonacci_1 + fibonacci_2;
        fibonacci_1 = fibonacci_2;
        fibonacci_2 = next;
    }
    document.getElementById("output3").innerHTML = result;
}

//Bai 4
function findFibonacciDivisibleBy5() {
    let fibonacci_1 = 0;
    let fibonacci_2 = 1;
    let next = 0;
    while (true) {
        next = fibonacci_1 + fibonacci_2;
        if (next % 5 === 0) {
            document.getElementById("output4").innerHTML = "Số Fibonacci đầu tiên chia hết cho 5 là: " + next;
            break;
        }
        fibonacci_1 = fibonacci_2;
        fibonacci_2 = next;
    }
}

//Bai 5
function calculateFibonacciSum20() {
    let fibonacci_1 = 0;
    let fibonacci_2 = 1;
    let sum = 0;
    for (let i = 0; i < 20; i++) {
        sum += fibonacci_1;
        let next = fibonacci_1 + fibonacci_2;
        fibonacci_1 = fibonacci_2;
        fibonacci_2 = next;
    }
    document.getElementById("output5").innerHTML = sum;
}

//Bai 6
function calculateFibonacciSum30() {
    let sum = 0;
    let count = 0;
    let number = 7;
    
    while (count < 30) {
        if (number % 7 === 0) {
            sum += number;
            count++;
        }
        number+=7;
    }
    document.getElementById('output6').innerHTML = sum;
}

//Bai 7
let result7 = '';
for (let i = 1; i <= 100; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
        result7 += "FizzBuzz" + " ";
    } else if (i % 3 === 0) {
        result7 += "Fizz" + " ";
    } else if (i % 5 === 0) {
        result7 += "Buzz" + " ";
    } else {
        result7 += i + " ";
    }
}
document.getElementById('output7').innerHTML = result7;

//Bai 8
function startGame() {
    let min = parseInt(prompt("Nhập số nhỏ nhất trong khoảng đoán:"));
    let max = parseInt(prompt("Nhập số lớn nhất trong khoảng đoán:"));
    if (isNaN(min) || isNaN(max) || min >= max) {
        alert("Vui lòng nhập giá trị hợp lệ.");
        return;
    }
    let randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
    let guess = false;
    while (!guess) {
        let userGuess = parseInt(prompt(`Đoán một số trong khoảng từ ${min} đến ${max}:`));
        if (isNaN(userGuess)) {
            alert("Vui lòng nhập một số hợp lệ.");
            continue;
        }
        if (userGuess === randomNumber) {
            alert("Chúc mừng! Bạn đã đoán đúng số!");
            guess = true;
        } else if (userGuess < randomNumber) {
            alert("Số bạn đoán nhỏ hơn số đúng. Hãy thử lại!");
        } else {
            alert("Số bạn đoán lớn hơn số đúng. Hãy thử lại!");
        }
    }
}