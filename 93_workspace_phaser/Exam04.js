class Exam04 extends Phaser.Scene {
  constructor() {
    super({ key: "Exam04" });
  }

  preload() {
    this.load.image("rpg_bg", "rpg.webp");
    this.load.spritesheet("bone", "해골.png", {
      frameWidth: 347,
      frameHeight: 347,
    });
  }

  create() {
    this.cameras.main.setBackgroundColor("#ffffff");

    let background = this.add.tileSprite(0, 0, 650, 601, "rpg_bg");
    background.setOrigin(0, 0);

    this.me = this.physics.add.sprite(200, 200, "bone");
    this.physics.world.setBounds(0, 0, background.width, background.height);
    this.me.setCollideWorldBounds(true); // <-- config에 설정한 넓이 높이만큼의 경계를 그어버림.

    this.cameras.main.setBounds(0, 0, background.width, background.height);
    this.cameras.main.startFollow(this.me);

    this.cursor = this.input.keyboard.createCursorKeys();
  }

  update() {
    if (this.cursor.left.isDown) {
      //console.log("왼쪽 방향키 감지");
      //this.player.x -= 2;
      this.me.setVelocityX(-200);
    } else if (this.cursor.right.isDown) {
      this.me.setVelocityX(200);
    } else {
      this.me.setVelocityX(0);
    }

    if (this.cursor.up.isDown) {
      this.me.setVelocityY(-200);
    } else if (this.cursor.down.isDown) {
      this.me.setVelocityY(200);
    } else {
      this.me.setVelocityY(0);
    }
  }
}
