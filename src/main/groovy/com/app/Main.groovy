package com.app

import ratpack.groovy.Groovy
import ratpack.guice.Guice
import ratpack.server.RatpackServer
import ratpack.server.BaseDir

import ratpack.groovy.template.MarkupTemplateModule
import static ratpack.groovy.Groovy.groovyMarkupTemplate

import groovy.json.JsonSlurper
import java.net.URL

class Main {

    public static void main(String[] args) {

        def contents = new JsonSlurper().parseText(new URL('http://localhost:9292/contents').getText())

        println contents[1].title

        RatpackServer.start{ s -> s

            .serverConfig{ b ->
                b.baseDir(BaseDir.find(".ratpack.base.dir"))
            }

            .registry(Guice.registry{ b ->
                b.module(MarkupTemplateModule.class)
            })

            .handlers(Groovy.chain{
                files { dir 'public' }

                get {
                    render groovyMarkupTemplate('index.gtpl')
                }

                get('interesting') {
                    render groovyMarkupTemplate('interesting.gtpl')
                }

                for (content in contents) {
                    get(content.title) {
                        render groovyMarkupTemplate('blog_entry.gtpl', title: content.title)
                    }
                }
            })
        }
    }
}
