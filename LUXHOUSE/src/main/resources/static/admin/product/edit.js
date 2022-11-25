const addProduct = () => {

    const product_name = _$('#product_name')
    const product_code = _$('#product_code')
    const image = _$('#image')
    const price = _$('#price')
    const quantity = _$('#quantity')
    const discontinued = false
    const category_id = _$('#categories')
    const is_featured = false
    const is_new = false
    const status = true


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

    if (!price || price.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập giá niêm yết sản phẩm', 'info')
        return false
    }

    if (!quantity || quantity.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập số lượng trên mỗi đơn vị', 'info')
        return false
    }

    let data = {
        "productCode": product_code.value,
        "productName": product_name.value,
        "image": image.value,
        "price": price.value,
        "quantity": quantity.value,
        "discontinued": false,
        "is_featured": false,
        "is_new": false,
        "status": true,
        "categoryProducts": {
            "id": category_id.value
        }
    }


    http.post("http://localhost:8080/Product/add", data)
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

    http.put("http://localhost:8080/Product/update", productEdit)
        .then(data => {
            Swal.fire('Success', 'Chỉnh sửa sản phẩm thành công', 'success')
                .then(rs => window.location.href = `http://localhost:8080/admin/productManager/table`)
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

    if (!price || price.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập giá niêm yết sản phẩm', 'info')
        return false
    }

    if (!quantity || quantity.value.replaceAll(' ', '') == '') {
        Swal.fire('Message', 'Vui lòng nhập số lượng trên mỗi đơn vị', 'info')
        return false
    }

    let result = {
        "productCode": product_code,
        "productName": product_name,
        "image": image,
        "price": price,
        "quantity": quantity,
        "discontinued": false,
        "is_featured": false,
        "is_new": false,
        "status": true,
        "categoryProducts": {
            "id": category_id
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