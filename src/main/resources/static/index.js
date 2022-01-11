function switchImageByID(tile, ID) {
    switch (ID) {
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
}

let tiles;
let w;
let h;
let map;
let prevEntities = null;
async function mapCreation() {
    let response = await fetch('http://localhost:8080/LifeSimulation');
    let json = await response.json();

    w = json.map.width;
    h = json.map.height;
    tiles = json.map.tiles;

    map = document.getElementById("gameField");

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

function switchEntityByID(creation, entity) {
    let ID = entity.entityType;
    switch (ID) {
        case "com.example.lifesimulation.GameObjects.Animals.Turtle":
            creation.setAttribute('src', 'img/animals/turtle.png');
            break;
        case "com.example.lifesimulation.GameObjects.Animals.Ship":
            creation.setAttribute('src', 'img/animals/ship.png');
            break;
    }
}

async function updateEntity() {
    let response = await fetch('http://localhost:8080/LifeSimulation');
    let entities = await response.json();
    let node;
    if(prevEntities != null) {
        for (let oldEntity of prevEntities) {
            var tileType = entities.map.tiles[oldEntity.y][oldEntity.x].tileType[0];
            var oldNode = map.childNodes[oldEntity.y].childNodes[oldEntity.x]
            switchImageByID(oldNode, tileType);
        }
    }
    for (let unit of entities.entities) {
        try {
            node = map.childNodes[unit.y].childNodes[unit.x];
        } catch (e) {
            console.log(e.message);
        }
        if (node == undefined) continue;
        switchEntityByID(node, unit);
    }
    prevEntities = entities.entities;
}

mapCreation();
setInterval(updateEntity, 1000);
