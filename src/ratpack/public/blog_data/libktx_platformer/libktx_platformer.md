# Elements Of A Platformer Using LibKTX And Tiled

For a long time now, I've understood that game development is something of a 'black art' - meaning that its methods and practices are not 'standardized' in any way, and you have to basically be taught from a specialized resource or just figure it out yourself. Game development programming patterns are so specialized that they typically don't translate to other realms of programming.

Questions like 'how should the code be organized', 'how to scroll the screen' and 'how to make things collide with each other' do not have simple answers - each of these topics could fill a library - and more frequently discussion boards.

## LibGDX - Why It's Appealing

LibGDX is a java game engine that targets desktop and mobile. It also targets HTML5, but that's not supported using kotlin so I haven't tried it.

The reason I'm writing on LibGDX isn't because it's the best or the easiest platform - I'd have to say that Construct has that honor - it's because LibGDX is fully featured and mature. 

It has a system for changing game states, displaying menus, manipulating cameras, configuring renderers, and loading tiled maps - each component intended to work with the others in a unified way. It also has a library called 'Ashley', which is an 'entity component system' library, which I won't describe here, but is provided as a way to 'componentize' a project - a programming pattern to help organize more complex projects and keep them from turning into a complicated mess.

I hope to provide a simple explanation here of what the different elements are in simple 2d platformer that can be extended further.

## Note

In addition to using LibGDX, which is java, I'm using kotlin and LibKTX in the code here.

LibKTX is a library that adds some kotlin-centric features to GDX - and since learning of its existence I wanted to put it to use. All of the KTX classes that are being extended are just wrappers around the LibGTX equivalent. 

## Why Not 3d?

The question has plagued game development studios for generations - does a game need to be 3d in order to be immersive and compelling? In the 90s, with the revolutionary statement that 'Doom' made, a lot of developers thought that 2d was suddenly a thing of the past, something that was forced on the world by limited hardware. The truth is, 3d brings so much complexity to a project, that you're going to end up spending an incredible amount of time modeling chairs, walls, and other decorations. Imagine how much easier it is to create a 2d image of something like that compared to doing it with 3d modeling software? That's why developers of first person games typically have a huge art department - because it's tedious and labor intensive.

There's a secondary point I wanted to make about game mechanics - you are severely limited in the kinds of mechanics you can preset to the player with a first person game - which kind of shifts the focus of the application from that which can be implemented with programming to that which is simply shown to the player.

2d games are an art form, and they're much more approachable to the casual player, and much simpler to design and ultimately play using common hardware.

Of the genres of games, I've always been compelled by platformers - being able to control a character on the screen is almost an expression since it can be so dynamic. It's also a great place to showcase artwork, sounds, music and moods.

## Programming Problems

I've put a lot of thought and time into solving 'programming problems', and one thing I've become conscious of is that there's good problems and bad ones - good ones are fun to solve - you feel like you've learned something and are ready for the next challenge. Bad programming problems are those that keep you stuck all day - wasting your time trying to repair something that's broken. I've often felt that sometimes, programmers get to chose their problems - hopefully you make choices that lead you to those exciting, fun to solve problems.

If you're experimenting with programming, try to avoid bad programming problems - a good way to encounter those is by choosing a platform that really isn't suited for what you're trying to do with it. LibGDX really makes a solid case that java makes a great platform for learning about 2d game development.

## First Steps - The Bare Minimum

Consider the desktop launcher for a libgdx program - you're importing your game's main class from the 'core' module, here a class called Application and instantiating it as a LwjglApplication. With this kotlin code, an object as opposed to a class produces a static entity, and the @JvmStatic annotation makes it so this function will have the required 'public static void main' signature that any java application has.

	object DesktopLauncher {  
		@JvmStatic  
		fun main(arg: Array<String>) {  
			LwjglApplication(Application(), LwjglApplicationConfiguration())  
		}
	}

If go to the 'core' module and look at that Application class, you'll see that it extends KtxGame. Extending that requires that you override the create method, and our screen - here it's a class called Game, is instantiated - the argument to the screen is an Application - this isn't required, but it enables you to do things like pause the whole application, set different screens, or terminate the game from within the Game screen. 

	class Application : KtxGame<Screen>() {
	    override fun create() {
	        val game = Game(this)
	        addScreen(game)
	        setScreen<Game>()
	    }
	}

When you call setScreen, it's starting your game - you might have some Menu that the game starts with and then switches to the game screen later - in that case, you'd swap out Game for Menu, and then in the Menu class you'd have something that switches the screen within it. This is for a button inside of a Menu class like that.

    onClick {
        application.setScreen<Game>()
    }

Now we can look at the screen itself - it's a class that extends KtxScreen which take the Application class we saw before as an argument. A Screen has to override a function called 'render', which gets called about 60 times a second.

## Renderers - How To Get Stuff On The Screen

The Game class will extend KtxScreen - in doing so it can override the render function. The render function is where you can draw to the screen - in order to do that, you need a Renderer, and there's different types you can use. There's ShapeRenderer, used for making lines, circles, squares and polygons, there's OrthogonalTiledMapRenderer, which is what can render a Tiled Map, and there's what's called SpriteBatch - specifically for drawing textures (images). 

Here we can create a ShapeRenderer as a member to our class, and in the render function draw a circle. We store the width and height of the window and divide them by 2 for the x and y coordinates of the shape so it's in the center. You should be able to run the application at this point.

	class Game(private val application: Application) : KtxScreen {
		val sr = ShapeRenderer()
		val width = Gdx.graphics.width.toFloat()  
		val height = Gdx.graphics.height.toFloat()
	    
	    init {}

	    override fun render(delta: Float) {
	        sr.color = Color.BLUE
	        sr.begin(ShapeType.Filled)
	        // circle(float x, float y, float radius, int segments)
	        sr.circle(width / 2, height / 2, 50f, 50)
	        sr.end()
	    }
	}

Now let's load a texture and display that using a SpriteBatch. Replace the png with your own - make sure that its in the android/assets directory. Note: if your application can't locate the assets folder, make sure you've declared the assets directory in your desktop module's build.gradle file with a line like this sourceSets.main.resources.srcDirs += ['../android/assets']

	class Game(private val application: Application) : KtxScreen {
	    val tex = Texture("adventurer.png")
	    val sb = SpriteBatch()
		val width = Gdx.graphics.width.toFloat()  
		val height = Gdx.graphics.height.toFloat()
	    
	    init {}

	    override fun render(delta: Float) {
	        sb.begin()
	        sb.draw(tex, width/2, height/2)
	        sb.end()
	    }
	}

Now you should see your image in the center of the screen.

You don't have to use a Sprite - but there are advantages to doing so. A sprite is really just a texture that has simplified ways to scale and move itself - here's the code using a sprite the texture is embedded in.

	class Game(private val application: Application) : KtxScreen {
	    val sprite = Sprite(Texture("adventurer.png"))
	    val sb = SpriteBatch()

	    init {
	        sprite.setPosition(width / 2, height / 2)
	        sprite.setSize(100f, 100f)
	    }

	    override fun render(delta: Float) {
	        sb.begin()
	        sprite.draw(sb)
	        sb.end()
	    }
	}

## The Stage Class

You do not have to use a stage in your game screen - but it's a really great tool that you need to know about. That being said, it's not required and you could make a game without one.

You can have a stage as a member of that class - and in the render function, you call the act() and render() functions, which update and draw whatever you've added to the stage.

In order to make this work for you, you'll want to put your Sprite into a class that extends Actor and inside of it, override the act and draw functions. You'll then be able to add your actor to the stage, and those functions get run automatically. This is a great way to add a bunch of things to the stage without bloating your render method - you can just add all of your actors and they all get rendered.

	class MyActor : Actor() {
	    val sprite = Sprite(Texture("adventurer.png"))

	    init {}

	    override fun act(delta: Float) {
	        this.sprite.setPosition(x++, y++)
	    }

	    override fun draw(batch: Batch, parentAlpha: Float) {
	        sprite.draw(batch)
	    }
	}

	class Game(private val application: Application) : KtxScreen {
	    val stage = Stage()
	    val myActor = MyActor()

	    init {
	    	stage.addActor(myActor)
	    }

	    override fun render(delta: Float) {
	        stage.act(delta)
	        stage.draw()
	    }
	}	

## The Stage's 'Scene Graph'

Now that you've seen how the Stage class can be used, it's worth mentioning the '2d scene graph' it's associated with. While it's another topic really and there are better examples elsewhere, you can make some really nice layouts, transitions and transformations for menus, intros, and other things using this tool. If you need to position buttons, and text, you'll be using scenes and actors a lot more. LibKTX in particular allows for you to use a very kotlin-esque shorthand for declaring elements. 

The best resource for learning about this is the documentation on github.

[LibKTX scene2d documentation](https://github.com/libktx/ktx/tree/master/scene2d)

## Tiled Maps

If you have been playing indie games, chances are very high that you've encountered levels that were created using [Tiled](https://www.mapeditor.org/). When you think about it, facing the task of creating a compelling game level by coding it is an unreasonable undertaking. Having a level design tool that allows for you to drag and drop elements and position things visually is indispensable, and Tiled is the definitive tool for managing maps made up of tiles.

By incorporating Tiled maps, you are imposing a pattern on your project that you may not want, for example, if you're trying to make a single screen puzzle game, you might not really need tiled. If you seek to create a scrolling platformer, you're really going to want to purchase this tool.

Libgdx has top-notch support for Tiled maps, and it's really easy to load a map created in this tool to your game. There's a special class called 'OrthogonalTiledMapRenderer' which you can simply call render() on in your render function, as shown below. In order to get the map to render right, you need to set the view to a camera. The Camera class is a topic unto itself, but let's just instantiate it here to get the map onto the screen and discuss it more later.

	class Game(private val application: Application) : KtxScreen {
	    val map = TmxMapLoader().load("map01.tmx")
	    val mr = OrthogonalTiledMapRenderer(map)
	    val cam = OrthographicCamera()

	    init {
	    	cam.setToOrtho(false)
	    }

	    override fun render(delta: Float) {
	        mr.setView(cam)
	        mr.render()
	    }
	}

If you want to, you can just use the OrthogonalTiledMapRenderer to do all of your drawing as shown below.

        mr.batch.begin()
        sprite.draw(mr.batch)
        mr.batch.end()

This is practical because there's no need to sync your renderers - you can get in quite a mess if your TiledMapRenderer has a different coordinate system or is scaled differently than ShapeRenderer or SpriteBatch. Chances are, when using multiple renderers you'll find out what I mean.

There's some puzzling things you'll discover if you don't call cam.setToOrtho(false) - the tiled map will be gigantic, and the 0, 0 coordinate will be in the center of the screen. Go ahead and try setting setToOrtho to true, and you'll see everything is upside down because the y coordinate is reversed by that flag. You can set the width and height of the viewport either when initializing the variable or as additional arguments to setToOrtho.

One thing that I seen a lot is where you impose a scale factor, and then initialize the map renderer with the scale factor as an argument, and then multiply the size and position of your sprites by the same scale factor, and call setToOrtho on your camera with some viewport width and height, as shown below.

	const val scaleFactor = 1/16f

	class Game(private val application: Application) : KtxScreen {
	    val map = TmxMapLoader().load("map01.tmx")
	    val mr = OrthogonalTiledMapRenderer(map, scaleFactor)
	    val cam = OrthographicCamera()
		val sprite = Sprite(Texture("adventurer.png"))
		val width = Gdx.graphics.width.toFloat()
    	val height = Gdx.graphics.height.toFloat()

	    init {
        	sprite.setPosition((width / 2) * scaleFactor, (height / 2) * scaleFactor)
        	sprite.setSize(100f * scaleFactor, 100f * scaleFactor)
	    	cam.setToOrtho(false, 35f, 25f)
	    }

	    override fun render(delta: Float) {
	        mr.setView(cam)
	        mr.render()

	        mr.batch.begin()
        	sprite.draw(mr.batch)
        	mr.batch.end()	        
	    }
	}

This may appear to be getting tedious and convoluted to follow and results in almost the same as what was shown before, and you'd be right about that - but the advantage is that you can now change the scale of the game by changing 16 to 32 or whatever, and stretching/sqashing the viewport by changing the width/height of the camera in the setToOrtho call. It's indispensable to be able to tweek those in one place. 

## Controls

I will briefly show how to handle inputs from the keyboard. Add the code below to your Game class.

    private val inputProcessor = object : KtxInputAdapter {
        override fun keyDown(keycode: Int): Boolean {
            when (keycode) {
                Keys.UP -> {
                    sprite.setPosition(sprite.x, sprite.y + 5)
                }
                Keys.DOWN -> {
                    sprite.setPosition(sprite.x, sprite.y - 5)
                }
                Keys.LEFT -> {
                    sprite.setPosition(sprite.x - 5, sprite.y)
                }
                Keys.RIGHT -> {
                    sprite.setPosition(sprite.x + 5, sprite.y)
                }
            }
            return false
        }
    }

    override fun show() {
        Gdx.input.inputProcessor = InputMultiplexer(inputProcessor)
    }

Now when running the game, you should see that the sprite's position gets changed when you press the directional keys. In order for this to be closer to what we'd want for a platformer, we'd have the sprite in a class called Player which has a Vector2 called velocity, and we'd add and subtract from the x and y fields in that in the player's 'act' function where we'd add the velocity to the position and do logic on if the position is against a barrier or not. We'd want to implement a jump mechanic as well, and limit it from only being available when the player is touching the ground, otherwise you'd be able to fly.

That will be a more complex example in the future.

## Summary

Here I've presented the elements of a simple platformer game, like the KtxGame class, the Screen class, renderers, textures, sprites, the Stage class, and how to load a tiled map and render it. I showed some options in how to get a batch for drawing things and went into some of the details of how to configure your camera and scale your coordinate system. I showed how to bind keyboard key-presses to in-game events using an inputProcessor.

Other topics I want to get into are collision detection using tiled maps, how to position game objects and other things in a tiled object layer and read them into your game, and how to create an enemy class hierarchy and detect and handle collisions between them and the player.
