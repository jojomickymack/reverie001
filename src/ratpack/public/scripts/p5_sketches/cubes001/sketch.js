function setup(){
    createCanvas(640, 360, WEBGL);
}

function draw(){
    background(250);
    normalMaterial();
    translate(40, 0, 0);

    push();
    rotateZ(frameCount * 0.01);
    rotateX(frameCount * 0.01);
    rotateY(frameCount * 0.01);
    box(170, 170, 170);
    pop();
}
