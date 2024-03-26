function login() {
  var username = document.getElementById('username').value;
  var password = document.getElementById('password').value;
  let userName = document.getElementById('username');
  let passWord = document.getElementById('password');

  if (username === 'mky' && password === '123456') {
    alert('로그인되었습니다.');
    userName.value = '';
    passWord.value = '';
  } else {
    alert('로그인 정보가 없습니다. ID, PW를 확인하세요');
    userName.value = '';
    passWord.value = '';
  }
}
