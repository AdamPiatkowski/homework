



function sendNameToApplication(event) {
    event.preventDefault();

    var name = $(this).find('[name="name"]');

    var requestUrl = 'http://localhost:8080/whatGender';

    $.ajax({
        url: requestUrl,
        method: 'POST',
        processData: false,
    })

}

function sendNamesToApplication(event) {
    event.preventDefault();

    var name = $(this).find('[name="name"]');

    var requestUrl = 'http://localhost:8080/whatGender';

    $.ajax({
        url: requestUrl,
        method: 'POST',
        processData: false,
    })
}

function onlyOne(checkbox) {
    var checkboxes = document.getElementsByName('check')
    checkboxes.forEach((item) => {
        if (item !== checkbox) item.checked = false
    })
}