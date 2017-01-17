# Random Spawn
## About
#### Current Version 1.0.0
Teleport someone to a random spawn point in the world. Great for anarchy servers.

## Installation
Just downloaded the JAR from the releases tab and drop it into your `plugins` folder and start the server, edit `config.yml`, reload, enjoy.

## Configuration
### Coordinates (`coords`)
Each coordinate (x and z) have a min and max option. This gives you the ability to choose a range for people to spawn in so you don't have to sacrifice storage or RAM usage when using this plugin.

### First Join (`on-first-join`)
This takes someone to a random spawn on the first time they join.

### On Join (`onjoin`)
Every time someone joins, they get taken to a random spawn.

### On Respawn (`onrespawn`)
Every time someone respawns they get taken to a random point.

### Use Beds (`use-beds`)
If `true`, beds will be used as a spawn point when `onrespawn` is active. If `false`, they will respawn at a random location.

### Use Commands (`use-commands`)
If `true`, it will register the `/randomspawn` command.

### Signs (`signs`)
Allows the use of the random spawn signs. When creating a sign on the first line type  `randomspawn` and the sign will change to a Random Spawn sign with your text (`line-1`, `line-2`, `line-3`) on it.

### Debugging (`debugging`)
If you're having issues, you can turn on `debug` and it can log out a bit more information.

## Permissionns
### `randomspawn.command`
Allows use of the `/randomspawn` command. Is on by default.

### `randomspawn.teleportothers`
Gives the ability to teleport others using `/randomspawn player`. Defaults to OP.

### `randomspawn.makesign`
Allows people to make the random spawn signs. Defaults to OP.

## Donate
[![Donate](https://az743702.vo.msecnd.net/cdn/kofi1.png?v=f)](https://ko-fi.com/636QU7F12V5F)

## Development Video
[![Coding Off](https://img.youtube.com/vi/reXJ8JbS2kU/0.jpg)](https://www.youtube.com/watch?v=reXJ8JbS2kU)
