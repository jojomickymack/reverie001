import groovyx.net.http.HTTPBuilder

def http = new HTTPBuilder('http://localhost:9292/contents')
def postBody = [title: title]
def entry

http.post(body: postBody) { resp, json ->
    println "POST Success: ${resp.statusLine}"
    entry = json
}

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
            p 'gonna put some stuff here'
            p entry.long_title
            img(src: "/images/blog/$entry.title_img_path")
            p entry.content
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
