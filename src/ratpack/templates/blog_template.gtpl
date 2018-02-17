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
        meta(id: 'viewport', name: 'viewport', content: 'width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no', charset: 'utf-8')
        title(title)
        link(href: '/images/favicon.png', rel: 'shortcut icon')
        link(rel: 'import', href: "/bower_components/marked-element/marked-element.html")
    }

    body {
        header { includeGroovy('header.gtpl') }

        div(class: 'container') {
            div (class:'row justify-content-center') {

                section(class: 'paper') {

                    div(class: 'head') {
                        div(class: 'spHeading') {
                            h2 title
                        }
                    }

                    p entry.long_title
                    img(src: entry.title_img_path)

                    div(slot: 'markdown-html') {}
                    'marked-element'(markdown: new File("src/ratpack/public/$entry.markdown_path").getText()) {}
                }
            }
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
