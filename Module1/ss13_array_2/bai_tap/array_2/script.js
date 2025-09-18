function initArr(min , max, row, col) {
    const array = [];
    for (let i = 0; i < row; i++) {
        array[i] = [];
        for (let j = 0; j < col; j++) {
            const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
            array[i][j] = randomNumber;
        }
    }
    return array;
}
function checkIfInputValid(input) {
    if (input === '') {
        alert('Vui lòng không để trống')
        return false;
    }
    return true;
}

//Bai 1
let arr1 = initArr(-100, 100, 5, 4);
let result_1 = '';
for (i in arr1) {
    result_1 += 'row ' + i +'<br>';
    for (j in arr1[i]) {
        result_1 += arr1[i][j] + '<br>';
    }
}
document.getElementById('output1').innerHTML = `Mảng khởi tạo: <br>${result_1}`;

//Bai 2
let arr2 = ['c', 's', 'c', '2', '6', '1'];
document.getElementById('input2').innerHTML = `Mảng khởi tạo: ${arr2}`;
let reverse = arr2.reverse();
document.getElementById('output2').innerHTML = `Mảng đảo ngược: ${reverse}`;

//Bai 3
let arr3 = ['c', 's', 'c', '2', '6', '1','c', 's', 'c', '2', '6', '1'];
document.getElementById('input3').innerHTML = `Mảng khởi tạo: ${arr3} có kích thước là ${arr3.length} ký tự`;
let count3 = 0;
for (i of arr3) {
    if (!isNaN(i)) {
        count3++;
    }
}
document.getElementById('output3').innerHTML = `Trong đó, số ký tự số là ${count3}`;

//Bai 4
function countWords() {
    let input = document.getElementById('inputString4').value;
    if (!checkIfInputValid(input)) {
        return;
    }
    document.getElementById('input4').innerHTML = `Chuỗi vừa nhập vào: ${input}`;
    const deleteSpace = input.trim();
    let count = 0;
    if (deleteSpace === '') {
        count = 0
    }
    else {
        const wordsArr = deleteSpace.split(/\s+/);
        count = wordsArr.length;
    }
    document.getElementById('output4').innerHTML = `Số từ trong chuỗi vừa nhập là ${count}`;
}

//Bai 5
function checkIfEqual() {
    let input_a = document.getElementById('inputString5A').value;
    let input_b = document.getElementById('inputString5B').value;
    if (!checkIfInputValid(input_a) || !checkIfInputValid(input_b)) {
        return;
    }
    document.getElementById('input5').innerHTML = `Chuỗi thứ nhất vừa nhập vào: "${input_a}" và chuỗi thứ hai: "${input_b}"`;
    if (input_a === input_b) {
        document.getElementById('output5').innerHTML = `Hai chuỗi giống nhau`;
    }
    else {
        document.getElementById('output5').innerHTML = `Hai chuỗi khác nhau`;
    }
}

//Bai 6
function searchAndReplace() {
    let input = document.getElementById('inputString6').value;
    if (!checkIfInputValid(input)) {
        return;
    }
    document.getElementById('input6').innerHTML = `Mảng ký tự vừa nhập vào: ${input}`;
    let len = input.length;
    let count = 0;
    let replace = input.replace(/-/g,'_');;
    for (i = 0; i < len; i++) {
        if (input[i] === '-') {
            count++;
        }
    }
    if (count != 0) {
        document.getElementById('output6').innerHTML = `Mảng ký tự sau khi kiểm tra và thay thế ký tự '-' bằng ký tự '_': ${replace}`;
    }
    else {
        document.getElementById('output6').innerHTML = 'Không tìm thấy bất kỳ ký tự "-" nào';
    }
}