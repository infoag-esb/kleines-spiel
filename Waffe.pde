class Waffe {
  int x, y, px, py, shotSize, size;
 
  Waffe(int newx, int newy, int newsize) {
    x = newx; 
    y = newy;
    size = newsize;
    
    px = x + size;
    py = y + size / 4; 
    shotSize = size / 4;
  }

  void show() {
    fill(180);
    rect(x, y, size, size / 2); 
  }
  
  void shoot(int limit) {
    if (!(px > limit)) {
      ellipse(px, py, shotSize, shotSize); 
      px += 10; 
    }
    else
      px = x + size;
  }
}