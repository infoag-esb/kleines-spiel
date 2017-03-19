class Schild {
  int x, y, size;
  
  Schild(int newx, int newy, int newsize) {
    x = newx; 
    y = newy; 
    size = newsize;
  }
  
  void show() {
    rect(x, y, size, size); 
  }
}