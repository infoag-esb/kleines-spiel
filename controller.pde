Raumschiff myShip = new Raumschiff(100, 100, 100);
LevelDesign1 lv1 = new LevelDesign1();

enum states {
  Menue, 
  GalaxieKarte, 
  Schlachtfeld,
  Optionen
}

states currentState = states.GalaxieKarte;

void setup() {
  size(800, 800);
  
  lv1.randomizeGeneration();
  
  myShip.waffeHinzufuegen(300, 100, 50);
  myShip.waffeHinzufuegen(300, 200 - 25, 50);
}

void draw() {
  background(255);
  
  switch(currentState) {
    case Schlachtfeld: {
      myShip.show();
      myShip.shotAll();
      break;
    }
    
    case GalaxieKarte: {
      lv1.showAll();
      break;
    }
  }
}

void mousePressed() {
  switch(currentState) {
    case GalaxieKarte: {
      lv1.checkAll();
      break; 
    }
  }
}
