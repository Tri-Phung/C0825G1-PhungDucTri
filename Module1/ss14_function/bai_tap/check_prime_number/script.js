function isPrime(number) {
    if (number < 2) {
        return false;
    }
    for (i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}
let result = 'Các số nguyên tố nhỏ hơn 10.000: ';
let numbers = 2;
while (numbers < 10000) {
    if (isPrime(numbers)) {
        result += numbers +' , ';
    }
    numbers++
}
document.getElementById('output').innerHTML = result;6