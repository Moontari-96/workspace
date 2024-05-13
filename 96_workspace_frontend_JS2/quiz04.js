let shop = {
  menu: {
    bread: ["Muffin", "Tart", "Morning Bread"],
    beverage: ["Americano", "Cafe Latte", "Orange Juice"],
  },
  employee: [
    function () {
      return { name: "jack", age: 25, contact: "01012344321" };
    },
    {
      name: "susan",
      age: 22,
      contact: "01043211234",
    },
  ],
};

// Quiz01. 가게 메뉴 중 빵 종류에서 0 번 항목 출력해보기
console.log(shop.menu.bread[0]);
// Quiz02. 가게 직원 중 Susan 직원의 나이를 출력해보기
console.log(shop.employee[1].age);
// Quiz01. 가게 직원 중 jack 직원의 연락처 출력해보기
console.log(shop.employee[0]().contact);
