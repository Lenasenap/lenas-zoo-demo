$(function () {
    var $animals = $('#animals');
    var $name = $('#name');
    var $type = $('#type');

    function addAnimal(animal) {
        $animals.append(
            '<tr>' +
            '<td><span class="name noEdit">' + animal.name + '</span><input class="edit name"></td>' +
            '<td><span class="type noEdit">' + animal.type + '</span><input class="edit type"></td>' +
            '<td><button class="btn remove" data-id=' + animal.id + '>Ta bort</button></td>' +
            '<td><button class="btn editAnimal noEdit" data-id="' + animal.id + '">Ändra</button>' +
            '<button class="btn saveEdit edit" data-id="' + animal.id + '">Spara</button>' +
            '<button class="btn cancelEdit edit">Avbryt</button></td>' +
            '</tr>'
        );
    }

    $.ajax({
        type: 'GET',
        url: '/api/animals/',
        success: function (animals) {
            console.log('success', animals);
            $.each(animals, function (i, animal) {
                addAnimal(animal);
            });
        },
        error: function () {
            alert('Det gick inte att hitta några djur');
        }
    });

    $('#add-animal').on('click', function () {
        var animal = {
            name: $name.val(),
            type: $type.val()
        };

        $.ajax({
            type: 'POST',
            url: 'api/animals/',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            data: JSON.stringify(animal),
            success: function (newAnimal) {
                addAnimal(newAnimal);
            },
            error: function () {
                alert('Det gick inte att spara ner ditt djur');
            }
        });

        document.getElementById("name").value="";
        document.getElementById("type").value="";
    });

    $animals.delegate('.remove', 'click', function () {
        var $row = $(this).closest('tr');
        $.ajax({
            type: 'DELETE',
            url: '/api/animals/' + $(this).attr('data-id'),
            success: function () {
                $row.remove();
            }
        });

    });

    $animals.delegate('.editAnimal', 'click', function () {
        var $row = $(this).closest('tr');
        $row.find('input.name').val( $row.find('span.name').html() );
        $row.find('input.type').val($row.find('span.type').html());
        $row.addClass('edit');
    });

    $animals.delegate('.cancelEdit', 'click', function () {
        $(this).closest('tr').removeClass('edit');
    });

    $animals.delegate('.saveEdit', 'click', function () {
        var $row = $(this).closest('tr');

        var animal = {
            name: $row.find('input.name').val(),
            type: $row.find('input.type').val()
        }

        $.ajax({
            type: 'PUT',
            url: 'api/animals/' + $(this).attr('data-id'),
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            data: JSON.stringify(animal),
            success: function (newAnimal) {
                $row.find('span.name').html(animal.name);
                $row.find('span.type').html(animal.type);
                addAnimal(newAnimal);
            },
            error: function () {
                alert('Det gick inte att ändra ditt djur');
            }
        });
    });

});