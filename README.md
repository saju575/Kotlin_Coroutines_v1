# Kotlin Coroutines Practice Code

This is just a practice code. Used to implement core the concept of coroutines

### Topic cover

     • Coroutine Basic
        → is a light weight thread but not thread
        → create as many as possible like 1000
     • Coroutine Builders
        → launch 
            → create coroutine at local scope
            → inherit the threads and coroutine scope of the immediate parent coroutine
            → using Job object we can control the coroutine
        → async  
            → something that you have to return.returns a reference ot the  deferred<T> object
            → inherit the threads and coroutine scope of the immediate parent coroutine
            → using Job object we can control the coroutine
        → runBlocking 
            → Work on actually main thread
    • Coroutine Cancellation
        → To cancel a coroutine , it should be cooperative
        → delay,yield belong to kotlinx.coroutine so it cooperative and cancelable
        → isActive is used to explicitly check for the cancellation status within the coroutine
        → withContext(NonCancellable) is actually a coroutine builder that is used to in finally block
    • Handle cancel Exception
        → use try catch block
        → delay,yield etc through an exception when job is cancel
    • Timout
        → WithTimeout
            → Do not return any thing 
            → need to handle timeoutCancelException
        → WithTimeoutOrNull
            → return some data or null if timeOut occur
            → not to need to handle timeoutCancelException





