import kotlinx.coroutines.*

//chapter 2 (coroutine Builders)
/*
Coroutine Builders
->launch
    ->launch{
            //some data computation
            //login operation
        }(create coroutine at local scope)
        #destroy when activity are destroy
        #By default choices
    ->GlobalScope.launch{
            //File download
            //play music
        }(create coroutine at global(app) level)
        #are top level coroutines and can survive the entire life of the application
        #use only when needed
->async
    ->async{
        //return something
        }
        #returns a reference ot the  deferred<T> object
    ->GlobalScope.async{
        // used to return something
        }
->runBlocking
 */

fun main() = runBlocking {//T1
    println("Main program starts : ${Thread.currentThread().name}") //main thread

    //using coroutines
    val job: Job = launch {//Thread:T1 (inherit the threads and coroutine scope of the immediate parent coroutine)
        println("Fake work start: ${Thread.currentThread().name}")
        //Thread.sleep(1000)    //pretend to do some word ..may be file uploading

        //using Delay function that does not block the thread block a coroutines e.x T1.
        // As well the other coroutines work perfectly
        //delay(1000)

        mySuspendFunction(1000)
        println("Fake work ends: ${Thread.currentThread().name}") //Either T1 or other thread
    }
    //async function
    val deferredJob:Deferred<String> =async {
        mySuspendFunction(500)
        "Sakil Ahmed"
    }
    val name=deferredJob.await()
    println(name)

    //delay(2000)  //main thread:wait for coroutine to finish (not a right way to do this)
    //mySuspendFunction(2000)

    //using Job object we can control the coroutine

    job.join() //join function wait for the coroutine to finish its execution

    println("Main program ends : ${Thread.currentThread().name}") //#main thread
}