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
            p 'Click on the link below to see something interesting.'
            a href: 'projects/reverse_fluid', 'click here'
        }

        section {
            h2 'here are the projects'
            ul {
                for (project in projects) {
                    li {
                        a(href: "projects/$project", project)
                    }
                }
            }
        }

        section {
            h2 'here are the links'
            ul {
                for (content in contents) {
                    li {
                        a(href: content.url, content.title)
                    }
                }
            }
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
