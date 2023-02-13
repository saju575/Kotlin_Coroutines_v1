import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Chapter 1 (Basic about Coroutine)
fun main() = runBlocking {  //Execute in main thread
    //you may initialize runblocking function here
    //runBlocking {//create a coroutines that block the main/current thread

    println("Main program starts : ${Thread.currentThread().name}")

    //some other code
    /*
//create extra thread/worker
thread { //created a background thread or worker thread
    println("Fake work start: ${Thread.currentThread().name}")
    Thread.sleep(1000)    //pretend to do some word ..may be file uploading
    println("Fake work ends: ${Thread.currentThread().name}")

}
*/
    //using coroutines
    GlobalScope.launch {//Thread:T1 (not block the main thread)
        println("Fake work start: ${Thread.currentThread().name}")
        //Thread.sleep(1000)    //pretend to do some word ..may be file uploading

        //using Delay function that does not block the thread block a coroutines e.x C1.
        // As well the other coroutines work perfectly
        //delay(1000)

        mySuspendFunction(1000)
        println("Fake work ends: ${Thread.currentThread().name}") //Either T1 or other thread
    }
    //block the thread and wait to finish coroutines work
    //Thread.sleep(2000)


    //delay(2000)  //main thread:wait for coroutine to finish (not a right way to do this)
    mySuspendFunction(2000)

    println("Main program ends : ${Thread.currentThread().name}") //#main thread


}

//create own suspend function

suspend fun mySuspendFunction(time: Long) {
    //code
    delay(time)
}