$(function () {
  var page = $("#fullpage").fullpage({
    // 스크롤 허용 옵션 표기
    navigation: true, // 섹션 탐색 메뉴 표시
    verticalCentered: true,
    scrollHorizontally: true,
  });
  var product_swiper = new Swiper(".cont2 .product_swiper", {
    slidesPerView: 2,
    spaceBetween: 30,
    freeMode: true,
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
  });

  var main_swiper = new Swiper(".cont1 .main_swiper", {
    slidesPerView: 1,
    spaceBetween: 30,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
});
