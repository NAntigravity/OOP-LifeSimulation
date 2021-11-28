function switchImageByID(tile, ID){
    switch (ID){
        case "com.example.lifesimulation.GameObjects.Tiles.Desert":
            tile.setAttribute('src', 'img/tiles/desert.jpg');
            break;
        case "com.example.lifesimulation.GameObjects.Tiles.Water":
            tile.setAttribute('src', 'img/tiles/water.png');
            break;
        case "com.example.lifesimulation.GameObjects.Tiles.Earth":
            tile.setAttribute('src', 'img/tiles/earth.jpg');
            break;
        case "com.example.lifesimulation.GameObjects.Tiles.Snow":
            tile.setAttribute('src', 'img/tiles/snow.jpg');
            break;
        case "com.example.lifesimulation.GameObjects.Tiles.Ice":
            tile.setAttribute('src', 'img/tiles/ice.png');
            break;
    }
    console.log(ID);
}

let tiles;
let w;
let h;

async function mapCreation() {
    let response = await fetch('http://localhost:8080/LifeSimulation');
    let json = await response.json();

    w = json.width;
    h = json.height;
    tiles = json.tiles;

    let map = document.getElementById("gameField");

    for (let i = 0; i < h; i++) {
        let col = document.createElement("div");
        col.classList.add("row");
        for (let j = 0; j < w; j++) {
            let img = document.createElement("img");
            switchImageByID(img, tiles[i][j].tileType[0]);

            img.setAttribute('X', j);
            img.setAttribute('Y', i);

            col.appendChild(img);
        }
        map.appendChild(col);
    }
}

function switchEntityByID(creation, entity){
    let ID = entity.entityType;
    switch (ID){
        case "com.example.lifesimulation.GameObjects.Animals.Diplodocus":
            creation.setAttribute('src', 'img/tiles/desert.jpg');
            break;
        case "com.example.lifesimulation.GameObjects.Animals.Human":
            creation.setAttribute('src', 'img/tiles/water.png');
            break;
        case "com.example.lifesimulation.GameObjects.Animals.Pterodactyl":
            creation.setAttribute('src', 'img/tiles/earth.jpg');
            break;
        case "com.example.lifesimulation.GameObjects.Animals.Stegosaurus":
            creation.setAttribute('src', 'img/animals/steg.png');
            break;
        case "com.example.lifesimulation.GameObjects.Animals.Triceratops":
            creation.setAttribute('src', 'img/tiles/ice.png');
            break;
        case "com.example.lifesimulation.GameObjects.Animals.Tyrannosaurus":
            creation.setAttribute('src', 'img/animals/tyrex.png');
            break;
        case "com.example.lifesimulation.GameObjects.Plants.IceHerb":
            creation.setAttribute('src', 'img/plants/tyrex.png');
            break;
        case "com.example.lifesimulation.GameObjects.Plants.Lotus":
            creation.setAttribute('src', 'img/plants/tyrex.png');
            break;
        case "com.example.lifesimulation.GameObjects.Plants.Mushroom":
            creation.setAttribute('src', 'img/plants/mushroom.png');
            break;
        case "com.example.lifesimulation.GameObjects.Plants.Nut":
            creation.setAttribute('src', 'img/plants/mushroom.png');
            break;
        case "com.example.lifesimulation.GameObjects.Plants.Seaweed":
            creation.setAttribute('src', 'img/plants/mushroom.png');
            break;
        case "com.example.lifesimulation.GameObjects.Plants.Thistle":
            creation.setAttribute('src', 'img/plants/mushroom.png');
            break;
        case "com.example.lifesimulation.GameObjects.Plants.СarnivorousPlant":
            creation.setAttribute('src', 'img/plants/mushroom.png');
            break;
    }
}

mapCreation();
