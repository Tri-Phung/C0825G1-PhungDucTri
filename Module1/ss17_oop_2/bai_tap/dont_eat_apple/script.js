let Apple = function() {
    this.weight = 10;
    this.decrease = function() {
        if (this.weight > 0) {
            this.weight--;
        }
    };
    this.isEmpty = function() {
        return this.weight === 0;
    }
    this.getWeight = function() {
        return this.weight;
    };
}

let Human = function(name, gender, weight) {
    this.name = name;
    this.gender = gender;
    this.weight = weight;
    this.isMale = function() {
        return this.gender === true;
    };
    this.setGender = function(gender) {
        this.gender = gender;
    };
    this.checkApple = function(apple) {
        return !apple.isEmpty();
    };
    this.eat = function(apple) {
        console.log(apple.weight);
        if (this.checkApple(apple)) {
            this.weight++;
            apple.decrease();
            console.log(`${this.name} just took a bite of the apple`);
        }
        else {
            console.log(`${this.name} can't eat the apple cause there no more apple`);
        }
    };
    this.say = function(something) {
        console.log(`${this.name} say: ${something}`);
    };
    this.getName = function() {
        return this.name;
    };
    this.setName = function() {
        this.name = name;
    };
    this.getWeight = function() {
        return this.weight;
    };
    this.setWeight = function() {
        this.weight = weight;
    };
}

let apple = new Apple();
let human1 = new Human('Adam', true, 77);
let human2 = new Human('Eve', false, 61);
let story = `Cân nặng hiện tại của ${human1.name} là ${human1.weight}kg và của ${human2.name} là ${human2.weight}kg <br>`;
while (!apple.isEmpty()) {
    human1.eat(apple);
    story += `${human1.name} vừa làm một miếng táo và cân nặng hiện tại là ${human1.weight}kg <br>`;
    if (!apple.isEmpty()) {
        human2.eat(apple);
        story += `${human2.name} vừa làm một miếng táo và cân nặng hiện tại là ${human2.weight}kg <br>`
    }
}
story += `${human1.name} và ${human2.name} đã ăn hết táo, họ đã biết điều thiện và điều ác, mất đi sự trong trắng và bị trục xuất khỏi Vườn Địa đàng. Hết truyện.`
document.getElementById('theStory').innerHTML = story;