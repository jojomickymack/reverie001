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
        meta(id: 'viewport', name: 'viewport', content: 'width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no', charset: 'utf-8')
        title(game.title)
        link(href: '/images/favicon.png', rel: 'shortcut icon')
    }

    body {
        header { includeGroovy('header.gtpl') }

        div(class: 'container') {
            div (class:'row justify-content-center') {

                section(class: 'paper') {

                    div(class: 'head') {
                        div(class: 'spHeading') {
                            h2 game.title
                        }
                    }

                    iframe(id: 'jsgame', src: game.iframe_path, width: 480, height: 360, msallowfullscreen: 'true', allowfullscreen: 'true', frameborder: '0', scrolling: 'no', allowtransparency: 'true', webkitallowfullscreen: 'true', mozallowfullscreen: 'true') {}
                    br {}
                    input(id: 'myButton', class: 'button', type: 'button', onclick: "target='jsgame'; launchGame('$game.iframe_path');", value: 'Launch Fullscreen')

                    script(type: 'text/javascript', src: '/scripts/buttonScript.js') {}
                }
            }
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
