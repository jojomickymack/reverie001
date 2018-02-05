meta(charset:'utf-8')
meta(name: 'viewport', content: 'width=device-width, initial-scale=1')

// jquery

script('', type: 'text/javascript', src: '/bower_components/jquery/dist/jquery.min.js')

// bootstrap

link(href: '/bower_components/bootstrap/dist/css/bootstrap.min.css', rel: 'stylesheet', type: 'text/css')
script('', type: 'text/javascript', src: '/bower_components/bootstrap/dist/js/bootstrap.min.js')

// bootstrap responsive toolkit

script('', type: 'text/javascript', src: '/bower_components/responsive-bootstrap-toolkit/dist/bootstrap-toolkit.min.js')

// fonts

link(href: 'https://fonts.googleapis.com/css?family=Dancing+Script', rel: 'stylesheet')
link(href: 'https://fonts.googleapis.com/css?family=Sedgwick+Ave+Display', rel: 'stylesheet')

// custom js

script('', type: 'text/javascript', src: '/scripts/main.js')

// custom css

link(href: '/styles/main.css', rel: 'stylesheet', type: 'text/css')

a(href: '/'){ h1 'Reverie + Fun' }
