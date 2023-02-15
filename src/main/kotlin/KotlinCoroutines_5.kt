import kotlinx.coroutines.*

/*
CoroutineScope, CoroutineContext and Dispatchers

CoroutineScope
    ->Each Coroutine has its own CoroutineScope instance attached to it
    ->unique
CoroutineContext
    ->may be inherited form parent
    ->Job
    ->Dispatcher
        ->Dispatcher determines the thread of a coroutine
    ->CoroutineName
 */


fun main()= runBlocking {
    /*
    //CoroutineScope
    println("runBlocking $this")


    launch {
        println("launch: $this")
    }
    async {
        println("async: $this")
    }


    println("--Some other code to do ---")

     */

    //CoroutineContext
    // without parameter:CONFINED  [CONFINED DISPATCHER] .../
    launch { //inherited from the parent
        println("C1: ${Thread.currentThread().name}") //main
        delay(1000)
        println("C1 after delay: ${Thread.currentThread().name}") //main
    }

    //With parameter: Dispatchers.Default [similar to GlobalScope.launch{}]

    launch(Dispatchers.Default) {
        println("C2: ${Thread.currentThread().name}") //Thread: T1
        delay(1000)
        println("C2 after delay: ${Thread.currentThread().name}") //Thread T1 or other thread
    }

    //With parameter: Dispatchers.Unconfined [Unconfined dispatcher]

    launch(Dispatchers.Unconfined) {
        println("C3: ${Thread.currentThread().name}")  //Thread: main
        delay(1000)
        println("C3 after delay: ${Thread.currentThread().name}") //Thread: other Thread e.x T2

        launch(coroutineContext) { //its behave like CONFINED coroutine'
            println("C3: ${Thread.currentThread().name}")  //Thread: T2
            delay(1000)
            println("C3 after delay: ${Thread.currentThread().name}") //Thread: T2
        }
    }
    println("Something")
}