let weight = prompt('input weight:');
let height = prompt('input height:');
let bmi =  weight / (height**2);
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