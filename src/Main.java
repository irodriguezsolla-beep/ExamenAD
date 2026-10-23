import Connections.Conector;
import Models.Videojuego;
import Services.ServicesVideojuego;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //Crear objetos
    Videojuego v1 = new Videojuego("The Legend of Zelda: Ocarina of Time","Nintendo 64",1998,"Clásico xogo de aventura e acción 3D en Hyrule.");
    Videojuego v2 = new Videojuego("Elden Ring","Multiplataforma",2022,"RPG de acción desafiante nun mundo de fantasía escura.");
    Videojuego v3 = new Videojuego("The Witcher 3: Wild Hunt","Multiplataforma",2015,"RPG de fantasía seguindo as aventuras do bruxo Geralt.");
    Videojuego v4 = new Videojuego("Bloodborne","PlayStation 4",2015,"RPG de acción e terror gótico ambientado na cidade de Yharnam.");
    Videojuego v5 = new Videojuego("Super Mario Odyssey","Nintendo Switch",2017,"Plataformas 3D con mecánicas de posesión de obxectos.");

    //añadir videojuego
    ServicesVideojuego.añadirVideojuego(v1);
    ServicesVideojuego.añadirVideojuego(v2);
    ServicesVideojuego.añadirVideojuego(v3);
    ServicesVideojuego.añadirVideojuego(v4);
    ServicesVideojuego.añadirVideojuego(v5);
}

