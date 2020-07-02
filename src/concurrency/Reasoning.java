package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread.
//    Create a Thread called Reasoning. It should be created by inheriting from the Thread class. Define a void method on the Reasoning class called, distinguish. In this method, Print out the following statements to the console:
    void distinguish() {
//    public void run() {
//        print out what the difference is between a thread and a process.
//        print out what will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
//        Execute this distinguish() method as soon as the thread is started. (i.e. in the run() method)
//        Kick off the Reasoning thread in the Main class of the concurrency package.
        System.out.println("Threads are the smallest part of a Java process which can run concurrently with other threads and Java processes.");
        System.out.println("A process has its own address space. A thread uses the process’s address space and share it with the other threads of that process.");
        System.out.println("A program in execution is often referred to as a process. A thread is a subset(part) of the process.\n" +
                "A process consists of multiple threads.");
        System.out.println("A process is sometime referred as task. A thread is often referred as lightweight process.");
        System.out.println("If you call the run() method directly, it will execute, not in another thread, but in the current thread. If start isn't called, then the Thread created will never run. The main thread will finish and the Thread will be garbage collected.");

    }

    @Override
    public void run() {
        this.distinguish();
    }
}

