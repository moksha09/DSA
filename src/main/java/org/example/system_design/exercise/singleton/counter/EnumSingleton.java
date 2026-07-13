package org.example.system_design.exercise.singleton.counter;

public enum EnumSingleton {
    // The enum constant itself is the singleton instance.
    INSTANCE;

    // Enum can have fields and methods -
    private int counter = 0;

    public int getCount(){
        return INSTANCE.counter;
    }

    public void increment(){
        INSTANCE.counter++;
    }


    public static void main(String[] args) {
        // After implementing, usage should look like:
        EnumSingleton c1 = EnumSingleton.INSTANCE;
        EnumSingleton c2 = EnumSingleton.INSTANCE;
        System.out.println("Same instance: " + (c1 == c2));
        for (int i = 0; i < 5; i++) {
            c1.increment();
        }
        System.out.println("Count after 5 increments: " + c1.getCount());
    }
}
