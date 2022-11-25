let limit = 2
let currentPage = 1
let pagePrev, pageNext
let htmlPagePrev, htmlPageNext
let total_page, total_user

const loadUser = (data) => {
    let warpUser = _$('#loadUser-js')
    let html = ``

    data = data.reverse()
    data.forEach(e => {
        html += `<tr>
        <td>${e.avartar}</td>
        <td>${e.username}</td>
        <td>${e.fullname}</td>
        <td>${e.gender  ? 'Nam' : 'Nữ'}</td>
        <td>${e.email}</td>
        <td>${e.phone}</td>
        <td>${e.address}</td>
        <td>${e.status ? 'Active' : 'Disable'}</td>
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
        warpUser.innerHTML = html
    }
}
const loadPage = (totalUser) => {
    let pagination = _$('.paginationP')
    total_user = totalUser
    total_page = Math.floor(total_user / limit) + 1

    let htmlPages = ``,
        htmlPagesPrev = ``,
        htmlPagesNext = ``

    for (let i = currentPage + 1; i <= currentPage + 3; i++) {
        if (i > total_page) break
        htmlPagesNext += `<li class="paginate_button page-item ${i == currentPage ? 'active' : ''}">
            <button class="page-link" onclick="genderUser(${i})">${i}</button>
            </li>`
    }

    for (let i = currentPage - 1; i >= currentPage - 3; i--) {
        if (i < 1) break
        htmlPagesPrev = `<li class="paginate_button page-item ${i == currentPage ? 'active' : ''}">
            <button class="page-link" onclick="genderUser(${i})">${i}</button>
            </li>` + htmlPagesPrev
    }

    htmlPages += ` <li class="paginate_button page-item active">
    <button class="page-link" onclick="genderUser(${currentPage})">${currentPage}</button>
    </li>`

    pagePrev = (currentPage - 1 < 1) ? total_page : currentPage - 1
    pageNext = (currentPage + 1 > total_page) ? 1 : currentPage + 1

    htmlPagePrev = `<li class="paginate_button page-item previous">
    <button class="page-link" onclick="genderUser(${pagePrev})" tabindex="-1">Previous</button>
    </li>`
    htmlPageNext = `<li class="paginate_button page-item previous">
    <button class="page-link" onclick="genderUser(${pageNext})" tabindex="-1">Next</button>
    </li>`

    pagination.innerHTML = htmlPagePrev + htmlPagesPrev + htmlPages + htmlPagesNext + htmlPageNext
}

http.get("http://localhost:8080/Users/get")
    .then(data => loadPage(data.length))
    .catch(err => console.log(err))

const genderUser = (page) => {
    currentPage = page
    loadPage(total_user)
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    })
    http.get(`http://localhost:8080/Users/get/${currentPage-1}/${limit}`)
        .then(data => loadUser(data))
        .catch(err => console.log(err))
}
genderUser(currentPage)