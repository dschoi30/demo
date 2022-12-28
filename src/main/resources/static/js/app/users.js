var users = {
    init: function() {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
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
    }
};

users.init();