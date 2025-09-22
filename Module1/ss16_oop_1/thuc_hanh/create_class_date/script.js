let MyDate = function(day, month, year) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.getDay = function(){
        return this.day;
    }
    this.getMonth = function(){
        return this.month;
    }
    this.getYear = function(){
        return this.year;
    }
    this.setDay = function(day){
        return this.day = day;
    }
    this.setMonth = function(month){
        return this.month = month;
    }
    this.setYear = function(year){
        return this.year = year;
    }
};
let date = new MyDate(2, 2, 2007)
let day = date.getDay();
let month = date.getMonth();
let year = date.getYear();
alert(day + '/' + month + '/' + year);
date.setDay(1);
date.setMonth(1);
date.setYear(2002);
let day1 = date.getDay();
let month1 = date.getMonth();
let year1 = date.getYear();
alert(day1 + '/' + month1 + '/' + year1);
console.log(date)