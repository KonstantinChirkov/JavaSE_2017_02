package edu.javacourse.second;

/**
 * Created by Mozart on 01.03.2017.
 */
public class Second
{
    public static void main(String[] args) {

//        for(int i=0; i<3; i++) {
//            System.out.println("Hello");
//        }
//
//        int i = 0;
//        while(i<10){
//            System.out.println("Hello" + i);
//            i++;
//        }
//
//        int i = 0;
//        do{
//            System.out.println("Hello" + i);
//            i++;
//        } while (i<10);

/*        if (getFirst() && getSecond()) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }
*/
//        int t = 2;
//        switch (t) {
//            case 1: {
//                System.out.println("One");
//                break;
//            }
//            case 2: {
//                System.out.println("Two");
//                break;
//            }
//            case 3: {
//                System.out.println("Three");
//                break;
//            }
//            case 4:
//            case 5: {
//                System.out.println("Four Five");
//                break;
//            }
//            default: {
//                System.out.println("Other");
//                break;
//            }
//
//        }
        for(int i=0;;i++){
            if(i==3){
                continue;
            }
            System.out.println("Hello" + i);
            if(i==5){
                break;
            }
        }
    }
        static boolean getFirst(){
            System.out.println("First is called");
            return true;
        }
        static boolean getSecond(){
            System.out.println("Second is called");
            return true;
        }

    }

