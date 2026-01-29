export const person = {
    firstName: 'John',
    lastName: 'Doe',
    age: 30,
    gender: 'male',
    occupation: 'developer',
    nationality: 'American',
    city: 'New York',
    hobbies: ['reading', 'traveling', 'photography' ],
    languages: ['English', 'Spanish' ],
    education: {
        degree: 'Bachelor',
        major: 'Computer Science',
        university: 'Harvard University'
    }
};

const {firstName, gender, education:{degree}, languages} = person;
const student = {firstName, gender, degree, english: languages[0]};
let result = '';
Object.entries(student).forEach(([key, value]) => {result += `${key}: ${value} <br>`;});
document.getElementById('result2').innerHTML = result;