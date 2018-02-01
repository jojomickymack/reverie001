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
            p 'Click on the link below to check out a cool game.'
            a(class: 'button', href: 'games/tutorial', 'click here')
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
