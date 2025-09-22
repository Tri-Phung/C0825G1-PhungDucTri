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
        console.log(`${this.phone} vừa nhận tin nhắn từ ${sender} với nội dung là "${message}"`);
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
        }
        else {
            this.battery--;
            console.log(`Hộp thư đến:`);
            this.inbox.forEach(([phone, content]) => {
                console.log(`Người gửi: ${phone}. Nội dung tin nhắn: ${content}`);
            });
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
            console.log(`Tin nhắn đã gửi:`);
            this.sentMessages.forEach(([receiver, content]) => {
                console.log(`Người nhận: ${receiver}. Nội dung tin nhắn: ${content}`);
            });
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
    if (phone1.isOn === true) {
        alert('Điện thoại này đã bật rồi');
        return;
    }
    phone1.turnOn();
    showInfo();
}

function turnOn2() {
    if (phone2.isOn === true) {
        alert('Điện thoại này đã bật rồi');
        return;
    }
    phone2.turnOn();
    showInfo();
}

function charge1() {
    if (phone1.battery === 100) {
        alert('Pin đã đầy');
        return;
    }
    phone1.charge()
}
console.log(phone1.getStatus());
console.log(phone2.getStatus());

phone1.writeMessage('Hello mtfk');
phone1.sendMessage(phone2);

phone1.writeMessage('hi yfkb');
phone1.sendMessage(phone2);

phone1.viewInbox();
phone1.viewSentMessage();


