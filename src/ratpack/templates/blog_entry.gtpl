yieldUnescaped '<!DOCTYPE html>'

html {
    includeGroovy('head.gtpl')

    body {
        header { includeGroovy('header.gtpl') }

        section {
            h2 title
            p 'gonna put some stuff here'
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
