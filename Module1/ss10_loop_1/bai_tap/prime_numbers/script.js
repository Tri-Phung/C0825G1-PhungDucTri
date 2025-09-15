function checkIfANumber(input) {
    if (isNaN(input)) {
        return false;
    }
    return true;
}

function isPrime(n) {
    if (n < 2) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}

function displayPrimeNumbers() {
    let numbers = document.getElementById("numbers").value;
    if (!checkIfANumber(numbers) || numbers === '') {
        document.getElementById("output").innerHTML = "Vui lòng nhập số hợp lệ";
        return;
    }
    numbers = parseInt(numbers);
    if (numbers <= 0) {
        document.getElementById("output").innerHTML = "N phải lớn hơn 0";
        return;
    }
    let count = 0;
    let N = 2;
    let result = `<h3>${numbers} số nguyên tố đầu tiên:</h3><p>`;
    while (count < numbers) {
        if (isPrime(N)) {
            result += N + " ";
            count++;
        }
        N++;
    }
    
    result += "</p>";
    document.getElementById("output").innerHTML = result;
}
