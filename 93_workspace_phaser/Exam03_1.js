class Exam03 extends Phaser.Scene {
  constructor() {
    super({ key: "Exam03" });
    this.tileSpeed = 5;
    this.idx = 0;
    this.frame = 0;
    this.boxes = [];
  }

  preload() {
    this.load.image("background", "jjang9.jpeg");
    this.load.spritesheet("megaman", "megaman.png", {
      frameWidth: 384,
      frameHeight: 365,
    });
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
      this.cameras.main.height - 50, // Y
      this.cameras.main.width * 5, // W
      5 // H
      // color
    ); // 시각적으로 사용
    floor.setOrigin(0, 0);
    this.physics.add.existing(floor, true);
    // 플레이어 생성
    this.me = this.physics.add.sprite(100, 150, "megaman");
    this.me.setScale(100 / 384, 100 / 365);
    this.me.anims.play({
      key: "run",
    });
    this.me.setData("onFloor", "true");
    this.physics.add.collider(this.me, floor, (me, floor) => {
      me.setData("onFloor", "true");
    });

    this.cursor = this.input.keyboard.createCursorKeys();

    this.physics.add.collider(this.boxes, floor, (box, floor) => {});
  }

  update() {
    this.frame++;
    this.background.tilePositionX += this.tileSpeed;
    // 장애물 컨트롤러
    if (this.frame % 120 === 0) {
      // 하단에서 올라오는 박스 생성 및 크기 조절
      let box = this.physics.add.sprite(
        Math.random() * (480 - 20 + 1) + 20 + 150,
        this.cameras.main.height - 100,
        50,
        50
      );
      box.setVelocityX(-(Math.random() * (200 - 100 + 1) + 100));
      this.boxes.push(box);
    }

    // 사용자 움직임
    if (Phaser.Input.Keyboard.JustDown(this.cursor.space)) {
      if (this.me.getData("onFloor")) {
        this.me.setVelocityY(-500);
        this.me.play("jump");
        this.idx++;
        console.log(this.idx);
        if (this.idx > 1) {
          this.me.setData("onFloor", false);
          this.idx = 0;
          console.log(this.idx);
        }
      }
    }
    if (this.me.getData("onFloor") && this.me.anims.currentAnim.key != "run") {
      this.me.play("run");
    }
  }
}
