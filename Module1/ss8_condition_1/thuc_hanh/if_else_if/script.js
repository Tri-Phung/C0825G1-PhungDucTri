var username = prompt("Nhap vao username:");
console.log(username)
if (username == "Admin") {
    var password = prompt("Nhap vao password:");
    if (password == "TheMaster") {
        alert("Welcome");
    }
    else if (password == "") {
        alert("Canceled")
    }
    else {
        alert("Wrong password")
    }
}
else if (username == "") {
    alert("Canceled")
}
else {
    alert("I don't know you")
}