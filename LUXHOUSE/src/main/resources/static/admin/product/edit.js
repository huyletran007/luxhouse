const addProduct = () => {

    let newProduct = productInvalid()

    if (!newProduct) {
        return false
    }

    http.post("http:/localhost:8080/Product/add", newProduct)
        .then(data => {
            Swal.fire('Success', 'Thêm sản phẩm thành công', 'success')
                .then(rs => window.location.href = "http://localhost:8080/admin/productManager/table")
        })

}

const editProduct = () => {

    let productEdit = productInvalid(1)

    if (!productEdit) {
        return false
    }

    http.put("http:/localhost:8080/Product/update", productEdit)
        .then(data => {
            Swal.fire('Success', 'Chỉnh sửa sản phẩm thành công', 'success')
                .then(rs => window.location.href = `http:/localhost:8080/admin/productManager/edit/product/${data.id}`)
        })
}

function productInvalid(type = 0) {
    let product_name = _$('#product_name')
    let product_code = _$('#product_code')
    let image = _$('#image')
    let image_list = _$('#image_list')
    // let short_description = _$('#short_description')
    // let description = _$('.ck-content')
    // let standard_cost = _$('#standard_cost')
    let price = _$('#price')
    let quantity = _$('#quantity')
    let discontinued = false
    let category_id = _$('#categories')
    let is_featured = false
    let is_new = false
    let status = true


    if (!product_name || product_name.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập tên sản phẩm', 'info')
        return false
    }

    if (!product_code || product_code.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập mã sản phẩm (slug)', 'info')
        return false
    }

    if (!image || image.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập hình ảnh chính của sản phẩm', 'info')
        return false
    }

    // if(!image_list || image_list.value.replaceAll(' ', '') == '') {
    //     Swal.fire('Message', 'Vui lòng nhập list hình ảnh sản phẩm', 'info')
    //     return false
    // }


    if (!price || price.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập giá niêm yết sản phẩm', 'info')
        return false
    }

    if (!quantity || quantity.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập số lượng trên mỗi đơn vị', 'info')
        return false
    }

    let result = {
        productCode: product_code.value,
        productName: product_name.value,
        image: image.value,
        price: price.value * 1,
        quantity: quantity.value,
        discontinued,
        is_featured,
        is_new,
        status,
        categoryProducts: {
            id: category_id.value
        }
    }

    if (type == 1) { // edit
        result.id = _$('#product_id').value * 1
        result.is_featured = _$('#is_featured').checked
        result.is_new = _$('#is_new').checked
    }

    return result
}

const onChangeFile = (e) => {
    let output = document.getElementById('image-view');


    uploadToImgur(e, output, e.target.files[0])
}

_$$('input[type="number"]').forEach(e => {
    e.value = parseFloat(e.value)
})