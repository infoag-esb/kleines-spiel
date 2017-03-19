Raumschiff myShip = new Raumschiff(100, 100, 100);

void setup() {
  size(800, 400);
  
  myShip.waffeHinzufuegen(300, 100, 50);
  myShip.waffeHinzufuegen(300, 200 - 25, 50);
}

void draw() {
  background(255);
  
  myShip.show();
  myShip.shotAll();
}