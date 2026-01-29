function addNewSmartphone() {
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: 'POST',
        data: JSON.stringify(newSmartphone),
        url: 'http://localhost:8080/api/smartphones',
        success: function() {
            alert('Smartphone added successfully!');
            // Optional: reset form or update list
            $('#add-smartphone')[0].reset();
        },
        error: function(error) {
            console.log(error);
            alert('Error adding smartphone');
        }
    });
    event.preventDefault();
}
