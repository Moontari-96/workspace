let person = {
  name: "Jack",
  contact: "01099998888",
  hello: function () {
    alert("Hello Everyone. I'm " + this.name);
  },
  hobby: ["Java", "Book", "Guitar"],
  score: {
    kor: 100,
    eng: 90,
    math: 80,
  },
  favoriteFruits: function () {
    return ["Apple", "Orange", "Mango"];
  },
  abilities: function () {
    return {
      java: function () {
        return 100;
      },
      css: function () {
        return 90;
      },
      js: function () {
        return 80;
      },
    };
  },
  helloTo: function (friend) {
    console.log("Hello" + friend.name);
  },
  Dron: function (brand, price) {
    this.brand = brand;
    this.price = price;
  },
};
// Quiz01. Jack의 영어점수를 출력해주세요.
console.log(person.score.eng);
// Quiz02. Jack이 좋아하는 과일 중 세번째 항목을 출력해주세요.
console.log(person.favoriteFruits()[2]);
// Quiz02. Jack의 css 점수를 출력해주세요.
console.log(person.abilities().css());

person.helloTo({ name: "Tom" });
let dron = new person.Dron("Samsung", 100000);
console.log(dron.brand, dron.price);
