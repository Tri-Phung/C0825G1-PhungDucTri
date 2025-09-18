let en = ['a','ability','able','about','above','accept','according','account','across','act']
let vi = ['một','khả năng','có khả năng','khoảng','trên, phía trên', 'chấp nhận','theo','tài khoản','Đi qua','hành động, đóng vai']
function trans() {
    let input = document.getElementById('inputEn').value;
    let result = '';
    let len = en.length;
    for (i = 0; i < len; i++) {
        if (en[i] === input) {
            result = `${en[i]}: ${vi[i]}`;
            break;
        }
        else {
            result = 'Không tìm thấy từ tiếng anh nào trùng khớp';
        }
    }
    document.getElementById('output').innerHTML = result;
}