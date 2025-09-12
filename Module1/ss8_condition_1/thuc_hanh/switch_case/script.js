// Bai 1
let browser = prompt("Enter browser name!");
switch(browser) {
    case "Edge":
        alert("You've got the Edge!");
        break;
    case "Chrome":
    case "Firefox":
    case "Safari":
    case "Opera":
        alert("Okay we support these browsers too");
        break;
    default:
        alert("We hope that this page looks ok!");
}

// Bai 2
let a = prompt('a?','');
switch(a) {
    case 0:
        alert(0);
        break;
    case 1:
        alert(1);
        break;
    case 2:
    case 3:
        alert('2,3');
}

//Bai 3
let n = prompt("input a number:");
if (n>0) {
    alert(1);
}
else if (n<0) {
    alert(-1);
}
else {
    alert(0)
}

//Convert in switch case
let n2 = prompt("input a number:");
n2 = Number(n2); 

switch (Math.sign(n2)) {
    case 1:
        alert(1);
        break;
    case -1:
        alert(-1);
        break;
    case 0:
        alert(0);
        break;
}