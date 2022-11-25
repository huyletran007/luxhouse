let limit = 10
let currentPage = 1
let pagePrev, pageNext
let htmlPagePrev, htmlPageNext
let total_page, total_product

const loadProductAd = (data) => {
    let warpProductAd = _$('#loadPr-js')
    let html = ``

    data = data.reverse()
    data.forEach(e => {
        html += `<tr>
        <td><img src="/image/${e.image}" alt="" style="height: 150px;"></td>
        <td>${e.productCode}</td>
        <td>${e.productName}</td>
        <td>${formatVND(e.price)}</td>
        <td>${e.status ? 'Đang hoạt động' : 'Đang ẩn'}</td>
        <td>${e.quantity}</td>
        <td>${e.quantity}</td>
        <td>
            <div class="form-button-action">
                <a href="./edit/product/${e.id}" data-toggle="tooltip" title=""
                    class="btn btn-link btn-primary btn-lg"
                    data-original-title="Edit ${e.id}">
                    <i class="fa fa-edit"></i>
                </a>
                <button type="button" class="btn btn-link btn-danger"  onclick="deleteProduct(${e.id})">
                    <i class="fa fa-times"></i>
                </button>
            </div>
        </td>
    </tr>`
    })
    if (data.length > 0) {
        warpProductAd.innerHTML = html
    }
}

const loadPage = (totalProduct) => {
    let pagination = _$('.paginationP')
    total_product = totalProduct
    total_page = Math.floor(total_product / limit) + 1

    let htmlPages = ``,
        htmlPagesPrev = ``,
        htmlPagesNext = ``

    for (let i = currentPage + 1; i <= currentPage + 3; i++) {
        if (i > total_page) break
        htmlPagesNext += `<li class="paginate_button page-item ${i == currentPage ? 'active' : ''}">
            <button class="page-link" onclick="genderProduct(${i})">${i}</button>
            </li>`
    }

    for (let i = currentPage - 1; i >= currentPage - 3; i--) {
        if (i < 1) break
        htmlPagesPrev = `<li class="paginate_button page-item ${i == currentPage ? 'active' : ''}">
            <button class="page-link" onclick="genderProduct(${i})">${i}</button>
            </li>` + htmlPagesPrev
    }

    htmlPages += ` <li class="paginate_button page-item active">
    <button class="page-link" onclick="genderProduct(${currentPage})">${currentPage}</button>
    </li>`

    pagePrev = (currentPage - 1 < 1) ? total_page : currentPage - 1
    pageNext = (currentPage + 1 > total_page) ? 1 : currentPage + 1

    htmlPagePrev = `<li class="paginate_button page-item previous">
    <button class="page-link" onclick="genderProduct(${pagePrev})" tabindex="-1">Previous</button>
    </li>`
    htmlPageNext = `<li class="paginate_button page-item previous">
    <button class="page-link" onclick="genderProduct(${pageNext})" tabindex="-1">Next</button>
    </li>`

    pagination.innerHTML = htmlPagePrev + htmlPagesPrev + htmlPages + htmlPagesNext + htmlPageNext
}

http.get("http://localhost:8080/Product/get")
    .then(data => loadPage(data.length))
    .catch(err => console.log(err))

const genderProduct = (page) => {
    currentPage = page
    loadPage(total_product)
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    })
    http.get(`http://localhost:8080/Product/get/${currentPage-1}/${limit}`)
        .then(data => loadProductAd(data))
        .catch(err => console.log(err))
}
genderProduct(currentPage)

function deleteProduct(id) {
    Swal.fire({
        title: "Are you sure ?",
        text: "Xóa sản phẩm đúng hong?",
        icon: "info",
        showCancelButton: true,
        cancelButtonColor: '#d33',
        confirmButtonText: 'Oke'
    }).then(isDeleted => {
        if (isDeleted.isConfirmed) {
            http.delete(`http://localhost:8080/ProductImages/delete/product/${id}`)
            http.delete(`http://localhost:8080/Product/delete/${id}`)
                .then(data => {
                    Swal.fire('Success', 'Xóa sản phẩm thành công', 'success')
                    window.location.reload()
                })
                .catch(err => Swal.fire('Message', 'Đã có lỗi xãy ra, vui lòng thử lại', 'info'))
        }
    })
}