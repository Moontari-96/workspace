class GameOver extends Phaser.Scene {
  constructor() {
    super({ key: "GameOver" });
  }

  preload() {}

  create() {
    this.add
      .text(
        this.cameras.main.width / 2,
        this.cameras.main.height / 2 - 30,
        "Game Over",
        {
          fontSize: "40px",
          fill: "#FF0000",
          fontWeight: "bold",
          textalign: "center",
        }
      )
      .setOrigin(0.5);
    let restartButton = this.add
      .text(
        this.cameras.main.width / 2,
        this.cameras.main.height / 2 + 80,
        "Restart",
        {
          fontSize: "35px",
          fill: "#FF0000",
          fontWeight: "bold",
        }
      )
      .setOrigin(0.5)
      .setInteractive();

    restartButton.on("pointerdown", () => {
      this.scene.start("Exam02");
    });

    restartButton.on("pointerover", () => {
      restartButton.setBackgroundColor("#0000ff");
      this.game.canvas.style.cursor = "pointer";
    });
    restartButton.on("pointerout", () => {
      restartButton.setBackgroundColor("#000");
      this.game.canvas.style.cursor = "default";
    });
  }

  update() {}
}
