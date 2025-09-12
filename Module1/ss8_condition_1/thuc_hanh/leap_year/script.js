let year = parseInt(prompt("input the year:"))
if (!(year%4) && !(!(year%100)) || (!(year%100) && !(year%400))) {
    alert("nam nhuan");
}
else {
    alert("khong phai nam nhuan");
}