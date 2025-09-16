//Bai 1
let myColor = ["Red", "Green", "White", "Black"];
let myColorIntoString = myColor.join();
document.getElementById('output1').innerHTML = myColorIntoString;
//Bai 2
function addCharacter() {
    let inputNumbers = document.getElementById('inputNumbers').value;
    let string = '';
    for (i = 0; i < inputNumbers.length; i++) {
        string += inputNumbers[i];
        console.log(string)
        if (i < inputNumbers.length - 1 && inputNumbers[i] % 2 == 0 ){
            string += '-';
        }
    }
    document.getElementById('output2').innerHTML = string;
}
//Bai 3
function convertString() {
    let inputString = document.getElementById('inputString').value;
    let result = '';
    for (i = 0; i < inputString.length; i++) {
        if (inputString[i] === inputString[i].toUpperCase()) {
            result += inputString[i].toLowerCase();
        }
        else {
            result += inputString[i].toUpperCase();
        }
    }
    document.getElementById('output3').innerHTML = result;
}