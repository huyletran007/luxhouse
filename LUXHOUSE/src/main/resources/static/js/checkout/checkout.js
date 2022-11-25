let dataNewOrder = {};
let dataCart = [];
let userPro = _$('#userId').innerHTML
http.get(`http://localhost:8080/cartuser/get/users/${userPro}`)
    .then(data => {
        loadGioHang(data),
            data.forEach(e => {
                dataCart.push(e)
            })
    })
    .catch(err => console.log(err))

let runApp = setInterval(() => {

    if (dataCart.length > 0) {
        clearInterval(runApp)
        orderCreate(dataCart)
    }

}, 100)

// http.get(`http://localhost:8080/Users/get/${userPro}`)
//     .then(data => loadcea(data))
//     .catch(err => console.log(err))

http.get('http://localhost:8080/PaymentType/get')
    .then(data => loadPaymentType(data))
    .catch(err => console.log(err))

const loadGioHang = (data) => {
    let loadGioH = _$('#loadGH')
    let subToTalCO = _$('#subTotalCO')
    let estiamteTotalCO = _$('#estiameTotalCO')
    let estiamteTotalCOfk = _$('#estiameTotalCOfake')
    let subToCO = 0,
        estimaToCO = 0

    var ship = document.getElementById("selectShip");
    var valueShip = ship.value;
    let loadShip = _$('#loadShip')



    let html1 = ``
    data.forEach(e => {
        subToCO += e.quantity * e.products.price
        estimaToCO += e.quantity * e.products.price
        html1 += `<div class="cart-left-form">
        <table>
            <thead>
                <tr>
                    <th style="text-align: left;">PRODUCT</th>
                    <th style="text-align: center;">PRICE</th>
                    <th style="text-align: center;">QTY</th>
                    <th style="text-align: right;">TOTALL PRICE</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <div class="row d-flex flex-wrap row-cols-auto cart-product-left">
                            <div class="col"><img
                                    src="/image/${e.products.image}"
                                    alt="" height="125px" width="100px"></div>
                            <div class="col cart-product-mota">
                                <div class="cart-product-mota-name">${e.products.productName}</div>
                                <div class="cart-product-mota-id">${e.products.productCode}-${e.products.id}</div>
                            </div>
                        </div>
                    </td>
                    <td class="cart-product-price" style="text-align: center;">${formatVND(e.products.price)}</td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-btn">
                            </span>
                            <input type="text" id="quantity" name="quantity"
                                class="form-control input-number quantity-cart" value="${e.quantity}" min="1" max="100">
                            <span class="input-group-btn">
                            </span>
                        </div>
                    </td>
                    <td style="text-align: right;">${formatVND(e.products.price * e.quantity)}</td>
                </tr>
            </tbody>
        </table>
    </div>`
    });

    subToTalCO.innerHTML = `${formatVND(subToCO)}`
    //ship
    const select = document.getElementById('selectShip');
    console.log(select.selectedIndex);
    estiamteTotalCO.innerHTML = `${formatVND(estimaToCO)}`
    select.addEventListener('change', function handleChange(event) {
        loadShip.innerHTML = `${formatVND(select.value)}`
        esShipTo = estimaToCO + Number(select.value)
        estiamteTotalCO.innerHTML = `${formatVND(esShipTo)}`
        estiamteTotalCOfk.innerHTML = `${esShipTo}`
    });


    loadGioH.innerHTML = html1
}

const editGioHang = () => {
    window.location.href = 'http://localhost:8080/CartDetail'
}


function orderNow() {
    let checkOrder = checkoutjs()
    if (checkOrder) {
        orderCreate()
        // alert("ok")
    }
}

function checkoutjs() {
    const fullname = _$('#fullnameCO').value
    const Address = _$('#addressCO').value
    const PaymentType = _$('#loadPM').value
    const city = _$('#city')
    const district = _$('#district')
    const ward = _$('#ward')
    const shipFee = _$('#selectShip').value
    const totalEs = _$('#estiameTotalCOfake').innerHTML

    // alert(Number(shipFee))

    const city1 = city.options[city.selectedIndex].text
    const district1 = district.options[district.selectedIndex].text
    const ward1 = ward.options[ward.selectedIndex].text

    // alert(dataCart)
    // console.log(dataCart)



    dataNewOrder = {
        "users": {
            "id": userPro
        },
        "shipName": fullname,
        "shipAddress": Address,
        "shipCity": city1,
        "shipDistrict": district1,
        "totalOrder": totalEs,
        "shipPhuong": ward1,
        "shipFee": shipFee,
        "paymentTypes": {
            "id": PaymentType
        },
        "orderStatus": "Chờ xác nhận"
    }

    if (fullname.replaceAll(' ', '') == '') {
        Swal.fire("Message", 'Vui lòng nhập Name', "error")
        return
    }

    http.post('http://localhost:8080/Orders/add', dataNewOrder)
        .then(data => {
            // console.log(data)
            //         console.log(dataCart)
            if (data.id) {
                let idOrder = data.id
                dataCart.forEach(e => {
                    let dataNewOrderDetail = {
                        "quantity": e.quantity,
                        "orders": {
                            "id": idOrder
                        },
                        "products": {
                            "id": e.products.id
                        },
                        "price": e.quantity * e.products.price
                    }

                    //post create order detail
                    http.post('http://localhost:8080/OrderDetail/add', dataNewOrderDetail)
                })
                //remove cart checkout
                http.delete(`http://localhost:8080/cartuser/delete/user/${userPro}`)

            }
            Swal.fire("Message", "Đặt hàng thành công", "success")
                .then(rs => {
                    if (rs.isConfirmed) window.location.href = 'http://localhost:8080'
                })
        })
        .catch(err => console.log(err))
}

function orderCreate() {
    if (dataNewOrder == {}) {
        return false
    }
    // post create new order => order_id
    http.post(`http://localhost:8080/Orders/addOrder`, dataNewOrder)
        .then(data => {
            // if (data.id) {
            //     let idOrder = data.id
            //     dataCart.forEach(e => {
            //         let dataNewOrderDetail = {
            //             "quantity": e.quantity,
            //             "orders": {
            //                 "id": idOrder
            //             },
            //             "products": {
            //                 "id": e.products.id
            //             },
            //             "price": e.quantity * e.products.price
            //         }

            //         //post create order detail
            //         http.post('http://localhost:8080/OrderDetail/add', dataNewOrderDetail)
            //     })
            //     //remove cart checkout
            //     http.delete(`http://localhost:8080/cartuser/delete/user/${userPro}`)
            //         .then(rsp => {
            //             window.location.href = 'http://localhost:8080/'
            //         })

            // }
        })
}
const loadPaymentType = (data) => {
    let loadPM = _$('#loadPM')
    let html = ``
    html = `<option value="" selected>Chọn</option>`
    data.forEach(e => {
        html += `<option value="${e.id}">${e.supplierName}-${e.description}</option>`
    });
    loadPM.innerHTML = html
}