class Exam03 extends Phaser.Scene {
  constructor() {
    super({ key: "Exam03" });
    this.tileSpeed = 5;
    this.idx = 0;
    this.frame = 0;
    this.boxes = [];
    this.collisionCount = 0; // 충돌 카운트
  }

  preload() {
    this.load.image("background", "jjang9.jpeg");
    this.load.spritesheet("megaman", "megaman.png", {
      frameWidth: 384,
      frameHeight: 365,
    });
    this.load.image("box", "빌런.png");
  }

  create() {
    this.anims.create({
      key: "run",
      frames: this.anims.generateFrameNumbers("megaman", { start: 0, end: 9 }),
      frameRate: 10,
      repeat: -1,
    });
    this.anims.create({
      key: "jump",
      frames: this.anims.generateFrameNumbers("megaman", { frames: [4] }),
      frameRate: 10,
      repeat: -1,
    });

    // 배경화면 지정
    this.background = this.add
      .tileSprite(
        0,
        0,
        this.cameras.main.width,
        this.cameras.main.height,
        "background"
      )
      .setOrigin(0, 0);

    let floor = this.add.rectangle(
      0, // x
      this.cameras.main.height - 50, // y
      this.cameras.main.width * 5, // width
      5 // height
    );
    floor.setOrigin(0, 0);
    this.physics.add.existing(floor, true);

    // 플레이어 생성
    this.me = this.physics.add.sprite(100, 150, "megaman");
    this.me.setScale(50 / 384, 50 / 365);
    this.me.anims.play({ key: "run" });
    this.me.setData("onFloor", true);
    this.me.setGravity(0, 1000);

    this.physics.add.collider(this.me, floor, (me, floor) => {
      me.setData("onFloor", true);
      this.idx = 0; // 더블  점프 리셋
    });

    this.cursor = this.input.keyboard.createCursorKeys();

    // 박스와 바닥의 충돌 처리
    this.physics.add.collider(this.boxes, floor);

    // 플레이어와 박스의 충돌 처리
    this.physics.add.overlap(this.me, this.boxes, (me, box) => {
      this.collisionCount++;
      console.log(`충돌 횟수: ${this.collisionCount}`);
      box.destroy(); // 박스 삭제
    });
  }

  update() {
    this.frame++;
    this.background.tilePositionX += this.tileSpeed;

    // 장애물 생성
    if (this.frame % 120 === 0) {
      let boxWidth = Math.random() * 30 + 20; // 박스 너비 랜덤
      let boxHeight = Math.random() * 30 + 20; // 박스 높이 랜덤
      let boxX = 480; // x 좌표 랜덤

      let box = this.physics.add
        .sprite(boxX, this.cameras.main.height - 100, "box")
        .setDisplaySize(boxWidth, boxHeight)
        .setOrigin(0, 0);

      box.setVelocityX(-200); // 속도 랜덤
      this.boxes.push(box);
    }

    // 사용자 움직임
    if (Phaser.Input.Keyboard.JustDown(this.cursor.space)) {
      if (this.me.getData("onFloor") || this.idx < 2) {
        this.me.setVelocityY(-400);
        this.me.play("jump");
        this.idx++;
        console.log(this.idx);
        if (this.idx >= 2) {
          this.me.setData("onFloor", false);
        }
      }
    }

    if (this.me.getData("onFloor") && this.me.anims.currentAnim.key !== "run") {
      this.me.play("run");
    }
  }
}
