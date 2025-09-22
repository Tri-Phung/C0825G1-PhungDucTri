function Rectangle(length, width) {
    this.length = length;
    this.width = width;
    this.getPerimeter = function() {
        return (this.length + this.width) * 2;
    };
    this.getArea = function() {
        return this.length * this.width;
    };
    this.draw = function(ctx, x, y) {
        ctx.beginPath();
        ctx.rect(x, y, this.length, this.width);
        ctx.fillStyle = 'rgba(255, 252, 171, 1)';
        ctx.fill();
    };
}
function createRectangle() {
    var ctx = document.getElementById('myCanvas').getContext("2d");
    var length = Math.floor(Math.random() * 500) + 400;
    var width = Math.floor(Math.random() * 150) + 250;
    var rectangle = new Rectangle(length, width);
    rectangle.draw(ctx, 200, 200);
    console.log('Chiều dài: ' + rectangle.length);
    console.log('Chiều rộng: ' + rectangle.width);
    console.log('Diện tích: ' + rectangle.getArea());
    console.log('Chu vi: ' + rectangle.getPerimeter());
}

createRectangle();
