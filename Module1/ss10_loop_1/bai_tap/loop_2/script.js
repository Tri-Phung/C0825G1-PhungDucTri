//Bai 1

//Bai 2
function factorial() {
    let number = document.getElementById('inputNumber').value;
    let giaiThua = 1;
    for (let i = 1; i <= number; i++) {
        giaiThua *= i;
    }
    document.getElementById('output2').innerHTML = giaiThua;

}

//Bai 3
let output3 = '';
for (let i = 1; i <= 5; i++) {
    output3 += '*'.repeat(i) + '\n';
}

output3 += '\n';
for (let i = 5; i >= 1; i--) {
    output3 += '*'.repeat(i) + '\n';
}

output3 += '\n';
for (let i = 1; i <= 5; i++) {
    output3 += ' '.repeat(5 - i) + '*'.repeat(i) + '\n';
}

output3 += '\n';
for (let i = 5; i >= 1; i--) {
    output3 += ' '.repeat(5 - i) + '*'.repeat(i) + '\n';
}
document.getElementById('output3').textContent = output3;


//Bai 4
let output4 = '';

for (let i = 0; i < 7; i++) {
    let row = "";
    for (let j = 0; j < 21; j++) {
        if (i === 0 || i === 6 || j === 0 || j === 20) {
            row += "*";
        } else {
            row += " ";
        }
    }
    output4 += row + "\n";
}

document.getElementById("output4").textContent = output4;
