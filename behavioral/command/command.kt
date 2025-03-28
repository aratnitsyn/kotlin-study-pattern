package behavioral.command

interface Command {
    fun execute()
}

class Light {
    fun turnOn() {
        println("The light is on")
    }

    fun turnOff() {
        println("The light is off")
    }
}

class TurnOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

class TurnOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }

}

class RemoteControl {
    private val commands = mutableListOf<Command>()

    fun addCommand(command: Command) {
        commands.add(command)
    }

    fun executeCommands() {
        for (command in commands) {
            command.execute()
        }
    }
}

fun main() {
    val light = Light()
    val turnOn = TurnOnCommand(light)
    val turnOff = TurnOffCommand(light)
    val remoteControl = RemoteControl()
    remoteControl.addCommand(turnOn)
    remoteControl.addCommand(turnOff)
    remoteControl.executeCommands()
}