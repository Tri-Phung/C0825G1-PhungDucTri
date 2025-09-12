document.getElementById("convertButton").onclick = exchangeMoney; 

function checkAmount() {
    let amount = document.getElementById("amount").value;
    if (isNaN(amount) || amount<=0) {
        document.getElementById("result").innerHTML = "Amount should be a number greater than 0";
        return false;
    }
    else {
        return true;
    }
}

function exchangeMoney() {
    if (!checkAmount()) {
        return;
    }
    let amount = document.getElementById("amount").value;
    let from = document.getElementById("fromCurrency").value;
    let to = document.getElementById("toCurrency").value;
    let result;
    if (from === "VND" && to === "USD") {
        result = `Result: ${amount / 23000} $`;
    }
    else if (from === "USD" && to === "VND") {
        result = `Result: ${amount * 23000} VND`;
    }
    else {
        result = "Invalid currency selection";
    }
    document.getElementById("result").innerHTML = result;
};
