import java.awt.Color

yieldUnescaped '<!DOCTYPE html>'

def blue = '#9381ff'
def purple = '#c521bc'
def red = '#ef233c'
def aqua = '#247ba0'
def orange = '#ffb200'

def colors = [blue, purple, red, aqua, orange]

def getRandom(myArray) {
    def myIndex = ((Math.random() * myArray.size()).trunc()).toInteger()
    myArray[myIndex]
}

def getRandomMargin() {
    (Math.random() * 80).trunc(2).toInteger()
}

html {

    head {
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
                            h2 'cliq dem links'
                        }
                    }

                    ul {
                        for (content in contents) {
                            li {
                                a(href: content.url, style: "margin-left: ${getRandomMargin()}%;"){'wired-button'(text: content.title, style: "color: ${getRandom(colors)};") {}}
                            }
                        }
                    }
                }
            }
        }

        footer { includeGroovy('footer.gtpl') }
    }
}
