@file:JvmName("App")

package com.natevaughan.jkommander

import com.beust.jcommander.JCommander
import com.beust.jcommander.Parameter
import org.slf4j.LoggerFactory

object App {
    val log = LoggerFactory.getLogger(App.javaClass)

    @JvmStatic
    fun main(args: Array<String>) {
        val commandArgs = parse(args)

        if (commandArgs.file != null) {
            log.info("File specified was ${commandArgs.file}")
        }

        if (commandArgs.debug != null) {
            log.info("Debug set to ${commandArgs.debug}")
        }

    }

    fun parse(args: Array<String>): CommandArgs {
        val commandArgs = CommandArgs()

        JCommander.newBuilder()
                .addObject(commandArgs)
                .build()
                .parse(*args)

        return commandArgs
    }
}

class CommandArgs {

    @Parameter(names = arrayOf("-f", "--file"), description = "The path of the file to process")
    var file: String? = null

    @Parameter(names = arrayOf("-d", "--debug"), description = "Enable debug mode")
    var debug: Boolean? = false

}