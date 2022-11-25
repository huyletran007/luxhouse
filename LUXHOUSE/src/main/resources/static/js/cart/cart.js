function addProductToCart() {
    let idCtmc = document.getElementById('productId')
    let idCtm = document.getElementById('idProduct-js')
    let userName = document.getElementById('userId')
    let warpCartIndex = _$('#cart-user-load')

    const quantity = document.getElementById("quantityP").value
    const productId = _$('#productId')
    const userId = _$('#userId')

    // alert(idCtm.innerHTML)
    if (userName.innerText == '') {
        alert('NO')
        // cartReview()
    } else if (userName) {
        // alert(productId.innerHTML)
        const quantity = document.getElementById("quantityP").value
        const productId = _$('#productId')
        const userId = _$('#userId')

        let dataCart = {
            "quantity": quantity,
            "users": {
                "id": userId.innerHTML
            },
            "products": {
                "id": productId.innerHTML
            }
        }

        http.post(`http://localhost:8080/cartuser/add`, dataCart)
            .then(data => {
                Swal.fire("Oke", 'Đặt hàng thành công', "success")
                    .then(rs => {
                        if (rs.isConfirmed) location.reload()
                    })
            })
            .catch(err => console.log(err))
        loadCart()
    }

    // http.post(`${_URL_MAIN}/ShopUsersCart/add`, data)
    //     .then(data => {
    //         if(data.status == 200) {
    //             cartReview()
    //         } else {

    //             Swal.fire("Message", "Đã có lỗi xảy ra, vui lòng thử lại.", "error")
    //         }
    //     })
    // http.get(`http://localhost:8080/Product/get/${idCtm.innerHTML}`)
    //     .then(data => {
    //         var html = `<!-- <li class="clearfix">
    //         <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/cart-item1.jpg"
    //             alt="item1" />
    //         <span class="item-name">${data.id}</span>
    //         <span class="item-price">$849.99</span>
    //         <span class="item-quantity">Quantity: 01</span>
    //     </li> -->`
    //     warpCartIndex.innerHTML = html
    //     })
    // warpCartIndex.innerHTML = html
}


const loadCart = (data) => {
    var userName = document.getElementById('userId')
    let warpCart = _$('#cart-user-load')
    let totalQty = _$('#cart-count')
    let totalQtyC = _$('.totalQty')
    let totalPrice = _$('#totalPrice')
    let tongTien = 0,
        totalItems = 0,
        cartCount = 0
    var html = ``
    loadCart.innerText = data.length
    if (userName.innerText == '') {
        var html = `<div>Chưa có sản phẩm trong giỏ hàng</div>`
    } else {
        data = data.reverse()
        data.forEach((e, i) => {
            tongTien += e.quantity * e.products.price
            totalItems += e.quantity
            // 0 1 2 3 - 4 5 6 7
            if (i % 3 == 0) {
                html += `<li class="clearfix">
                <img src="/image/${e.products.image}"
                         alt="item1" width="70" height="70"/>
                     <span class="item-name">${e.products.productName}</span>
                     <span class="item-price">${formatVND(e.products.price)}</span>
                     <span class="item-quantity">Quantity: ${e.quantity}</span>
                     </li>
                `
            }

            if (i % 3 == 2) {
                html += `</li>`
            }
        })
        totalPrice.innerHTML = `${formatVND(tongTien)}`
        totalQty.innerHTML = `${totalItems}`
        totalQtyC.innerHTML = `${totalItems}`

    }
    warpCart.innerHTML = html
}

// let idpd = _$('#idProduct-js').innerHTML
// http.get(`http://localhost:8080/Product/get/${idpd}`)
//     .then(data => addProductToCarta(data.length))
//     .catch(err => console.log(err))
let userName = document.getElementById('userId')
http.get(`http://localhost:8080/cartuser/get/users/${userName.innerHTML}`)
    .then(data => loadCart(data))
    .catch(err => console.log(err))