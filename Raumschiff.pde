class Raumschiff {
  ArrayList<Waffe> alleWaffen = new ArrayList<Waffe>();
  ArrayList<Schild> alleSchilder = new ArrayList<Schild>();
  int x, y, size;

  Raumschiff(int newx, int newy, int newsize) {
    x = newx; 
    y = newy; 
    size = newsize;
  }
  
  void setCoordinates(int newx, int newy) {
    x = newx; 
    y = newy;
  }
  
  void show() {
    fill(51);
    rect(x, y, size + size, size); 
    
    for (Waffe jedeWaffe : alleWaffen)
      jedeWaffe.show();
    
    for (Schild jedesSchild : alleSchilder)
      jedesSchild.show();
  }
  
  void waffeHinzufuegen(int newx, int newy, int newsize) {
    alleWaffen.add(new Waffe(newx, newy, newsize));
  }
  
  void schildHinzufuegen(int newx, int newy) {
    alleSchilder.add(new Schild(newx, newy, 100));
  }
  
  void shotAll() {
    for (Waffe jedeWaffe : alleWaffen)
      jedeWaffe.shoot(width);      
  }
}