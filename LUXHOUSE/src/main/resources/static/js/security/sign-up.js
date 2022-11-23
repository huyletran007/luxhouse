const signUp = () => {
    const fullname = _$('#fullname').value
    const username = _$('#username').value
    const password = _$('#password').value
    const password2 = _$('#password2').value
    const email = _$('#email').value
    const phone = _$('#phone').value

    if (username.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập username', "error")
        return
    }

    if (fullname.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập họ và tên', "error")
        return
    }

    if (password.replaceAll(' ', '').length < 3) {
        Swal.fire("Message", 'Vui lòng nhập password lớn hơn 3 kí tự', "error")
        return
    }

    if (password2.replaceAll(' ', '') != password.replaceAll(' ', '')) {
        Swal.fire("Message", 'Vui lòng nhập lại password', "error")
        return
    }

    if (email.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập email', "error")
        return
    }

    if (phone.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập số điện thoại', "error")
        return
    }

    let data = {
        fullname,
        username,
        password,
        email,
        phone
    }
    http.post('http://localhost:8080/api/auth/signup', data)
        .then(data => {
            handleRegister(data)
        })
        .catch(err => console.log(err))

    let handleRegister = (data) => {
        if (data.success == "User signed-in successfully!") {
            Swal.fire("Oke", data.success , "success")
                .then(rs => {
                    if (rs.isConfirmed) window.location.href = 'http://localhost:8080/users/login'
                })
        } else {
            Swal.fire("Message", data.error, "error")
        }
    }

}