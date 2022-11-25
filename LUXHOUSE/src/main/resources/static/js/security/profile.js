var dataUser = {};

let userProfile = _$('#userId').innerHTML
http.get(`http://localhost:8080/Users/get/${userProfile}`)
    .then(data => {
        loadProfile(data),
            data.forEach(e => {
                dataUser.push(e)
            })
    })
    .catch(err => console.log(err))

let runApp = setInterval(() => {
    if (dataUser.length > 0) {
        clearInterval(runApp)
        loadMK(dataUser)
    }
}, 100)

const loadMK = (data) => {

}

function doiMatKhau() {
    const mkm1 = _$('#doimkmoi1').value
    const mkm2 = _$('#doimkmoi2').value

    if (mkm1.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập mật khẩu mới', "error")
        return
    }

    if (mkm2.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập mật khẩu mới lại', "error")
        return
    }

    if (mkm1 != mkm2) {
        Swal.fire("Message", 'Nhập sai mã xác nhận', "error")
        return
    }

    let data2 = {
        "op": "update",
        "key": "password",
        "value": mkm1
    }

    http.patch(`http://localhost:8080/Users/update/${userProfile}`, data2)
        .then(
            Swal.fire("Oke", 'Đổi mật khẩu thành công bạn sẽ về trang login', "success")
            .then(rs => {
                if (rs.isConfirmed) window.location.href = 'http://localhost:8080/account/logout'
            })
        )
        .catch(err => console.log(err))
}



const luuProfile = () => {
    const username = _$('#staticTDN').value
    const fullname = _$('#staticT').value
    const email = _$('#staticEmail').value
    const phone = _$('#staticSDT').value
    const password = _$('#staticPas').value
    let userPro1 = _$('#userId').innerHTML


    let data = {
        "op": "update",
        "key": "fullname",
        "value": fullname
    }

    http.patch(`http://localhost:8080/Users/update/${userPro1}`, data)
        .then(
            Swal.fire("Oke", 'Lưu thành công', "success")
            .then(rs => {
                location.reload()
            })
        )
        .catch(err => console.log(err))
}

const loadProfile = (data) => {
    document.getElementById("staticTDN").value = `${data.username}`;
    document.getElementById("staticT").value = `${data.fullname}`;
    document.getElementById("staticEmail").value = `${data.email}`;
    document.getElementById("staticSDT").value = `${data.phone}`;
    document.getElementById("staticPas").value = `${data.password}`;
    if (data.gender == true) {
        document.getElementById("Nam").checked = true;
    } else if (data.gender == false) {
        document.getElementById("Nu").checked = true;
    } else {
        document.getElementById("Khac").checked = true;
    }
    // document.getElementById("myDate").value = "2014-02-09";
    if (data.avartar.innerHTML == 'NULL' && data.avartar.innerHTML == 'null') {
        document.getElementById("staticIMG").src = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png";
    } else {
        document.getElementById("staticIMG").src = `/admin/img/${data.avartar}`;
    }

}

const loadcea = (data) => {
    let nameP = _$('.name')

    nameP.innerHTML = `${data.username}`
    if (data.avartar.innerHTML == 'NULL' && data.avartar.innerHTML == 'null') {
        document.getElementById("staticIMGB").src = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png";
    } else {
        document.getElementById("staticIMGB").src = `/admin/img/${data.avartar}`;
    }

}

let userPro = _$('#userId').innerHTML
http.get(`http://localhost:8080/Users/get/${userPro}`)
    .then(data => loadcea(data))
    .catch(err => console.log(err))