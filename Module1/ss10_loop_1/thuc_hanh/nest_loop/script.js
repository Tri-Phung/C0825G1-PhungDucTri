let content = "<table border='1' width='300' cellspacing='0' cellpadding='3'>";
for (i = 1; i <= 10; i++) {
    content += '<tr>';
    for (j = 1; j <= 10; j++) {
        content += `<td>${i*j}</td>`;
    }
    content += '</tr>';
}
content += '</table>'
document.write(content);