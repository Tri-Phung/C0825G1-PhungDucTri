while (true) {
    var weight = prompt('Input weight:');
    var height = prompt('Input height:');
    var bmi =  weight / (height**2);
    if (isNaN(weight) || isNaN(height)) {
        alert('Input must be a number');
        continue;
    }
    else if (weight === '' || height === '') {
        alert('Input must not be null');
        continue;
    }
    else if (weight <= 0 || height <= 0) {
        alert('Input must greater than 0');
        continue;
    }
    else {
        break;
    }
}
document.writeln(bmi)
if (bmi < 18.5) {
    document.write("Underweight");
} else if (bmi < 25.0) {
    document.write("Normal");
} else if (bmi < 30.0) {
    document.write("Overweight");
} else {
    document.write("Obese");
}
