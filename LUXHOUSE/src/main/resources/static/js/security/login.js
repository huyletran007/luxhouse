const login = () => {
    const usernameOrEmail = _$('#usernameOrEmail').value
    const password = _$('#password').value

    let data = {
        usernameOrEmail,
        password
    }

    http.post('http://localhost:8080/api/auth/signin', data)
        .then(data => handleLogin(data))
        .alert('ok')
        .catch(err => console.log(err))

    // let handleLogin = (data) => {
    //     // alert('ok')
    //     if(data.return != '') {
    //         alert('ok')
    //         window.location.href = '/account/profile'
    //     } else {
    //         Swal.fire("Message", data.error, "error")
    //     }
    // }
}