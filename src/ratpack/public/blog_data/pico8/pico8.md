# Pico 8 - Fantasy Console

[Pico 8](https://www.lexaloffle.com/pico-8.php) is the creation of 'zep', a genius whose fascination with classic low power computers let to the invention of a number of 'toy computer' platforms. It turns out that Pico 8 was the product of several iterations of interesting experiments which ultimately led to something called [Voxatron](https://www.lexaloffle.com/voxatron.php), a miraculous platform for generating 3d voxel based game experiences _targeting html_. That Voxatron and Pico 8 are complete platforms can't be overstated - included is a system of developing, distributing, loading and modifying 'carts', which are stored in an online repository connected to the system.

While Voxatron is clearly the more sophisticated and technically impressive of the two platforms, Pico 8 has clearly struck a chord with retro/indie gaming culture. It dictates the pixelated aesthetic, chiptune sounds, and spartan, minimalist gameplay - that because Pico 8 gives you only a 128x128px window and only 32k of memory for your cart. That includes all sourcecode, spritesheets, maps, and music, all in a single file.

## What Is The Pico 8 Platform?

Pico 8 comes in a binary distribution form, which can be purchased and installed on your desktop, and can also be embedded in a webpage with a preloaded cart. When Pico 8 boots up, you're presented with a shell environment and a blinking cursor. You'll quickly orient yourself by typing 'help' and seeing the available commands. The 'splore' command brings you to the online interface where you can access different repositories of games provided by the community. Selecting a cart will load and play it. One could just go this far with the platform and be completely satiated with Pico 8 games, but once a cart is loaded you can do so much more with it.

Hit escape with a cart loaded and select 'exit to splore', then hit escape again - you're now back in the shell. Hit escape _again_ and you'll be brought to the editor. This gives you a text editor with the game's source code loaded. There are 5 sections of the editor mode including a spritesheet editor, a map editor, a sound editor, and a sequencer. Now you're free to screw around with the cart content, changing it into something completely different, or copy whatever interests you so you can use it in your own creation.

Also with a cart loaded, hitting escape to get back to the shell allows you to create directories and save/load games saved on disk. Type 'save filename' to create a filename.p8 file - open this up in your text editor and you can freely modify the source code and what you'll find is that after the source code comes the _image, map, and sound/music data_. The entire contents of the game are stored in the p8 file.

Also interesting is that you can type 'save filename.p8.png', which will give you a image file with a _picture of the game cartridge_, and you can distribute the game this way.

Important to note is that when you're using the Pico 8 shell, you're actually navigating your actual file system. The location you're in is actually the directory below in Windows

	%USERPROFILE%\AppData\Roaming\pico-8\carts

## Interested In Learning More?

The best way to learn about the Pico 8 api is by reading the [manual](https://www.lexaloffle.com/pico-8.php?page=manual) and by reading some of the readily available source code to games. It's all lua, and since lua was designed to be performant where resources are limited, it seems like the perfect fit.

If you're interested in a more 'readable' introduction to Pico 8 syntax, you should buy the [Pico 8 Fanzines](https://sectordub.itch.io/pico-8-fanzine-1).

Games created using Pico 8 are always surprising in that they tend to exceed your expectations as to what's possible with such heavy constraints. The platform's success makes a heavy statement about how the ability to distribute, create, and modify games exceeds the need for modern hardware specs and technical features.
