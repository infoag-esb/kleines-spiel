class LevelDesign1 {
  Button btns[][] = new Button[200][200];
  int buttonAmount = 100;
  int btnWidth = buttonAmount / 2, btnHeight = buttonAmount / 2;

  void showAll() {
    for (int i = 0; i < btns.length; i++)
      for (int j = 0; j < btns.length; j++) 
        if (btns[i][j] != null)
          btns[i][j].show();
  }

  void randomizeGeneration() {
    randomSeed(second());

    for (int row = 0; row < btns.length; row++)
      for (int col = 0; col < btns.length; col++)
        if ((int) random(0, 10) == 1)
          btns[row][col] = new Button(row * btnWidth, col * btnHeight, btnWidth, btnHeight);
  }

  void checkAll() {
    for (int i = 0; i < btns.length; i++)
      for (int j = 0; j < btns.length; j++) 
        if (btns[i][j] != null)
          btns[i][j].check();
  }
}