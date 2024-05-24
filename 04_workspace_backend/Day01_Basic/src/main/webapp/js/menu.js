// 헤더
$(document).ready(function () {
  $(".nav .depth_1 > li, .menu_bg").hover(
    function () {
      $(".header").addClass("active");
    },
    function () {
      $(".header").removeClass("active");
    }
  );
  //GNB / NAV
  $(".nav .depth_2 > li").hover(
    function () {
      $(".nav .depth_1 > li").removeClass("active");

      $(this).parents("li").addClass("active");
    },
    function () {
      $(".nav .depth_1 > li").removeClass("active");
      $(this).parents("li").removeClass("active");
    }
  );
  // 모바일
  $(".btn").click(function () {
    $(".mob_menu,.page_cover,html").addClass("open");
    window.location.hash = "#open";
  });

  window.onhashchange = function () {
    if (location.hash != "#open") {
      $(".mob_menu,.page_cover,html").removeClass("open");
    }
  };

  $(".mob_menu ul.sub_mobile").hide();
  $(".mob_menu ul.nav li").click(function () {
    $("ul", this).slideToggle("fast");
  });
});
