const loadUser = (data) => {
    let warpUser = _$('#loadUser-js')
    let html = ``

    data = data.reverse()
    data.forEach(e => {
        html += `<tr>
        <td>${e.avartar}</td>
        <td>${e.username}</td>
        <td>${e.fullname}</td>
        <td>${e.gender  ? 'Nam' : 'Nữ'}</td>
        <td>${e.email}</td>
        <td>${e.phone}</td>
        <td>${e.address}</td>
        <td>${e.status ? 'Active' : 'Disable'}</td>
        <td>${e.created_at}</td>
        <td>${e.updated_at}</td>
        <td>
            <div class="form-button-action">
                <button type="button" data-toggle="tooltip${e.id}" title=""
                    class="btn btn-link btn-primary btn-lg"
                    data-original-title="Edit ${e.id}">
                    <i class="fa fa-edit"></i>
                </button>
                <button type="button" data-toggle="tooltip${e.id}" title=""
                    class="btn btn-link btn-danger" data-original-title="Remove${e.id}">
                    <i class="fa fa-times"></i>
                </button>
            </div>
        </td>
    </tr>`
    })
    if (data.length > 0) {
        warpUser.innerHTML = html
    }
}
    http.get("http://localhost:8080/Users/get")
    .then(data => loadUser(data))
    .catch(err => console.log(err))