function removeCart(id) {
    Swal.fire({
        title: "Message",
        text: "Xóa voucher này khỏi giỏ hàng của bạn",
        icon: "info",
        showCancelButton: true,
        cancelButtonColor: '#d33',
        confirmButtonText: 'Oke'
    }).then((willBlock) => {
        if (willBlock.isConfirmed) {
            http.delete(`http://localhost:8080/cartuser/delete/${id}`)
            .then(data => {window.location.reload()})
            .catch(err => console.log(err))
        }
    })

}

const LoadCartDetail = (data) => {
    let wrapProfile = _$('#loadDataCart-js')
    let subTotal = _$('#subTotal')
    let estiameTotal = _$('#estiameTotal')
    let subTo = 0, estimaTo = 0
    let html = ``
    LoadCartDetail.innerText = data.length
    data = data.reverse()
    data.forEach(e => {
        subTo += e.quantity * e.products.price
        estimaTo += e.quantity * e.products.price
        html += /*html*/ `<div class="cart-left-form">
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
                                <button class="cart-product-mota-btn-remove" onclick="removeCart(${e.id})" type="button">remove</button>
                            </div>
                        </div>
                    </td>
                    <td class="cart-product-price" style="text-align: center;">${formatVND(e.products.price)}</td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-btn">
                                <button type="button" class="quantity-left-minus btn btn-number"
                                    data-type="minus" data-field="">
                                    -
                                </button>
                            </span>
                            <input type="text" id="quantity1" name="quantity1"
                                class="form-control input-number quantity-cart" value="${e.quantity}" min="1" max="100">
                            <span class="input-group-btn">
                                <button type="button" class="quantity-right-plus btn btn-number"
                                    data-type="plus" data-field="">
                                    +
                                </button>
                            </span>
                        </div>
                    </td>
                    <td style="text-align: right;">${formatVND(e.products.price * e.quantity)}</td>
                </tr>
            </tbody>
        </table>
    </div>`
    })
    subTotal.innerHTML = `${formatVND(subTo)}`
    estiameTotal.innerHTML = `${formatVND(estimaTo)}`
    wrapProfile.innerHTML = html
}

$(document).ready(function () {

    var quantitiy1 = 0;
    $('.quantity-right-plus').click(function (e) {

        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantitiy1 = parseInt($('#quantity1').val());

        // If is not undefined

        $('#quantity1').val(quantitiy1 + 1);


        // Increment

    });

    $('.quantity-left-minus').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantitiy1 = parseInt($('#quantity1').val());

        // If is not undefined

        // Increment
        if (quantity > 0) {
            $('#quantity1').val(quantitiy1 - 1);
        }
    });

});
let userCart = _$('#userId').innerHTML
http.get(`http://localhost:8080/cartuser/get/users/${userCart}`)
    .then(data => LoadCartDetail(data))
    .catch(err => console.log(err))