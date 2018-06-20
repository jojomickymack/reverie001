# LibGTX and Kotlin

When surveying the platforms for game development, there's surprisingly few choices that target java. It's revealing that over the entire course of java's existence, it's never really been closely associated with games. There certainly have been attempts to use it, but its performance is usually its undoing and such attempts tend to be experimental as people quickly realize that the jre doesn't do what games need to very well. It's also hard to imagine distributing a game in the form of a jar file, and the 'applet' form which is pretty much extinct in modern times, paled in comparison to the flash platform, which ran circles around java in terms of performance in game-like scenarios. Flash was also designed to make handling media resources and events easy - something that requires a lot of infrastructure when done in java from scratch.

Android being the main mobile platform pretty much forced the world to reconsider java as platform for games - android uses a special optimized jre called 'art', or android runtime, and apps are distributed as apk files, which are the android equivalent of jar files.

As for game development platforms that target android, there's still surprisingly few choices. Unity, Gamemaker Studio and Cocos2d both all compile for android by leveraging the ndk, and Corona allows you to write Lua to target Android by executing it on an efficient lua vm. There are a lot of HTML5 platforms that leverage the ability to leverage an app consisting of a 'webview' (like a mini browser in your apk), and running javascript on it. 

All of these have very mysterious and closed off compilation processes. If you want to be in full control of that process, and you don't want any translation layer between your source code and 'art', you need to use a pure java platform. It's also appealing getting to use Android Studio as your IDE, which is a completely free, cutting edge development platform. There's still fewer game engines that target that platform.

## Introduction to LibGDX

Mario Zechner is the original creator of LibGDX, and he's written a fantastic book that has 3 editions now,  ['Beginning Android Games'](https://www.apress.com/us/book/9781484204733). It's basically a manual on how to create a game framework on android, and while it's lower level that what most people wanting to just play with game development would want, it's revealing in what LibGDX is doing.

LibGDX is the only platform that I've seen that targets desktop, android and IOS by leveraging 'robovm'. It also targets HTML5, which I haven't tried. The experience of running and debugging your game in a desktop window for the majority of development, then distributing and testing for these other targets is really nice. Each platform is represented by a different gradle module in your project which has a unique launcher class that runs the sourcecode your 'core' module, which is where you do all of your coding.

LibGDX has some very interesting 'plugins' for physics engines like box2d and bullet, it has native support for tiled maps, and it even does 3d rendering, which I haven't tried. Ultimately, for android, it's using [lwjgl](https://www.lwjgl.org/), which on its own is really hard to use, but with LibGDX it has a very clean interface, allowing for you to execute opengl directives and shaders on android's opengles.

## What Is Kotlin?

Kotlin is a young language that was created by Jetbrains, the makers of the IDE intellij, which Android Studio is a version of. It targets the jre, and was basically created as a way to offer new language features to platforms that are restricted to old versions of java. Android, as many people know, is built on java 1.6, and since google and oracle have been at war in court for many years, it's highly doubtful that will ever change. Jetbrains IDE depends on the jre as well, and knows what the problem areas are in terms of performance but also in developer experience. Their business is literally based on working with the compiler to deliver helpful error messages and interesting refactoring tips in the IDE.

Kotlin introduces a lot of language features people were using groovy and scala for, like functional programming concepts, clean lambda syntax, and a simplified collections interface, and adds the concept of non-nullable types and immutable variables. The idea is simple, unless you declare a variable as being mutable (changable) or nullable (having the ability to be set to null), it can't ever be changed or set to null. The mutable concept is designated by using 'val', which means the variable can't be changed, or 'var', which means it can, allows for functional paradigms emphasizing 'side-effect free' functions. Nullable types are designated by question marks. By striving for less side effects and non-nullability, your code becomes better as it becomes far less likely or even impossible that your application will crash from an npe, or 'null-pointer exception' which is incredibly common on the platform.

It's said that kotlin looks like what java would have if it could've kept evolving, which many cite that java can't do anymore because it needs to support so much legacy code. Since google and gradle have already embraced it and declared that it's an 'officially supported language', something that was never said about groovy, which has been around for a lot longer, says a lot about where the language is going. It's clearly a smart choice to learn about kotlin if you're invested in java/android.

## Summary

I'll continue writing on LibGDX and kotlin, since I'm using it a lot now. With kotlin's seamless support for java libraries like LibGTX, and the many useful capabilities of the library, there's a lot of interesting things to learn about and document.

A while back, I created a template project that includes desktop and android targets, and leverages a library called LibKTX, which is really just some helper classes that bind to LibGDX to give you some syntax features and write more idiomatic kotlin game code.

I've been using this template as a starting point for all of my experiments

[https://github.com/jojomickymack/ktxtemplate001](https://github.com/jojomickymack/ktxtemplate001)

I also ported over the libgdx example of a mario clone, which demonstrates how to use the tiled map loader and implement collision detection with a tile layer.

[https://github.com/jojomickymack/ktxkoalaworld](https://github.com/jojomickymack/ktxkoalaworld)

I plan on going more into depth on how to expand on these in future articles.
