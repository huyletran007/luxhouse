let limit = 9
let currentPage = 1
let pagePrev, pageNext
let htmlPagePrev, htmlPageNext
let total_page, total_product

const loadProduct = (data) => {
    let wrapProduct = _$('#productlist-js')
    let html = ``
    data.forEach(e => {
        html += /*html*/ `<div class="product-items-list mx-auto">
        <a href="#" class="product-item">
            <img src="/image/${e.image}" class="img-fluid" alt="">
            <div class="text-left product_name">${e.productName}</div>
            <div class="text-left product_price">${formatVND(e.price)}</div>
        </a>
    </div>`
    })
    wrapProduct.innerHTML = html
}

const loadPages = (totalProduct) => {
    let pagination = _$('.paginationP')
    total_product = totalProduct

    total_page = Math.floor(total_product / limit) + 1

    let htmlPages = ``,
        htmlPagesPrev = ``,
        htmlPagesNext = ``

    for (let i = currentPage + 1; i <= currentPage + 3; i++) {
        if (i > total_page) break
        htmlPagesNext += `<li class="page-item ${i == currentPage ? 'active' : ''}">
            <button class="page-link" onclick="genderProduct(${i})">${i}</button>
        </li>`
    }

    for (let i = currentPage - 1; i >= currentPage - 3; i--) {
        if (i < 1) break
        htmlPagesPrev = `<li class="page-item ${i == currentPage ? 'active' : ''}">
            <button class="page-link" onclick="genderProduct(${i})">${i}</button>
        </li>` + htmlPagesPrev
    }

    htmlPages += `<li class="page-item active">
        <button class="page-link" onclick="genderProduct(${currentPage})">${currentPage}</button>
    </li>`

    pagePrev = (currentPage - 1 < 1) ? total_page : currentPage - 1
    pageNext = (currentPage + 1 > total_page) ? 1 : currentPage + 1
    htmlPagePrev = `<li class="page-item">
        <button class="page-link" onclick="genderProduct(${pagePrev})"
            tabindex="-1">Previous</button>
    </li>`
    htmlPageNext = `<li class="page-item">
        <button class="page-link" onclick="genderProduct(${pageNext})"
            tabindex="-1">Next</button>
    </li>`

    pagination.innerHTML = htmlPagePrev + htmlPagesPrev + htmlPages + htmlPagesNext + htmlPageNext
}

http.get("http://localhost:8080/Product/get")
    .then(data => loadPages(data.length))
    .catch(err => console.log(err))

const genderProduct = (page) => {
    currentPage = page
    loadPages(total_product)
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    })
    http.get(`http://localhost:8080/Product/get/${currentPage-1}/${limit}`)
        .then(data => loadProduct(data))
        .catch(err => console.log(err))
}
genderProduct(currentPage)