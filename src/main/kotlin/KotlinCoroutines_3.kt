import kotlinx.coroutines.*

/*
Chapter 3 (Coroutine Cancellation)
#To cancel a coroutine , it should be cooperative

->Timeout(This also a coroutine builder)
# automatically behave like a join() function
    ->WithTimeout
    ->WithTimeoutOrNull
 */


fun main() = runBlocking {//create a blocking coroutine that executes in current thread

    println("Main program starts : ${Thread.currentThread().name}") //main thread

    /*
    val job: Job = launch(Dispatchers.Default) {//Thread T1 :Creates a non blocking coroutine
        for (i in 1..500) {
            if (!isActive) { //explicitly check for the cancellation status within the coroutine
                //break
                return@launch
            }
            print("$i.")
            //delay(50) //delay,yield belong to kotlinx.coroutine so it cooperative and cancelable
            //yield()
            Thread.sleep(1)
        }
        println()


    }
    */
    /*
    // handle exception
    val job1: Job=launch(Dispatchers.Default) {//Thread T1 :Creates a non blocking coroutine

        try{
            for (i in 1..500) {

                print("$i.")
                //delay(50) //delay,yield belong to kotlinx.coroutine so it cooperative and cancelable
                //yield()
                delay(50)
            }
            println()
        }
        catch (ex:CancellationException){
            //println("\nException caught safely")
            println("\nException: ${ex.message}")
        }
        finally {
            //delay(1000) //Generally we don't use suspending function in finally block
            //If we need to then
            withContext(NonCancellable){//this actually a coroutine builder
                //start a new coroutine
                delay(1000)
                println("\nclose resources in finally ")
            }
        }
    }
    */
    //Timeout
    // withTimeout
    /*
    try {
        withTimeout(2000){
            try {
                for(i in 0..500){
                    print("$i.")
                    delay(500)
                }
            }
            catch (ex:TimeoutCancellationException){
                //code
                println("TimeOut")
            }
            finally {
                //code
            }
        }
    }
    catch (ex:Exception){
        //something
    }
     */

    //withTimeoutOrNull


    val result:String?=withTimeoutOrNull(1000){
        for (i in 0..500){
            print("$i.")
            delay(50)
        }
        "I am done"
    }


    println("\n$result") //# it return null because there was a time out
    //delay(10)
   //job.cancelAndJoin()
    //job1.cancelAndJoin()
    //define own cancelable message
    //job1.cancel(CancellationException("My own cancelable message"))
    //job1.join()
    //job.cancel()
    //job.join() //waits for coroutines to finish
    println("\nMain program ends: ${Thread.currentThread().name}") //main thread

}
