//Bai 1
let a = +prompt("a: ");
let b = +prompt("b: ");
result = (a + b < 4) ? 'Below' : 'Over';
alert(result);

//Bai 2
let login = prompt("Input a message:")
let message = (login == 'employee') ? 'hello' : (login == 'director') ? 'greeting' : (login == '') ?  'no login' : '';
alert(message)