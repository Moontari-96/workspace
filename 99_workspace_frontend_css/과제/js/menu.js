$(function () {
  var $header_list = $('.header > .header_wrap > .header_cont .header_list');
  var $header = $('.header');
  $header_list
    .mouseenter(function () {
      $header.stop().animate({ height: '500px' }, 30);
    })
    .mouseleave(function () {
      $header.stop().animate({ height: '60px' }, 30);
    });
});
