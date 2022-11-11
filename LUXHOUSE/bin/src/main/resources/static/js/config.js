const _URL_MAIN = 'http://localhost:8080'
const _ADMIN_DIR = '/admin-panel'


function formatVND(value) {
    return new Intl.NumberFormat().format(value) + ' ₫'
}