yieldUnescaped '<!DOCTYPE html>'

def blue = '#9381ff'
def royalblue = '#6536e8'
def darkOrange = '#ee5622'
def purple = '#c521bc'
def green = '#5ae177'
def honey = '#d6b906'
def red = '#ef233c'
def ruby = '#c51f5d'
def aqua = '#247ba0'
def orange = '#ffb200'

def colors = [blue, royalblue, darkOrange, purple, green, honey, red, ruby, aqua, orange]

def getRandom(myArray) {
    def myIndex = Math.floor(Math.random() * myArray.size()).toInteger()
    myArray[myIndex]
}

def getRandomMargin() {
    Math.floor(Math.random() * 40)
}

html {

    head {
        meta(id: 'viewport', name: 'viewport', content: 'width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no', charset: 'utf-8')
        meta(description: 'join the reverie! it\'s a bunch of games, animations, blogs and stuff like that')
        title('Reverie + Fun')
        link(href: '/images/favicon.png', rel: 'shortcut icon')

        link(rel: 'import', href: "/bower_components/wired-button/wired-button.html")
    }

    body {
        header { includeGroovy('header.gtpl') }

        div(class: 'container') {
            div (class:'row justify-content-center') {
                section(class: 'paper') {

                    div(class: 'head') {
                        div(class: 'spHeading') {
                            q 'Know not to revere human things too much.'
                            p 'Aeschylus'
                        }
                    }

                    ArrayList indexes = 0..<contents.size()
                    Collections.shuffle(indexes)

                    ul {
                        for (i in indexes) {
                            li {
                                a(href: "groovy/${contents[i].url}", style: "margin-left: ${getRandomMargin()}%;"){'wired-button'(text: contents[i].title, elevation: Math.floor(Math.random() * 5), style: "color: ${getRandom(colors)}; padding: ${Math.floor(Math.random() * 20) + 8}px;") {}}
                            }
                        }
                    }
                }
            }
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
