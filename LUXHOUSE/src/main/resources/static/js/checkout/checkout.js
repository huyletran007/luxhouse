let userPro = _$('#userId').innerHTML
http.get(`http://localhost:8080/cartuser/get/users/${userPro}`)
    .then(data => loadGioHang(data))
    .catch(err => console.log(err))

http.get(`http://localhost:8080/Users/get/${userPro}`)
    .then(data => loadcea(data))
    .catch(err => console.log(err))

http.get('http://localhost:8080/PaymentType/get')
    .then(data => loadPaymentType(data))
    .catch(err => console.log(err))

const loadGioHang = (data) =>{
    let loadGioH = _$('#loadGH')
    let subToTalCO = _$('#subTotalCO')
    let estiamteTotalCO = _$('#estiameTotalCO')
    let subToCO = 0, estimaToCO = 0
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
    estiamteTotalCO.innerHTML = `${formatVND(estimaToCO)}`
    loadGioH.innerHTML = html1
}

const editGioHang = () => {
    window.location.href = 'http://localhost:8080/CartDetail'
}

const checkout_js = () => {
    alert(userPro)
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
