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
    includeGroovy('head.gtpl')

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 title
            p 'gonna put some stuff here'
            p entry.long_title
            p entry.title_img_path
            p entry.content
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
