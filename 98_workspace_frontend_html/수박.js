function solution(n) {
  var watermelon = ['수', '박'];

  var answer = '';
  for (let i = 0; i < n; i++) {
    if (i % 2 == 1) {
      answer += watermelon[1];
    } else {
      answer += watermelon[0];
    }
  }
  return answer;
}

console.log(solution(5));
