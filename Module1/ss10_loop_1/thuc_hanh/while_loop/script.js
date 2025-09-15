//Bai 1
alert('Bai 1');
let total = 0;
let num;
while( num != -1 ) {
   num = prompt("Enter a number: ");
   alert(num);
   total += parseFloat(num);
}
alert('total is: '+total);

// Bai 2
let i = 1;

while (i < 100) {
    document.write("<hr width = " + i + "%>");
    i++;
}