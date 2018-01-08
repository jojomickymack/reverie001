yieldUnescaped '<!DOCTYPE html>'

html {
    includeGroovy('head.gpl')

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 title
            p 'Click on the link below to see something interesting.'
            a href: '/interesting', 'click here'
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
