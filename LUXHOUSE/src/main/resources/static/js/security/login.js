const login = () => {
    const usernameOrEmail = _$('#usernameOrEmail').value
    const password = _$('#password').value

    let data = {
        usernameOrEmail,
        password
    }

    http.post('http://localhost:8080/api/auth/signin', data)
        .then(data => {
            window.location.href = 'http://localhost:8080/account/profile'
        })
        .catch(err => console.log(err))
}