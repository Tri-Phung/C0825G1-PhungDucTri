let courses = [
    {
        id: 1,
        title: "ReactJS Tutorial",
        rating: 4.2,
    },
    {
        id: 2,
        title: "Angular Tutorial",
        rating: 2.5,
    },
    {
        id: 3,
        title: "VueJS Tutorial",
        rating: 3.8,
    },
    {
        id: 4,
        title: "Java Tutorial",
        rating: 4,
    },
    {
        id: 5,
        title: "JavaScript Tutorial",
        rating: 3.5,
    },
];

function filter4Star(courseList) {
    let arr = [];
    courseList.filter((course) => {if(course.rating < 4) arr.push(course)});
    return arr;
}
let result = '';
filter4Star(courses).forEach(item => {
    Object.entries(item).forEach(([key,value]) => {
        result += `${key}: ${value}`
        if (key !== 'rating') {
            result += ` - `;
        }
    });
    result += '<br>';
});
document.getElementById('result5').innerHTML =  result;