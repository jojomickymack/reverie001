var song;

var changing = false;
var changeSpeed = 5;

var light, dark, current, target;
var lightString = 'rgb(168, 240, 122)'
var darkString = 'rgb(68, 53, 91)'

function preload() {
    song = loadSound('sound.ogg');
}

function setup() {
    light = color(lightString);
    dark = color(darkString);
    current = light;
    target = light;

    var myCanvas = createCanvas(windowWidth, windowHeight);
    myCanvas.parent('myCanvas');
    song.loop(); // song is ready to play during setup() because it was loaded during preload
    background(current);
}

function draw() {

    if (changing) {
        if (red(current) < red(target)) {
            current.setRed(red(current) + changeSpeed);
        } else if (red(current) > red(target)) {
            current.setRed(red(current) - changeSpeed);
        }
        if (green(current) < green(target)) {
            current.setGreen(green(current) + changeSpeed);
        } else if (green(current) > green(target)) {
            current.setGreen(green(current) - changeSpeed);
        }
        if (blue(current) < blue(target)) {
            current.setBlue(blue(current) + changeSpeed);
        } else if (blue(current) > blue(target)) {
            current.setBlue(blue(current) - changeSpeed);
        }
        if (red(current) > red(target) - changeSpeed && (red(current) < red(target) + changeSpeed)
        && (green(current) > green(target) - changeSpeed) && (green(current) < green(target) + changeSpeed)
        && (blue(current) > blue(target) - changeSpeed) && (blue(current) < blue(target) + changeSpeed)) {
            changing = false;
        }
    }

    background(current)
}

function mousePressed() {
    changing = true;
    if (red(target) == red(color(lightString))) {
        target = color(darkString);
    } else if (red(target) == red(color(darkString))) {
        target = color(lightString);
    }

    if (song.isPlaying()) {
        song.pause();
    } else {
        song.play();
    }
}

function windowResized() {
    resizeCanvas(windowWidth, windowHeight);
}
