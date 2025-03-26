interface Handler {
    fun handle(request: Request)
    fun setNextHandler(handler: Handler)
}

data class Request(val level: Level)

enum class Level {
    Junior, Middle, Senior
}

class JuniorHandler : Handler {
    private var nextHandler: Handler? = null

    override fun handle(request: Request) {
        if (request.level == Level.Junior) {
            println("JuniorHandler: Handling request.")
        } else {
            nextHandler?.handle(request)
        }
    }

    override fun setNextHandler(handler: Handler) {
        this.nextHandler = handler
    }
}

class MiddleHandler : Handler {
    private var nextHandler: Handler? = null

    override fun handle(request: Request) {
        if (request.level == Level.Middle) {
            println("MiddleHandler: Handling request.")
        } else {
            this.nextHandler?.handle(request)
        }
    }

    override fun setNextHandler(handler: Handler) {
        this.nextHandler = handler
    }
}

class SeniorHandler : Handler {
    private var nextHandler: Handler? = null
    override fun handle(request: Request) {
        if (request.level == Level.Senior) {
            println("SeniorHandler: Handling request.")
        } else {
            println("SeniorHandler: Cannot handle request, no next handler.")
        }
    }

    override fun setNextHandler(handler: Handler) {
        this.nextHandler = handler
    }
}

fun main() {
    val juniorHandler = JuniorHandler()
    val middleHandler = MiddleHandler()
    val seniorHandler = SeniorHandler()

    juniorHandler.setNextHandler(middleHandler)
    middleHandler.setNextHandler(seniorHandler)

    val request = Request(Level.Senior)
    juniorHandler.handle(request)
}