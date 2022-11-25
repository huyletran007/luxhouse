(function () {
    $(".shopping-cart").first().fadeToggle("linear");

    $("#cart").on("click", function () {
        $(".shopping-cart").fadeToggle("fast");
    });
})();

const checkout = () => {
    window.location.href = 'http://localhost:8080/check-out'
}

let cartCount = 3;
const addToCartBtn = document.getElementById("add-btn");
const removeBtn = document.getElementById("remove-btn");
const cartBadge = document.getElementById("cart-count");
const box = document.getElementById("box");

addToCartBtn.addEventListener("click", (event) => {
    box.classList.add("add-box");
    cartCount++;
    setTimeout((e) => {
        cartBadge.innerHTML = cartCount;
    }, 500);
    setTimeout((e) => {
        box.classList.remove("add-box");
    }, 1000);
});

removeBtn.addEventListener("click", (event) => {
    if (cartCount - 1 >= 0) {
        box.classList.add("remove-box");
        cartCount--;
        setTimeout((e) => {
            cartBadge.innerHTML = cartCount;
        }, 500);
        setTimeout((e) => {
            box.classList.remove("remove-box");
        }, 1000);
    }
});