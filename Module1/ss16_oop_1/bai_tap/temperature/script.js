function Temperature(celsius, minCelsius) {
    this.celsius = celsius;
    this.minCelsius = minCelsius;
    this.convertCtoF = function() {
        return this.celsius * 1.8 + 32;
    }
    this.convertCtoK = function() {
        return this.celsius + 273.15;
    }
}
let temperature = new Temperature(25, -273);
if (temperature.celsius > temperature.minCelsius) {
    let fahrenheit = temperature.convertCtoF();
    let kelvin = temperature.convertCtoK();
    document.writeln(`25°C = ${fahrenheit}°F và ${kelvin}K`);
}
else {
    document.writeln(`Độ C phải lớn hơn ${temperature.minCelsius}`);
}
