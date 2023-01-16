async function filter () {
    let getStr = "/ShopService/api/shop/search/by-type/" + $("#type").val();

    let response = await fetch(getStr);
    if (response.ok) {
        let json = await response.json();
        fillTableWithArray(json);
    } else {
        let error = await response.text();
        $('.mx-auto__text').remove();
        $('#error1').text(error);
    }
}

async function add () {
    const id = $("#id").val();
    const wheels = $("#wheels").val();
    let response = await fetch(`/ShopService/api/shop/add-wheels/${id}/${wheels}`, {method: 'POST'});
    if (response.ok) {
        let json = await response.json();
        fillTableWithSingle(json);
    } else {
        let error = await response.text();
        $('.mx-auto__text').remove();
        $('#error2').text(error);
    }
}

function fillTableWithArray(json) {
    $('.table-rows').remove();
    for (let i = 0; i < json.length; i++) {
        $('table').append(
            '<tr class="table-rows"><td>' + json[i].id +
            '</td><td>' + json[i].name + '</td>' +
            '</td><td>' + json[i].coordinates.x + '</td>' +
            '</td><td>' + json[i].coordinates.y + '</td>' +
            '</td><td>' + json[i].creationDate + '</td>' +
            '</td><td>' + json[i].enginePower + '</td>' +
            '</td><td>' + json[i].numberOfWheels + '</td>' +
            '</td><td>' + json[i].type + '</td>' +
            '</td><td>' + json[i].fuelType + '</td></tr>'
        );
    }
}

function fillTableWithSingle(json) {
    $('.table-rows').remove();
    $('table').append(
        '<tr class="table-rows"><td>' + json.id +
        '</td><td>' + json.name + '</td>' +
        '</td><td>' + json.coordinates.x + '</td>' +
        '</td><td>' + json.coordinates.y + '</td>' +
        '</td><td>' + json.creationDate + '</td>' +
        '</td><td>' + json.enginePower + '</td>' +
        '</td><td>' + json.numberOfWheels + '</td>' +
        '</td><td>' + json.type + '</td>' +
        '</td><td>' + json.fuelType + '</td></tr>'
    );
}