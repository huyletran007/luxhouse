let limit = 9
let currentPage = 1
let pagePrev, pageNext
let htmlPagePrev, htmlPageNext
let total_page, total_product

http.get("http://localhost:8080/Categories/get")
    .then(data => setDateCate(data, 0))
    .catch(err => console.log(err))

http.get(`http://localhost:8080/CategoryProduct/get/cate`)
    .then(data => setDateCate(data, 1))
    .catch(err => console.log(err))

var dataCate = []

var setDateCate = (data, i) => {
    dataCate[i] = data
}

const loadCategories = (data) => {
    let [ct0, ct1] = data

    let html = ``

    ct0.forEach(e0 => {
        let loadDetail = ``
        ct1.forEach(e1 => {
            if (e0.id == e1.categories.id) {
                loadDetail += `<li><a href="/products/CateP/${e1.categoryProductCode}">${e1.categoryProductName}</a></li>`
            }
        })

        html += `<div class="card cr">
        <a class="card-link acd" data-toggle="collapse" href="#collapse${e0.id}">
          ${e0.categoryName}
        </a>

      <div id="collapse${e0.id}" class="collapse" data-parent="#accordion">
        <div class="card-body">
            <ul>
                ${loadDetail}
            </ul>
        </div>
      </div>
    </div>`
    })


    let warpCate = _$('.loadCate-js')
    warpCate.innerHTML = html
}

setTimeout(() => {
    loadCategories(dataCate)
}, 1000)



const loadProduct = (data) => {
    let wrapProduct = _$('#productlist-js')
    let html = ``
    data.forEach(e => {
        html += /*html*/ `<div class="product-items-list mx-auto">
        <a href="${_URL_MAIN}/products/${e.id}" class="product-item">
            <img src="/image/${e.image}" class="img-fluid" alt="">
            <div class="text-left product_name">${e.productName}</div>
            <div class="text-left product_price">${formatVND(e.price)}</div>
        </a>
    </div>`
    })
    if (data.length > 0) {


        wrapProduct.innerHTML = html
    }
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


// const loadProductDetail = (data) => {
//     let wrapProduct = _$('#product-detail-js')
//     let html = ``
//     data.forEach(e => {
//         html += /*html*/ `<div class="right-new">NEW</div>
//         <div class="right-name">${e.productName}</div>
//         <div class="right-price">1000$</div>
//         <div class="right-qty">
//             <div class="qty-name">Quantity</div>
//             <div class="qty-sl">
//                 <div class="counter">
//                     <span class="down" onClick='decreaseCount(event, this)'>-</span>
//                     <input type="text" value="1">
//                     <span class="up" onClick='increaseCount(event, this)'>+</span>
//                 </div>
//             </div>
//         </div>
//         <div class="right-btn">
//             <button type="button" class="btn1" id="add-btn">Add to cart</button>
//         </div>
//         <div class="right-according">
//             <button class="accordion1">Desciption 1</button>
//             <div class="panel">
//                 <p>
//                     Lorem ipsum dolor sit amet consectetur, adipisicing elit. Cumque eveniet
//                     deleniti id, tenetur ullam ipsam vitae sunt, laudantium temporibus
//                     consequatur architecto a magni sit tempora ea error veritatis aperiam.
//                     Illum.
//                 </p>
//             </div>

//             <button class="accordion1">Desciption 2</button>
//             <div class="panel">
//                 <p>
//                     Lorem ipsum dolor sit amet consectetur, adipisicing elit. Cumque eveniet
//                     deleniti id, tenetur ullam ipsam vitae sunt, laudantium temporibus
//                     consequatur architecto a magni sit tempora ea error veritatis aperiam.
//                     Illum.
//                 </p>
//             </div>

//             <button class="accordion1">Desciption 3</button>
//             <div class="panel">
//                 <p>
//                     Lorem ipsum dolor sit amet consectetur, adipisicing elit. Cumque eveniet
//                     deleniti id, tenetur ullam ipsam vitae sunt, laudantium temporibus
//                     consequatur architecto a magni sit tempora ea error veritatis aperiam.
//                     Illum.
//                 </p>
//             </div>
//         </div>`
//     })
//     wrapProduct.innerHTML = html
// }
// http.get(`http://localhost:8080/Product/get/${value.id}`)
//         .then(data => loadProductDetail(data))
//         .catch(err => console.log(err))