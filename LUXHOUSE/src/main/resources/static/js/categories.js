http.get("http://localhost:8080/Categories/get")
    .then(data => setDataCategories(data, 0))
    .catch(err => console.log(err))

http.get(`http://localhost:8080/CategoryProduct/get/cate`)
    .then(data => setDataCategories(data, 1))
    .catch(err => console.log(err))

var dataCategories = []

var setDataCategories = (data, i) => {
    dataCategories[i] = data
}

const loadCategoryJs = (data) => {
    let [data0, data1] = data
    let wrapCatePro = _$('#category-js')
    let htmlCate = ``

    // data1.forEach(c => {

    // })

    let cateHead = `<li>
                        <a href="/home">home</a>
                    </li>`

    data0.forEach(e => {
        let htmlChild = ``
        data1.forEach(e1 => {
            if(e.id == e1.categories.id){
                htmlChild += `<li><a href="/products/CateP/${e1.categoryProductCode}" class="cateChild">${e1.categoryProductName}</a></li>`
            }
            
        })

        htmlCate += /*html*/ `<li class="drop-header">
        <!-- data-bs-toggle="dropdown" -->
        <a href="#" class="menu-link dropdown-toggle" id="dropdownMenuButtonId${e.id}" data-toggle="dropdown" aria-expanded="false">
            ${e.categoryName}
            <span class="drop-icon">
                    <!-- <i class="fas fa-chevron-down"></i> -->
                    <div style="display: none;" id="idCate">${e.id}</div>
                </span>
            </a>

        
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonId${e.id}">
               
        <!-- item -->
        <div class="sub-menu-item">
            <h4>TOP CATEGORIES</h4>
            <ul>
                ${htmlChild}
            </ul>
        </div>
        <!-- end of item -->
        

        <!-- item -->
        <div class="sub-menu-item">
            <h2>all essential devices and tools for home</h2>
            <a href="/products/CateM/${e.categoryCode}" type="button" class="btn">SHOW ALL</a>
        </div>
        <!-- end of item -->
        
        <!-- item -->
        <div class="sub-menu-item">
            <img src="/image/categories/${e.image}" class="responsive">
        </div>
        <!-- end of item -->

        </ul>
        
    </li>`
    })
    let cateLast = `<li>
                        <a href="#">deals</a>
                    </li>`


    wrapCatePro.innerHTML = cateHead + htmlCate + cateLast
}

setTimeout(() => {
    loadCategoryJs(dataCategories)
}, 1000)