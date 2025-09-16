function initArr(length, min , max) {
    const array = [];
    for (let i = 0; i < length; i++) {
        const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
        array.push(randomNumber);
    }
    return array;
}
function checkIfInputValid(inputString) {
    let input = inputString.split(',');
    for (i of input) {
        if (input == "") {
            alert('Vui lòng không bỏ trống');
            return false;
        }
        if (isNaN(i)) {
            alert('Vui lòng nhập số');
            return false;
        }
        if (!Number.isInteger(parseFloat(i))) {
            alert('Vui lòng nhập số nguyên');
            return false;
        }
    }
}

//Bai 1
let arr1 = initArr(10, -100, 100);
document.getElementById('input1').innerHTML = `Mảng khởi tạo: ${arr1}`;
result1 = []
arr1.forEach(function(arr) {
    if (arr >= 10) {
        result1.push(arr)
    }
})
document.getElementById('output1').innerHTML = `Các số lớn hơn 10: ${result1}`;

//Bai 2
let arr2 = initArr(10, -100, 100);
document.getElementById('input2').innerHTML = `Mảng khởi tạo: ${arr2}`;
let max2 = arr2[0];
let index = 0;
arr2.forEach(function(arr) {
    if (arr > max2) {
        max2 = arr;
        index = arr2.indexOf(arr);
    }
})
document.getElementById('output2').innerHTML = `Phần tử có giá trị lớn nhất là ${max2} đứng ở vị trí thứ ${index}`

//Bai 3
let arr3 = initArr(10, -100, 100);
document.getElementById('input3').innerHTML = `Mảng khởi tạo: ${arr3}`;
let max3 = Math.max(...arr3);
let sum3 = 0;
arr3.forEach(function(num) {
  sum3 += num;
})
let avg3 = sum3/arr3.length
document.getElementById('output3').innerHTML = `Giá trị lớn nhất trong mảng là ${max3} và giá trị trung bình của các phần tử trong mảng là ${avg3}`

//Bai 4
function initArr4() {
    let arr4 = initArr(10, -100, 100);
    document.getElementById('input4').innerHTML = `Mảng khởi tạo: ${arr4}`;
    let reverse = arr4.reverse();
    document.getElementById('output4').innerHTML = `Mảng sau khi đảo ngược: ${reverse}`;
}
function inputArr4() {
    let input = prompt('Nhập vào mảng số nguyên cách nhau bởi dấu ","');
    if (checkIfInputValid(input) == false) {
        return;
    }
    let arr4 = input.split(',');
    document.getElementById('input4').innerHTML = `Mảng đã nhập: ${arr4}`;
    let reverse = arr4.reverse();
    document.getElementById('output4').innerHTML = `Mảng sau khi đảo ngược: ${reverse}`;
}

//Bai 5
let arr5 = initArr(10, -100, 100);
document.getElementById('input5').innerHTML = `Mảng khởi tạo: ${arr5}`;
let count = 0;
for (i of arr5) {
    if (i < 0) {
        count++;
    }
}
document.getElementById('output5').innerHTML = `Mảng có ${count} số nguyên âm`;

//Bai 6
function initArr6() {
    let arr6 = initArr(10, -100, 100);
    let v = initArr(1, -100, 100);
    document.getElementById('input6').innerHTML = `Mảng khởi tạo: ${arr6} và Phần tử khởi tạo: ${v}`;
    for (i of arr6) {
        if (i == v) {
            document.getElementById('output6').innerHTML = `${v} is in the array`;
            break;
        }
        else {
            document.getElementById('output6').innerHTML = `${v} is not in the array`;
        }
    }
}
function inputArr6() {
    let input = prompt('Nhập vào mảng số nguyên cách nhau bởi dấu ","');
    let inputV = prompt('Nhập vào phần tử V')
    if (checkIfInputValid(input) == false || checkIfInputValid(inputV) == false) {
        return;
    }
    let arr6 = input.split(',');
    if (arr6.length != 10) {
        alert('Cần nhập mảng có "10" số nguyên');
    }
    else {
        document.getElementById('input6').innerHTML = `Mảng khởi tạo: ${arr6} và Phần tử khởi tạo: ${inputV}`;
        for (i of arr6) {
            if (i == inputV) {
                document.getElementById('output6').innerHTML = `${inputV} is in the array`;
                break;
            }
            else {
                document.getElementById('output6').innerHTML = `${inputV} is not in the array`;
            }
        }
    }   
}

//Bai 7
function initArr7() {
    let arr7 = initArr(10, -100, 100);
    let v = initArr(1, -100, 100);
    let count = 0;
    let result;
    document.getElementById('input7').innerHTML = `Mảng khởi tạo: ${arr7} và Phần tử khởi tạo: ${v}`;
    for (i of arr7) {
        if (arr7[i] == v) {
            count++;
        }
    }
    if (count != 0) {
        result = arr7.filter(item => item != v)
        result[result.length -1] = 0
        document.getElementById('output7').innerHTML = `Phần tử ${v} có tồn tại trong mảng và mảng sau khi xóa phần tử: ${result}`;
    }
    else {
        document.getElementById('output7').innerHTML = `Phần tử ${v} không tồn tại trong mảng`;
    }
}
function inputArr7() {
    let input = prompt('Nhập vào mảng số nguyên cách nhau bởi dấu ","');
    let inputV = prompt('Nhập vào phần tử V')
    if (checkIfInputValid(input) == false || checkIfInputValid(inputV) == false) {
        return;
    }
    let arr7 = input.split(',');
    if (arr7.length != 10) {
        alert('Cần nhập mảng có "10" số nguyên');
    }
    else {
        let count = 0;
        document.getElementById('input7').innerHTML = `Mảng khởi tạo: ${arr7} và Phần tử khởi tạo: ${inputV}`;
        for (i of arr7) {
        if (arr7[i] == inputV) {
            count++;
            }
        }
        if (count != 0) {
            result = arr7.filter(item => item != inputV)
            result[result.length -1] = 0
            document.getElementById('output7').innerHTML = `Phần tử ${inputV} có tồn tại trong mảng và mảng sau khi xóa phần tử: ${result}`;
        }
        else {
            document.getElementById('output7').innerHTML = `Phần tử ${inputV} không tồn tại trong mảng`;
        }
    }   
}

//Bai 8
function initArr8() {
    let arr8 = initArr(10, -100, 100);
    document.getElementById('input8').innerHTML = `Mảng khởi tạo: ${arr8}`;
    document.getElementById('output8').innerHTML = `Mảng sau khi được sắp xếp theo thứ tự giảm dần: ${arr8.sort((a, b) => b - a)}`;
}
function inputArr8() {
    let input = prompt('Nhập vào mảng số nguyên cách nhau bởi dấu ","');
    if (checkIfInputValid(input) == false) {
        return;
    }
    let arr8 = input.split(',');
    if (arr8.length != 10) {
        alert('Cần nhập mảng có "10" số nguyên');
    }
    else {
        document.getElementById('input8').innerHTML = `Mảng khởi tạo: ${arr8}`;
        document.getElementById('output8').innerHTML = `Mảng sau khi được sắp xếp theo thứ tự giảm dần: ${arr8.sort((a, b) => b - a)}`;
    }
}

//Bai 9
function initArr9() {
    let arr9_a = initArr(10, -100, 100);
    let arr9_b = initArr(10, -100, 100);
    document.getElementById('input9').innerHTML = `Mảng khởi tạo a: ${arr9_a} và mảng b: ${arr9_b}`;
    let arr9_c = arr9_a.concat(arr9_b);
    document.getElementById('output9').innerHTML = `Mảng c được nối từ 2 mảng a và b: ${arr9_c}`;
}
function inputArr9() {
    let input_a = prompt('Nhập vào mảng a với 10 số nguyên cách nhau bởi dấu ","');
    let input_b = prompt('Nhập vào mảng b với 10 số nguyên cách nhau bởi dấu ","');
    if (checkIfInputValid(input_a) == false || checkIfInputValid(input_b) == false) {
        return;
    }
    let arr9_a = input_a.split(',');
    let arr9_b = input_b.split(',');
    if (arr9_a.length != 10 || arr9_b.length != 10) {
        alert('Cần nhập mảng có "10" số nguyên');
    }
    else {
        document.getElementById('input9').innerHTML = `Mảng khởi tạo a: ${arr9_a} và mảng b: ${arr9_b}`;
        let arr9_c = arr9_a.concat(arr9_b);
        document.getElementById('output9').innerHTML = `Mảng c được nối từ 2 mảng a và b: ${arr9_c}`;
    }
}