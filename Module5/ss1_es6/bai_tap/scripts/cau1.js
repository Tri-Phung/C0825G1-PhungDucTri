import * as validate from './validate.js';

export const isPrime = (number) => {
    if (number < 2) return false;
    if (number === 2) return true;
    else if (number % 2 === 0) return false;
    const sqrtNum = Math.sqrt(number);
    for (let i = 3; i <= sqrtNum; i += 2) {
        if (number % i === 0) return false;
    }
    return true;
}
document.getElementById('checkPrimeNumber').addEventListener('click',task1);
export function task1() {
    const input = document.getElementById('inputString1').value;
    const number = Number(input);
    if (!validate.checkIsValidInteger(number)) {
        document.getElementById('result1a').innerHTML = 'Please input an integer';
    }
    else if (isPrime(number)) {
        document.getElementById('result1a').innerHTML = 'This is prime!';
    }
    else document.getElementById('result1a').innerHTML = 'This is not prime!';
}
document.getElementById('filterPrimeNumbers').addEventListener('click', task2);
export function task2() {
    const input = document.getElementById('inputString2').value;
    const arr = input.split(',').map(str => Number(str.trim())).filter(num => validate.checkIsValidInteger(num)).filter(isPrime);
    document.getElementById('result1b').innerHTML = arr.length > 0 ? arr.join(', ') : "Not found any prime number";
}