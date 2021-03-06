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

        RatpackServer.start{ s -> s

            .serverConfig{ b ->
                b.baseDir(BaseDir.find(".ratpack.base.dir"))
            }

            .registry(Guice.registry{ b ->
                b.module(MarkupTemplateModule.class)
            })

            .handlers(Groovy.chain{
                files { dir 'public' }

                get('groovy') {
                    render groovyMarkupTemplate('index.gtpl', contents: contents)
                }

                contents.eachWithIndex { content, i ->
                    get("groovy/${content.url}") {
                        render groovyMarkupTemplate("${content.content_type}_template.gtpl", title: contents[i].title)
                    }
                }
            })
        }
    }
}
