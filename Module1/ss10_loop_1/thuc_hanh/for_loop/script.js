//Bai 1
let text = "";
let i;
for (i = 0; i < 5; i++) {
    text += 'The number is ' + i + '<br>';
}
document.getElementById('demo').innerHTML = text;

//Bai 2
let number = prompt('input a number:')
let total = 0;
for (i = 1; i <= number; i++) {
    total += i;
}
alert(total)