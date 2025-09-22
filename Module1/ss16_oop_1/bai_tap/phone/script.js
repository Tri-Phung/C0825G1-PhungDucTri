function Mobile(phone) {
    this.phone = phone;
    this.battery = 100;
    this.isOn = false;
    this.messageContent = '';
    this.inbox = [];
    this.sentMessages = [];
    this.getStatus = function() {
        return this.isOn ? `${this.phone} đang bật` : `${this.phone} đang tắt`;
    };
    this.turnOn = function() {
        if (this.battery > 0) {
            this.battery--;
            this.isOn = true;
            console.log(`${this.phone} đã bật`);
        }
        else {
            console.log(`${this.phone} hết pin. Vui lòng sạc pin`);
        }
    };
    this.turnOff = function() {
        this.battery--;
        this.isOn = false;
        console.log(`${this.phone} đã tắt`);
    };
    this.charge = function() {
        if (this.battery === 100) {
            console.log(`${this.phone} pin đã đầy`);
        }
        else {
            this.battery = 100;
            console.log(`${this.phone} đã sạc. Pin hiện tại là ${this.battery}%`);
        }
    };
    this.writeMessage = function(message) {
        if (!this.isOn) {
            console.log(`Điện thoại ${this.phone} đang tắt!`);
            return;
        }
        if (this.battery === 0) {
            console.log(`Điện thoại ${this.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
        this.battery--;
        this.messageContent = message;
        console.log(`${this.phone} đang soạn tin nhắn với nội dung là "${this.messageContent}"`);
        
    };
    this.sendMessage = function(receiver) {
        if (!this.isOn) {
            console.log(`Điện thoại ${this.phone} đang tắt!`);
            return;
        }
        if (this.battery === 0) {
            console.log(`Điện thoại ${this.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
        if (this.messageContent.trim() === '') {
            console.log(`Điện thoại ${this.phone} không có tin nhắn để gửi`);
            return;
        }
        this.battery--;
        this.sentMessages.push([receiver.phone, this.messageContent]);
        receiver.receiveMessage(this.phone, this.messageContent);
        console.log(`${this.phone} đã gửi tin nhắn thành công đến ${receiver.phone}`);
    };
    this.receiveMessage = function(sender, message) {
        this.inbox.push([sender, message]);
    };
    this.viewInbox = function() {
        if (!this.isOn) {
            console.log(`Điện thoại ${this.phone} đang tắt!`);
            return;
        }
        if (this.battery === 0) {
            console.log(`Điện thoại ${this.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
        if (this.inbox.length === 0) {
            console.log(`Điện thoại ${this.phone} hiện không có tin nhắn nào!`);
            return;
        }
        else {
            this.battery--;
            let output = `Hộp thư đến:<br>`;
            this.inbox.forEach(([phone, content]) => {
                output += `Người gửi: ${phone}. Nội dung tin nhắn: ${content} <br>`;
            });
            return output;
        }
    };
    this.viewSentMessage = function() {
        if (!this.isOn) {
            console.log(`Điện thoại ${this.phone} đang tắt!`);
            return;
        }
        if (this.battery === 0) {
            console.log(`Điện thoại ${this.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
        if (this.sentMessages.length === 0) {
            console.log('Điện thoại hiện chưa có tin nhắn nào đã gửi!');
        }
        else {
            this.battery--;
            let output = `Tin nhắn đã gửi: <br>`;
            this.sentMessages.forEach(([receiver, content]) => {
                output += `Người nhận: ${receiver}. Nội dung tin nhắn: ${content} <br>`;
            });
            return output;
        }
    };
}

let phone1 = new Mobile('Nokia');
let phone2 = new Mobile('Iphone');

function showInfo() {
    document.getElementById('battery1').innerHTML = `Battery: ${phone1.battery}%`;
    document.getElementById('battery2').innerHTML = `Battery: ${phone2.battery}%`;
    document.getElementById('status1').innerHTML = `Status: ${phone1.getStatus()}`;
    document.getElementById('status2').innerHTML = `Status: ${phone2.getStatus()}`;
}

showInfo();

function turnOn1() {
    if (phone1.isOn) {
        alert('Điện thoại này đã bật rồi');
        return;
    }
    phone1.turnOn();
    showInfo();
}

function turnOn2() {
    if (phone2.isOn) {
        alert('Điện thoại này đã bật rồi');
        return;
    }
    phone2.turnOn();
    showInfo();
}
function turnOff1() {
    if (!phone1.isOn) {
        alert('Điện thoại này đã tắt rồi');
        return;
    }
    phone1.turnOff();
    showInfo();
}

function turnOff2() {
    if (!phone2.isOn) {
        alert('Điện thoại này đã tắt rồi');
        return;
    }
    phone2.turnOff();
    showInfo();
}
function charge1() {
    if (phone1.battery === 100) {
        alert('Pin đã đầy');
        return;
    }
    phone1.charge();
    showInfo();
}
function charge2() {
    if (phone2.battery === 100) {
        alert('Pin đã đầy');
        return;
    }
    phone2.charge();
    showInfo();
}

function message1() {
    if (!phone1.isOn) {
            alert(`Điện thoại ${phone1.phone} đang tắt!`);
            return;
        }
    if (phone1.battery === 0) {
            alert(`Điện thoại ${phone1.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    inputContent = prompt('Mời nhập vào nội dung tin nhắn:')
    phone1.writeMessage(inputContent);
    showInfo();
}

function message2() {
    if (!phone2.isOn) {
            alert(`Điện thoại ${phone2.phone} đang tắt!`);
            return;
        }
    if (phone2.battery === 0) {
            alert(`Điện thoại ${phone2.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    inputContent = prompt('Mời nhập vào nội dung tin nhắn:')
    phone2.writeMessage(inputContent);
    showInfo();
}

function sendMess1() {
    if (!phone1.isOn) {
            alert(`Điện thoại ${phone1.phone} đang tắt!`);
            return;
        }
    if (phone1.battery === 0) {
            alert(`Điện thoại ${phone1.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    if (phone1.messageContent.trim() === '') {
        alert(`Bạn chưa nhập nội dung tin nhắn`);
        return;
    }
    phone1.sendMessage(phone2);
    alert(`Đã gửi tin nhắn đến ${phone2.phone}`)
    document.getElementById('notification2').innerHTML = `Bạn vừa nhận tin nhắn mới từ ${phone1.phone}`;
    showInfo();
}

function sendMess2() {
    if (!phone2.isOn) {
            alert(`Điện thoại ${phone2.phone} đang tắt!`);
            return;
        }
    if (phone2.battery === 0) {
            alert(`Điện thoại ${phone2.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    if (phone2.messageContent.trim() === '') {
        alert(`Bạn chưa nhập nội dung tin nhắn`);
        return;
    }
    phone2.sendMessage(phone1);
    alert(`Đã gửi tin nhắn đến ${phone1.phone}`)
    document.getElementById('notification1').innerHTML = `Bạn vừa nhận tin nhắn mới từ ${phone2.phone}`;
    showInfo();
}

function checkInbox1() {
    if (!phone1.isOn) {
            alert(`Điện thoại ${phone1.phone} đang tắt!`);
            return;
        }
    if (phone1.battery === 0) {
            alert(`Điện thoại ${phone1.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    if (phone1.inbox.length === 0) {
            alert(`Điện thoại ${phone1.phone} hiện không có tin nhắn nào!`);
        }
    else {
        document.getElementById('inbox1').innerHTML = phone1.viewInbox();
    }
    showInfo();
}

function checkInbox2() {
    if (!phone2.isOn) {
            alert(`Điện thoại ${phone2.phone} đang tắt!`);
            return;
        }
    if (phone2.battery === 0) {
            alert(`Điện thoại ${phone2.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    if (phone2.inbox.length === 0) {
            alert(`Điện thoại ${phone2.phone} hiện không có tin nhắn nào!`);
        }
    else {
        document.getElementById('inbox2').innerHTML = phone2.viewInbox();
    }
    showInfo();
}

function checkSent1() {
    if (!phone1.isOn) {
            alert(`Điện thoại ${phone1.phone} đang tắt!`);
            return;
        }
    if (phone1.battery === 0) {
            alert(`Điện thoại ${phone1.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    if (phone1.sentMessages.length === 0) {
            alert(`Điện thoại ${phone1.phone} hiện không có tin nhắn đã gửi nào!`);
        }
    else {
        document.getElementById('sentMess1').innerHTML = phone1.viewSentMessage();
    }
    showInfo();
}

function checkSent2() {
    if (!phone2.isOn) {
            alert(`Điện thoại ${phone2.phone} đang tắt!`);
            return;
        }
    if (phone2.battery === 0) {
            alert(`Điện thoại ${phone2.phone} hết pin. Vui lòng sạc pin`);
            return;
        }
    if (phone2.sentMessages.length === 0) {
            alert(`Điện thoại ${phone2.phone} hiện không có tin nhắn đã gửi nào!`);
        }
    else {
        document.getElementById('sentMess2').innerHTML = phone2.viewSentMessage();
    }
    showInfo();
}