yieldUnescaped '<!DOCTYPE html>'

html {
    head {
        meta(charset:'utf-8')
        title('Launcher Page')
        link(href: '/styles/launcher_style.css', rel: 'stylesheet', type: 'text/css')
        link(href: '/images/favicon.png', rel: 'shortcut icon')
    }

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 'click the button to launch the game'
            iframe(id: 'jsgame', msallowfullscreen: 'true', allowfullscreen: 'true', frameborder: '0', scrolling: 'no', allowtransparency: 'true', webkitallowfullscreen: 'true', mozallowfullscreen: 'true') {}
            br {}
            input(id: 'myButton', type: 'button', onclick: "target='jsgame'; thatFunction();", value: 'Cool Game')

            script(type: 'text/javascript', src: '/scripts/buttonScript.js') {}
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
