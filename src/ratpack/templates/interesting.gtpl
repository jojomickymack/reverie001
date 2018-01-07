yieldUnescaped '<!DOCTYPE html>'

html {

    head {
        meta(charset:'utf-8')
        title('Reverie + Fun')

        meta(name: 'apple-mobile-web-app-title', content: 'Ratpack')
        meta(name: 'description', content: '')
        meta(name: 'viewport', content: 'width=device-width, initial-scale=1')

        link(href: '/images/favicon.png', rel: 'shortcut icon')
        script('', type:'text/javascript', src:'/scripts/myscript.js')
    }

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 title
            p 'you should see something interesting below'
            div(id: 'myContainer')
            includeGroovy('physics.gtpl')
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
