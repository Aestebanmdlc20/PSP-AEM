package org.example;

public class Pepinillo {
    public class P {
        // Modelo Singleton

        private static P instance;

        private int ;
        private int ;

        private P(int , int ){
            this. = ;
            this. = ;
        }

        private synchronized static void createInstance(int , int ){
            if(instance == null){
                instance = new P(, );
            }
        }

        public static P getInstance(int , int ){
            if (instance == null){
                createInstance(, );
            }
            return instance;
        }
    }
}
