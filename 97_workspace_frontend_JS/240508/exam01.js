function plus(num1, num2) {
  return num1 + num2;
}

function minus(num1, num2) {
  return num1 - num2;
}

function temp(func, num1, num2) {
  return func(num1, num2);
}
let result = temp(minus, 10, 5);
console.log(result);
