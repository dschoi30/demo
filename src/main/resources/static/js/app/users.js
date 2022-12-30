var users = {
    init: function() {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        })
        $('#btn-update').on('click', function () {
            _this.update();
        })
    },
    save: function() {
        var data = {
            name: $('#name').val(),
            password: $('#password').val(),
            zipCode: $('#zipCode').val(),
            address: $('#address').val(),
            subAddress: $('#subAddress').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/users',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error))
        });
    },
    update: function() {
        var data = {
            name: $('#name').val(),
            password: $('#password').val(),
            zipCode: $('#zipCode').val(),
            address: $('#address').val(),
            subAddress: $('#subAddress').val()
        };

        var id =$('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/users/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원 정보 수정이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error))
        });
    }
};

users.init();