// $(document).each(function () {

//     var quantitiy1 = 0;
//     $('.quantity-right-plus').click(function (e) {

//         // Stop acting like a button
//         e.preventDefault();
//         // Get the field name
//         var quantitiy1 = parseInt($('#quantity1').val());

//         // If is not undefined

//         $('#quantity1').val(quantitiy1 + 1);


//         // Increment

//     });

//     $('.quantity-left-minus').click(function (e) {
//         // Stop acting like a button
//         e.preventDefault();
//         // Get the field name
//         var quantitiy1 = parseInt($('#quantity1').val());

//         // If is not undefined

//         // Increment
//         if (quantity > 0) {
//             $('#quantity1').val(quantitiy1 - 1);
//         }
//     });

// });

$('input.quantity-cart').each(function() {
    var $this = $(this),
      qty = $this.parent().find('.btn-number'),
      min = Number($this.attr('min')),
      max = Number($this.attr('max'))
    if (min == 0) {
      var d = 0
    } else d = min
    $(qty).on('click', function() {
      if ($(this).hasClass('quantity-left-minus')) {
        if (d > min) d += -1
      } else if ($(this).hasClass('quantity-right-plus')) {
        var x = Number($this.val()) + 1
        if (x <= max) d += 1
      }
      $this.attr('value', d).val(d)
    })
  })