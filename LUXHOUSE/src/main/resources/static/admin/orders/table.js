// let limit = 5
// let currentPage = 0
// let pagePrev, pageNext
// let htmlPagePrev, htmlPageNext
// let total_page, total_Payment

const loadOrder = (data) => {
    let warpOrder = _$('#loadOrder-js')
    let html = ``

    data = data.reverse()
    data.forEach(e => {
        html += `<tr>
        <td>${e.supplierCode}</td>
        <td>${e.supplierName}</td>
        <td>${e.description}</td>
        <td>${e.created_at}</td>
        <td>${e.updated_at}</td>
        <td>
            <div class="form-button-action">
                <button type="button" data-toggle="tooltip${e.id}" title=""
                    class="btn btn-link btn-primary btn-lg"
                    data-original-title="Edit ${e.id}">
                    <i class="fa fa-edit"></i>
                </button>
                <button type="button" data-toggle="tooltip${e.id}" title=""
                    class="btn btn-link btn-danger" data-original-title="Remove${e.id}">
                    <i class="fa fa-times"></i>
                </button>
            </div>
        </td>
    </tr>`
    })
    if (data.length > 0) {
        warpOrder.innerHTML = html
    }
}

    http.get("http://localhost:8080/PaymentType/get")
    .then(data => loadOrder
        
        (data))
    .catch(err => console.log(err))
// const loadPage = (totalPayment) => {
//     let pagination = _$('.paginationP')
//     total_payment = totalPayment
//     total_page = Math.floor(total_payment / limit) + 1

//     let htmlPages = ``,
//         htmlPagesPrev = ``,
//         htmlPagesNext = ``

//     for (let i = currentPage + 1; i <= currentPage + 3; i++) {
//         if (i > total_page) break
//         htmlPagesNext += `<li class="paginate_button page-item ${i == currentPage ? 'active' : ''}">
//             <button class="page-link" onclick="genderPayment(${i})">${i}</button>
//             </li>`
//     }

//     for (let i = currentPage - 1; i >= currentPage - 3; i--) {
//         if (i < 1) break
//         htmlPagesPrev = `<li class="paginate_button page-item ${i == currentPage ? 'active' : ''}">
//             <button class="page-link" onclick="genderPayment(${i})">${i}</button>
//             </li>` + htmlPagesPrev
//     }

//     htmlPages += ` <li class="paginate_button page-item active">
//     <button class="page-link" onclick="genderPayment(${currentPage})">${currentPage}</button>
//     </li>`

//     pagePrev = (currentPage - 1 < 1) ? total_page : currentPage - 1
//     pageNext = (currentPage + 1 > total_page) ? 1 : currentPage + 1

//     htmlPagePrev = `<li class="paginate_button page-item previous">
//     <button class="page-link" onclick="genderPayment(${pagePrev})" tabindex="-1">Previous</button>
//     </li>`
//     htmlPageNext = `<li class="paginate_button page-item previous">
//     <button class="page-link" onclick="genderPayment(${pageNext})" tabindex="-1">Next</button>
//     </li>`

//     pagination.innerHTML = htmlPagePrev + htmlPagesPrev + htmlPages + htmlPagesNext + htmlPageNext
// }



// const genderPayment = (page) => {
//     currentPage = page
//     loadPage(total_payment)
//     window.scrollTo({
//         top: 0,
//         behavior: 'smooth'
//     })
//     http.get(`http://localhost:8080/PaymentType/get/${currentPage-1}/${limit}`)
//         .then(data => loadPayment(data))
//         .catch(err => console.log(err))
// }
// genderPayment(currentPage)