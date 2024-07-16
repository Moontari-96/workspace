class Exam01 extends Phaser.Scene {
  constructor() {
    // Scene에서 사용할 변수나 함수를 초기화 하는 곳
    super("Exam01");
  }

  preload() {
    // Scene에 사용될 이미지, 음악, 영상등의 자원을 로딩하는 곳 ( RAM에 적재 작업 )
  }

  create() {
    // RAM에 적재된 자원을 바탕으로 인스턴스를 생성하는 곳
    // let player = this.physics.add.sprite(x, y, w, h,이미지);
    this.cameras.main.setBackgroundColor("#fff");
    this.player = this.physics.add.sprite(100, 100, 50, 50); // 플레이어 주인공 캐릭터
    this.player.setCollideWorldBounds(true);

    this.box = this.physics.add.sprite(250, 250, 50, 50);
    this.box.setCollideWorldBounds(true);
    this.box.setBounce(1); // 탄성 (1)일 경우 완전 탄성
    this.box.setDrag(10); // 공기저항
    this.box.setMass(5); // sprite의 질량값
    //this.box.setImmovable(true); // sprite 움직임 고정

    this.physics.add.collider(this.player, this.box, function (player, box) {
      console.log("충돌감지");
    });

    this.cursor = this.input.keyboard.createCursorKeys(); // 키보드 조작을 처리하기 위한 인스턴스
  }

  update() {
    // 무한루프를 반복하며 게임 내용을 채우는 곳 ( 기본 60 FPS )
    if (this.cursor.left.isDown) {
      //console.log("왼쪽 방향키 감지");
      //this.player.x -= 2;
      this.player.setVelocityX(-200);
    } else if (this.cursor.right.isDown) {
      this.player.setVelocityX(200);
    } else {
      this.player.setVelocityX(0);
    }

    if (this.cursor.up.isDown) {
      this.player.setVelocityY(-200);
    } else if (this.cursor.down.isDown) {
      this.player.setVelocityY(200);
    } else {
      this.player.setVelocityY(0);
    }
  }
}
