import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/*
Composing Suspending functions
->sequential function
->Concurrent function
->Lazy Coroutine execution
 */

fun main()= runBlocking {//create a blocking coroutine that execute in main thread
    println("Main program start : ${Thread.currentThread().name}")

    /*
    val time= measureTimeMillis {
        //Concurrent function
        val msgOne=async{getMessageOne()}
        val msgTwo=async { getMessageTwo() }
        println("The message is ${msgOne.await() + msgTwo.await()}")
    }
    println("Total time taken $time")
     */

    //Lazy coroutine execution
    val time= measureTimeMillis {
        val msgOne=async(start=CoroutineStart.LAZY){getMessageOne()}
        val msgTwo=async(start = CoroutineStart.LAZY) { getMessageTwo()}
        println("The message is ${msgOne.await() + msgTwo.await()}")
    }
    println("Total time taken $time")
    println("Main program end : ${Thread.currentThread().name}")

}

suspend fun getMessageOne():String{
    delay(1000L)
    println("Message one function called")
    return "Hello"
}

suspend fun getMessageTwo():String{
    delay(1000L)
    println("Message two function called")
    return " World"
}