const login = () => {
    const usernameOrEmail = _$('#usernameOrEmail').value
    const password = _$('#password').value

    if (usernameOrEmail.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập email hoặc username', "error")
        return
    }

    if (password.replaceAll(' ', '').length < 3) {
        Swal.fire("Message", 'Vui lòng nhập password lớn hơn 3 kí tự', "error")
        return
    }

    let data = {
        usernameOrEmail,
        password
    }

    http.post('http://localhost:8080/api/auth/signin', data)
        // .then(data => handleLogin(data))
        // .catch(err => console.log(err))
        // Swal.fire("Oke", 'Đăng nhập thành công', "success")
        .then(
            data => {
            Swal.fire("Oke", 'Đăng nhập thành công' , "success")
            .then(rs => {
                if (rs.isConfirmed) window.location.href = 'http://localhost:8080/account/profile'
            })
        })
        .catch(err => {
            Swal.fire("Message", 'Đăng nhập thất bại (Sai tài khoản và mật khẩu)', "error")
            console.log(err)})

}