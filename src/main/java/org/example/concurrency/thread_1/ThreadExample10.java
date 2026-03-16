package org.example.concurrency.thread_1;

public class ThreadExample10 {

    // Threads in Java are managed by underlying OS in which the JVM in running on.
    // These Threads are referred to as OS-level thread. These are more often heavy that what is
    // actually needed or is necessary. eg - it might require 1-2MB of stack space for each
    // thread allocated.  This gets really heavy if we want to use many threads. So we need some lightweight threads to work with

    // VIRTUAL THREADS - [ Please see the diagram Virtual Threads]

    // Platform thread - The existing thread in java. It is executed by the OS Thread.
    // Virtual thread - This is executed by an Platform Thread.


}

