// Khai báo rút gọn query seletor
const _$ = document.querySelector.bind(document)
const _URL_MAIN = 'http://localhost:8080'

function formatVND(value) {
    return new Intl.NumberFormat().format(value) + ' ₫'
}