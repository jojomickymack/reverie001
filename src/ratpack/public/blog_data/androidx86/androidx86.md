# Check Out Androidx86

Google's philosophy on licensing Android is unique - the kernel is linux, GPL, the c library, Bionic, is BSD, and the Android source code is Apache. That means all of Google's research and development is ultimately accessible to whomever is interested in it at [source.android.com](https://source.android.com/).

Android is engineered for ARM processors, which are vastly more efficient for low power devices. For the system to be ported to an x86 Intel based architecture is not an arbitrary obstacle, and Androidx86 has a completely different kernel. The project has been around for several years and is usually a major version behind the latest Android sdk available.

The concept of desktop Android is definitely gaining more traction since Google started manufacturing Chromebooks with built in Android app support, but for running Android as your primary OS, Androidx86 is the solution. This blog entry is a repository for general information about the platform and how to get around some issues.

## Getting Netflix To Work

On a fresh install using the livecd, you'll find that Chrome doesn't support running netflix in browser, and that the app crashes. I'm not sure what the cause of this is, but there's a special build of the app provided for compatibility with Android 4 which will run on Androidx86.

The instructions are pretty clear at [this link](https://help.netflix.com/en/node/57688), but if the link is down, this is a summary.

Enable 'allow apps from other sources' in the security menu.
Install the old app downloaded from [this link](https://netflixhelp.s3.amazonaws.com/netflix-4.16-200147-release.apk)

Hopefully the source of the issue is resolved in a downstream version of Androidx86.

## Using An External Monitor

In order to change the boot settings of Androidx86, you've got to mess around with the grub boot. Hopefully [this blog](http://androidcarx86.blogspot.com/2012/04/android-x86-and-external-monitor-vga.html) can help you cope with editing it - it's tedious and error prone.

Androidx86 does a great job of configuring itself to work on the laptop it's installed on - but if you plug in an external monitor it'll do it's best to mirror what's on the host's screen when you booted. My issue was that the resolution for the laptop screen (1366x768) wasn't taking up all of the monitor space on a 1920x1080 external monitor plugged into the vga port.

The trick here was actually to boot the machine with the external monitor plugged in and _disable the first screen detected_. It then uses the external monitor as the primary display and automatically detects its resolution.

Many blog posts describing editing the grub menu so it's permanent - since booting with the first monitor disabled could potentially cause other problems, it's smart to just get into the grub menu and doctor the bootscript and boot it on an ad-hock basis. The entry to disable the first monitor is below.

Video=LVDS-1:d

Hopefully that helps someone out ; )
