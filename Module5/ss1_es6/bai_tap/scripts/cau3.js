
const sv1 = {
    firstName: 'John',
    gender: 'Male',
    degree: 'Bachelor',
    english: 'English'
}
const sv2 = {
    name: 'John',
    gender: 'Male',
    degree: 'Bachelor',
    english: 'English'
}

const sv3 = {
    firstName: 'John',
    gender: 'Male',
    degrees: 'Bachelor',
    english: 'English'
}

function getInfo({firstName = "Quân", degree = "NA"} = {}) {
    let result = `firstName: ${firstName} <br> degree: ${degree}`;
    return result;
}

document.getElementById('result3').innerHTML = getInfo(sv1) + '<br>' + getInfo(sv2) + '<br>' + getInfo(sv3) + '<br>';