import groovyx.net.http.HTTPBuilder

def http = new HTTPBuilder('http://localhost:9292/contents')
def postBody = [title: title]
def game

http.post(body: postBody) { resp, json ->
    println "POST Success: ${resp.statusLine}"
    game = json
}

yieldUnescaped '<!DOCTYPE html>'

html {
    head {
        title(game.title)
        link(href: '/images/favicon.png', rel: 'shortcut icon')
    }

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 game.title
            iframe(id: 'jsgame', msallowfullscreen: 'true', allowfullscreen: 'true', frameborder: '0', scrolling: 'no', allowtransparency: 'true', webkitallowfullscreen: 'true', mozallowfullscreen: 'true') {}
            br {}
            input(id: 'myButton', class: 'button', type: 'button', onclick: "target='jsgame'; launchGame('$game.iframe_path');", value: 'Launch Game')

            script(type: 'text/javascript', src: '/scripts/buttonScript.js') {}
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
