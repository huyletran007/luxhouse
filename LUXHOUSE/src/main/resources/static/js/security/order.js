let userPro = _$('#userId').innerHTML

http.get(`http://localhost:8080/Users/get/${userPro}`)
    .then(data => loadcea(data))
    .catch(err => console.log(err))

http.get(`http://localhost:8080/Users/get/${userPro}`)
    .then(data => loadcea(data))
    .catch(err => console.log(err))
// ORDER

//END ORDER

//XEMDONHANG

// END XEM DON HANG
const viewOrderDetail = () => {
window.location.href = "http://localhost:8080/account/order"
}
var loadcea = (data) => {
    let nameP = _$('.name')

    nameP.innerHTML = `${data.username}`
    if (data.avartar.innerHTML == 'NULL' && data.avartar.innerHTML == 'null') {
        document.getElementById("staticIMGB").src = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png";
    } else {
        document.getElementById("staticIMGB").src = `/admin/img/${data.avartar}`;
    }
}