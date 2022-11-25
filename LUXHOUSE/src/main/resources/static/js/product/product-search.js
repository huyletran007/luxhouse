function searchProduct() {
    const name = _$("#nameProduct").value
    console.log(name)
    http.get(`http://localhost:8080/Product/getName/${name}`)
        .then(data => loadSearch(data))
        .catch(err => console.log(err))
}

const loadSearch = (data) => {
    let load = _$("#productlist-js")
    let html = ``

    data.forEach(e => {
        html += `<div class="product-items-list mx-auto">
        <a href="/products/${e.id}" class="product-item">
            <img src="/image/${e.image}" class="img-fluid" alt="">
            <div class="text-left product_name">${e.productName}</div>
            <div class="text-left product_price">${formatVND(e.price)}</div>
        </a>
    </div>`
    });
    load.innerHTML = html
}