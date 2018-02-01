String p5Dir = '/scripts/p5js/'
String sketchDir = '/scripts/p5_sketches/fluid_resistance001/'

yieldUnescaped '<!DOCTYPE html>'

html {

    head {
        title('Reverie + Fun')
        link(href: '/images/favicon.png', rel: 'shortcut icon')
    }

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 title
            p 'you should see something interesting below'
            div(id: 'myContainer')
            script('', type:'text/javascript', src: "${p5Dir}p5.min.js")
            script('', type:'text/javascript', src: "${p5Dir}p5.dom.min.js")
            script('', type:'text/javascript', src: "${p5Dir}p5.sound.min.js")
            script('', type:'text/javascript', src: "${sketchDir}mover.js")
            script('', type:'text/javascript', src: "${sketchDir}liquid.js")
            script('', type:'text/javascript', src: "${sketchDir}sketch.js")
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
