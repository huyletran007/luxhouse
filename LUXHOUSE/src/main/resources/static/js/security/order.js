var userPro = _$('#userId').innerHTML


http.get(`http://localhost:8080/Orders/get/userid/${userPro}`)
    .then(data => {
        setDataOrder(data, 0),
            loadXemDonhang(data)
    })
    .catch(err => console.log(err))

http.get("http://localhost:8080/OrderDetail/get")
    .then(data => setDataOrder(data, 1))
    .catch(err => console.log(err))

var dataOrder = []

var setDataOrder = (data, i) => {
    dataOrder[i] = data
}

http.get(`http://localhost:8080/Users/get/${userPro}`)
    .then(data => loadcea(data))
    .catch(err => console.log(err))
//XEM DON HANG
const loadXemDonhang = (data) => {
    let loadFeatures = _$("#loadFeatures")
    let loadShipping = _$("#loadShipping")
    let loadFinish = _$("#loadFinish")
    let loadReturn = _$("#loadReturn")
    let html1 = ``
    let html2 = ``
    let html3 = ``
    let html4 = ``

    data.forEach(e => {
        let dataO = `<div class="cart-cxn">
    <div class="trang-thai d-flex justify-content-end">
        <div>Trang thai: ${e.orderStatus}</div>
    </div>
    <div class="d-flex">
        <div class="cart-cxn-img col-4">
            <div class="text-sm-center text-md-start align-self-center my-3">
            Order-date: ${e.order_date}
            </div>
        </div>
        <div class="cart-cxn-nd col-6">
            <div class="cart-cxn-nd-name">
                #${e.id}
            </div>
        </div>
        <div class="cart-cxn-price col-2">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" style="color: black;"
            onclick="viewOrderDetail()">
            VIEW
        </button>
        </div>
    </div>
    <div class="btn-cart-kt d-flex justify-content-end">
        <button class="xem-ct col-6">Đánh giá</button>
        <div class="tt-cart col-6">Tổng tiền: ${formatVND(e.totalOrder)} </div>
    </div>
</div>`
        if (e.orderStatus == "Chờ xác nhận") {
            html1 += `${dataO}`
        } else if (e.orderStatus == "Đang vận chuyển") {
            html2 += `${dataO}`
        } else if (e.orderStatus == "Giao thành công") {
            html3 += `${dataO}`
        } else if (e.orderStatus == "Hoàn trả") {
            html4 += `${dataO}`
        }

    });

    loadFeatures.innerHTML = html1
    loadShipping.innerHTML = html2
    loadFinish.innerHTML = html3
    loadReturn.innerHTML = html4
}
//END XEM DON HANG
// ORDER
var loadOrders = (data) => {
    let [order0, order1] = data
    let warpOrder = _$('#loadOrder')
    let html = ``
    // console.log(order0.id)

    order0.forEach(e => {
        let htmlChil = ``
        order1.forEach(e1 => {
            if (e.id == e1.orders.id) {
                htmlChil += `<tr>
                <td width="20%">

                    <img src="/image/${e1.products.image}"
                        width="90">

                </td>

                <td width="60%">
                    <span class="font-weight-bold">${e1.products.productName}</span>
                    <div class="product-qty">
                        <span class="d-block">Quantity:${e1.quantity}</span>
                    </div>
                </td>
                <td width="20%">
                    <div class="text-right">
                        <span class="font-weight-bold">${formatVND(e1.price)}</span>
                    </div>
                </td>
            </tr>`
            }
        })

        html += `<div
        class="d-md-flex d-sm-block justify-content-md-between justify-content-sm-center text-center border-bottom border-2 my-2 bg-light p-2 rounded-3">
        <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
            <h1 class="h6">#${e.id}</h1>
        </div>
        <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
            <h1 class="h6">${e.order_date}</h1>
        </div>
        <div class="col-md-3 text-sm-center text-md-start align-self-center my-2">
            <h1 class="h6">${formatVND(e.totalOrder)}</h1>
        </div>


        <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
            <p>${e.orderStatus}</p>
        </div>


        <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
        <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" style="color: black;"
                    data-bs-target="#staticBackdrop${e.id}">
                    DETAIL
                </button>
                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop${e.id}" data-bs-backdrop="static" data-bs-keyboard="false"
                    tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content" style="width: 1000px; margin-left: -200px;">
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" style="color: black;"
                                    data-bs-dismiss="modal">Close</button>
                            </div>
                            <div class="container mt-5 mb-5">
                                <div class="row d-flex justify-content-center">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="text-left logo p-2 px-5">
                                                <img src="https://i.imgur.com/2zDU056.png" width="50">
                                            </div>
                                            <div class="invoice p-5">
                                                <h5>Your order Confirmed!</h5>
                                                <span class="font-weight-bold d-block mt-4">Hello, ${e.users.fullname}</span>
                                                <span>You order has been confirmed and will be shipped in next two
                                                    days!</span>
                                                <div
                                                    class="payment border-top mt-3 mb-3 border-bottom table-responsive">
                                                    <table class="table table-borderless">
                                                        <tbody>
                                                            <tr>
                                                                <td>
                                                                    <div class="py-2">
                                                                        <span class="d-block text-muted">Order
                                                                            Date</span>
                                                                        <span>${e.order_date}</span>
                                                                    </div>
                                                                </td>   
                                                                <td>
                                                                    <div class="py-2">
                                                                        <span class="d-block text-muted">Order
                                                                            No</span>
                                                                        <span>#${e.id}</span>
                                                                    </div>
                                                                </td>
                                                                <td>
                                                                    <div class="py-2">
                                                                        <span class="d-block text-muted">Payment type</span>
                                                                        <span>${e.paymentTypes.supplierCode}</span>
                                                                    </div>
                                                                </td>

                                                                <td>
                                                                    <div class="py-2">

                                                                        <span class="d-block text-muted">Shiping
                                                                            Address</span>
                                                                        <span>${e.shipAddress},${e.shipPhuong},${e.shipDistrict},${e.shipCity}</span>

                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </tbody>

                                                    </table>
                                                </div>
                                                <div class="product border-bottom table-responsive">

                                                    <table class="table table-borderless">

                                                        <tbody>
                                                            ${htmlChil}
                                                        </tbody>

                                                    </table>
                                                </div>
                                                <div class="row d-flex justify-content-end">

                                                    <div class="col-md-5">

                                                        <table class="table table-borderless">

                                                            <tbody class="totals">

                                                                <tr>
                                                                    <td>
                                                                        <div class="text-left">

                                                                            <span class="text-muted">Subtotal</span>

                                                                        </div>
                                                                    </td>
                                                                    <td>
                                                                        <div class="text-right">
                                                                            <span>${formatVND(e.totalOrder - e.shipFee)}</span>
                                                                        </div>
                                                                    </td>
                                                                </tr>


                                                                <tr>
                                                                    <td>
                                                                        <div class="text-left">

                                                                            <span class="text-muted">Shipping
                                                                                Fee</span>

                                                                        </div>
                                                                    </td>
                                                                    <td>
                                                                        <div class="text-right">
                                                                            <span>${formatVND(e.shipFee)}</span>
                                                                        </div>
                                                                    </td>
                                                                </tr>


                                                                <tr>
                                                                    <td>
                                                                        <div class="text-left">

                                                                            <span class="text-muted">Tax Fee</span>

                                                                        </div>
                                                                    </td>
                                                                    <td>
                                                                        <div class="text-right">
                                                                            <span>---</span>
                                                                        </div>
                                                                    </td>
                                                                </tr>


                                                                <tr>
                                                                    <td>
                                                                        <div class="text-left">

                                                                            <span class="text-muted">Discount</span>

                                                                        </div>
                                                                    </td>
                                                                    <td>
                                                                        <div class="text-right">
                                                                            <span class="text-success">---</span>
                                                                        </div>
                                                                    </td>
                                                                </tr>


                                                                <tr class="border-top border-bottom">
                                                                    <td>
                                                                        <div class="text-left">

                                                                            <span
                                                                                class="font-weight-bold">Subtotal</span>

                                                                        </div>
                                                                    </td>
                                                                    <td>
                                                                        <div class="text-right">
                                                                            <span
                                                                                class="font-weight-bold">${formatVND(e.totalOrder)}</span>
                                                                        </div>
                                                                    </td>
                                                                </tr>

                                                            </tbody>

                                                        </table>

                                                    </div>


                                                </div>


                                                <p>We will be sending shipping confirmation email when the item
                                                    shipped
                                                    successfully!</p>
                                                <p class="font-weight-bold mb-0">Thanks for shopping with us!</p>
                                                <span>Nike Team</span>


                                            </div>


                                            <div class="d-flex justify-content-between footer p-3">

                                                <span>Need Help? visit our <a href="#"> help center</a></span>
                                                <span>12 June, 2020</span>

                                            </div>


                                        </div>

                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>

        </div>
    </div>`
    });

    warpOrder.innerHTML = html
}
//END ORDER

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

setTimeout(() => {
    loadOrders(dataOrder)
}, 1000)