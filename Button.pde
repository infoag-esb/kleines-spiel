class Button {
  float x, y, w, h;
  
  Button(int newx, int newy, int neww, int newh) {
    x = newx; 
    y = newy;
    w = neww;
    h = newh;
  }
  
  void show() {
    strokeWeight(1);
    rect(x, y, w, h);
  }
  
  void check() {
    if(mouseX>x && mouseX <x+w && mouseY>y && mouseY <y+h)
      println("The mouse is pressed");
  }
}