import groovyx.net.http.HTTPBuilder

def http = new HTTPBuilder('http://localhost:9292/contents')
def postBody = [title: title]
def sketch

http.post(body: postBody) { resp, json ->
    println "POST Success: ${resp.statusLine}"
    sketch = json
}

def scriptList = Eval.me(sketch.script_paths)
String p5Dir = '/scripts/p5js/'

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
            br {}
            div(id: 'myCanvas')
            script('', type:'text/javascript', src: "${p5Dir}p5.min.js")
            script('', type:'text/javascript', src: "${p5Dir}p5.dom.min.js")
            script('', type:'text/javascript', src: "${p5Dir}p5.sound.min.js")

            for (path in scriptList) {
                script('', type:'text/javascript', src: path)
            }
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
