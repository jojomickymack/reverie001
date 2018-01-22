String p5Dir = '/scripts/p5js/'
String sketchDir = '/scripts/p5_sketches/fluid_resistance001/'

yieldUnescaped '<!DOCTYPE html>'

html {

    head {
        meta(charset:'utf-8')
        title('Reverie + Fun')

        meta(name: 'apple-mobile-web-app-title', content: 'Ratpack')
        meta(name: 'description', content: '')
        meta(name: 'viewport', content: 'width=device-width, initial-scale=1')

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
