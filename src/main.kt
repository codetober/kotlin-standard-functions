import java.io.File

/**
 * @author CodeTober
 *
 * Standard Functions Tutorial
 * apply, let, run, with, also, takeIf
 */


fun main(args: Array<String>) {

    // Apply is generally used for configuration of an object, such as our demo User.
    val canineUser = User()
    canineUser.name = "Carat"
    canineUser.occupation = "Guard Dog"
    canineUser.age = 4

    // Using Apply to configure
    val human = User().apply{
        name = "Doug"
        occupation = "Keeper"
        age = 26
    }


    // Let allows access to 'it' which is the instance of the variable
    val destination = "County".let{
        it.plus(" Dog Park! ")
    }.let(::enhanceString)

    println(destination)

    // Run has the same scope as Apply, however, it returns boolean instead of the receiver
    val isReadyToPlay = canineUser.name.run(::isPlayful)
    println("$isReadyToPlay - Ready to Play?")

    // With is a variation on the Run function
    // Usually can just use Run instead, this one requires a parameter
    val isReadyForRide = with(destination){
        contains("I'm Ready!")
    }
    println("$isReadyForRide - Ready for Ride?")

    // Also is similar to let - returns receiver instead of lambda result
    canineUser.also{
        println(it.hungry.toString() + " - Initial Hunger")
    }.also{
        if(it.hungry){
            it.makeFull()
        }
    }

    println(canineUser.hungry.toString() + " - After Hunger Check")

    // TakeIf returns true or false based on a predicate passed
    val isHumanReadyToGo = human.takeIf{
        it.name == "Doug"
    }?.setReady()

    println(human.ready.toString() + " - Is Human Ready?!")
    

}

private fun isPlayful(canineName: String) = canineName == "Turbo"
private fun enhanceString(original: String) = original.plus(listOf("Amazing!", "I'm Ready!", "Love it!").shuffled().first())