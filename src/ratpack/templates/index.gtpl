yieldUnescaped '<!DOCTYPE html>'

html {

    head {
        title('Reverie + Fun')
        link(href: '/images/favicon.png', rel: 'shortcut icon')
    }

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 'cliq dem links'
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
