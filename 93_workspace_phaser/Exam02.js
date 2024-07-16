class Exam02 extends Phaser.Scene {
  constructor() {
    super({ key: "Exam02" });
    this.boxes = [];
    this.frame = 0;
    this.timer = 0;
    this.tileSpeed = 2;
  }

  init() {
    // scene이 start 될 때마다 실행되는 함수
    // scene이 시작될 때 ( 다시 시작 될 때 ), 초기화 시켜주는 작업
    this.timer = 0;
  }

  preload() {
    this.load.image("player", "anghudukun.png");
    this.load.image("box", "ddong.png");
    this.load.image("background", "window.png");
  }

  create() {
    //this.cameras.main.setBackgroundColor("none"); // 백그라운드 색상 값 지정
    this.background = this.add
      .tileSprite(
        0,
        0,
        this.cameras.main.width,
        this.cameras.main.height,
        "background"
      )
      .setOrigin(0, 0);

    let bottomBoundary = this.add.rectangle(
      0, // x
      this.cameras.main.height + 30, // Y
      this.cameras.main.width, // W
      5, // H
      0x000000 // color
    ); // 시각적으로 사용
    bottomBoundary.setOrigin(0, 0);
    this.physics.add.existing(bottomBoundary, true);

    let topBoundary = this.add.rectangle(
      0, // x
      -30, // Y
      this.cameras.main.width, // W
      5, // H
      0x000000 // color
    ); // 시각적으로 사용
    topBoundary.setOrigin(0, 0);
    this.physics.add.existing(topBoundary, true);

    let leftBoundary = this.add.rectangle(
      -30, // x
      0, // Y
      5, // W
      this.cameras.main.height, // H
      0x000000 // color
    ); // 시각적으로 사용
    leftBoundary.setOrigin(0, 0);
    this.physics.add.existing(leftBoundary, true);

    let rightBoundary = this.add.rectangle(
      this.cameras.main.width + 30, // x
      0, // Y
      5, // W
      this.cameras.main.height, // H
      0x000000 // color
    ); // 시각적으로 사용
    rightBoundary.setOrigin(0, 0);
    this.physics.add.existing(rightBoundary, true);

    // 박스와 경계의 충돌 처리
    this.physics.add.collider(this.boxes, bottomBoundary, (box, boundary) => {
      box.destroy();
      this.boxes.splice(this.boxes.indexOf(box), 1);
    });

    this.physics.add.collider(this.boxes, topBoundary, (box, boundary) => {
      box.destroy();
      this.boxes.splice(this.boxes.indexOf(box), 1);
    });

    // 플레이어 생성 및 크기 조절
    this.player = this.physics.add.sprite(250, 400, "player");
    this.player.setCollideWorldBounds(true);
    let playerScaleFactor = 50 / 236; // 플레이어 이미지의 원본 높이 사용
    this.player.setScale(playerScaleFactor); // 원하는 사이즈 / 원본이미지사이즈 = scaleFactor
    this.player.setSize(50 / playerScaleFactor, 50 / playerScaleFactor);

    // 플레이어와 박스의 충돌 처리
    this.physics.add.collider(this.player, this.boxes, (player, box) => {
      this.scene.start("GameOver");
    });

    // 타이머 텍스트 추가
    this.timerText = this.add.text(this.cameras.main.width - 40, 5, "0", {
      fontSize: "32px",
      fill: "#ff0000",
    });

    // 키보드 입력 설정
    this.cursor = this.input.keyboard.createCursorKeys();
  }

  update() {
    this.frame++;
    let boxScaleFactor = 30 / 105; // 박스 이미지의 원본 높이 사용
    this.background.tilePositionY -= this.tileSpeed;
    if (this.frame % 60 === 0) {
      this.timer++;
      this.timerText.setText(this.timer);
      document.getElementById("timer").innerHTML = this.timer;

      // 상단에서 떨어지는 박스 생성 및 크기 조절
      let boxb = this.physics.add.sprite(
        Math.random() * (480 - 20 + 1) + 20,
        20,
        "box"
      );
      boxb.setScale(boxScaleFactor); // 원하는 사이즈 / 원본이미지사이즈 = scaleFactor
      boxb.setSize(30 / boxScaleFactor, 30 / boxScaleFactor);
      boxb.setVelocityY(Math.random() * (200 - 100 + 1) + 100);
      this.boxes.push(boxb);

      if (this.timer > 10) {
        // 하단에서 올라오는 박스 생성 및 크기 조절
        this.tileSpeed = 5;
        let boxt = this.physics.add.sprite(
          Math.random() * (480 - 20 + 1) + 20,
          480,
          "box"
        );
        boxt.setScale(boxScaleFactor); // 원하는 사이즈 / 원본이미지사이즈 = scaleFactor
        boxt.setSize(30 / boxScaleFactor, 30 / boxScaleFactor);
        boxt.setVelocityY(-(Math.random() * (200 - 100 + 1) + 100));
        this.boxes.push(boxt);
      }
      if (this.timer > 20) {
        // 좌측에서 우측으로 이동하는 박스 생성 및 크기 조절
        this.tileSpeed = 10;
        let boxl = this.physics.add.sprite(
          20,
          Math.random() * (480 - 20 + 1) + 20,
          "box"
        );
        boxl.setScale(boxScaleFactor); // 원하는 사이즈 / 원본이미지사이즈 = scaleFactor
        boxl.setSize(30 / boxScaleFactor, 30 / boxScaleFactor);
        boxl.setVelocityX(Math.random() * (200 - 100 + 1) + 100);
        this.boxes.push(boxl);
      }

      if (this.timer > 20) {
        // 우측에서 좌측으로 이동하는 박스 생성 및 크기 조절
        let boxr = this.physics.add.sprite(
          480,
          Math.random() * (480 - 20 + 1) + 20,
          "box"
        );
        boxr.setScale(boxScaleFactor); // 원하는 사이즈 / 원본이미지사이즈 = scaleFactor
        boxr.setSize(30 / boxScaleFactor, 30 / boxScaleFactor);
        boxr.setVelocityX(-(Math.random() * (200 - 100 + 1) + 100));
        this.boxes.push(boxr);
      }
    }

    // 플레이어 이동 처리
    if (this.cursor.left.isDown) {
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
