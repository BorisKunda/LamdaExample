package com.happytrees.lamdaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NOTES:
        /**PART OF JAVA 8 FEATURES ARE UNLOCKED ONLY IN API 24 AND ABOVE */
        /*
        Instead of using
        AN ANONYMOUS CLASS
        you can use
        A LAMBDA EXPRESSION
        And if this just calls one method, you can use
        A METHOD REFERENCE
        */

        /** arrow operator “->” */


        //arrow operator helps to write less code  in implementation of functional interface(interface consisting of one function) by anonymous inner class
        /*
        Optional type declaration − No need to declare the type of a parameter. The compiler can inference the same from the value of the parameter.

        Optional parenthesis around parameter − No need to declare a single parameter in parenthesis. For multiple parameters, parentheses are required.

        Optional curly braces − No need to use curly braces in expression body if the body contains a single statement.

        Optional return keyword − The compiler automatically returns the value if the body has a single expression to return the value. Curly braces are required to indicate that expression returns a value.
         */


        //BEFORE
    /*   Button button = findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this, "I was written in Java 8!", Toast.LENGTH_LONG).show();
           }
       }); */


        //AFTER --> in case of single line expression
        //Implement the onClickListener using a lambda expression
        //(parameters) -> {expression body}
        Button button = findViewById(R.id.button);
        button.setOnClickListener((View view) -> Toast.makeText(this, "I was written in Java 8!", Toast.LENGTH_LONG).show());
        //  button.setOnClickListener( view -> Toast.makeText(this, "I was written in Java 8!", Toast.LENGTH_LONG).show());//also can write like this .the parenthesis can be omitted if there is only one parameter.


        //in case of multiple lines of code expression
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            Log.d("debug", "Button2 clicked");
            Log.d("hoorah", "hoorah");
        });


        //BEFORE
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("runnable","runnable" )
            }
        }).start(); */


        //AFTER
        //  new Thread(()-> Log.d("runnable","runnable" ) ).start();
        new Thread(() -> {
            Log.d("runnable", "runnable");
            Log.d("hoorah", "hoorah");

        }).start();


        /**forEach loop */

        ArrayList<String> names = new ArrayList<String>();
        names.add("Dina");
        names.add("Danny");
        names.add("Rina");
        names.forEach(name -> Log.e("forEach loop : ", name));

        /** method references  "::" */
        /*
        A method reference can replace a lambda expression where we only have a single method call.
        Instead of the method call, we simply supply the method name attached to its class/object
        separated by a double colon(::) operator.
         */

        //Before
     /* LambdaDemo demo = new LambdaDemo();
        String something = "I am Lambda";
        demo.printSomething(something, new LambdaDemo.Printer() {
            @Override
            public void print(String val) {
                System.out.println(val);
            }
        }); */

        //after - with lamda
        /* LambdaDemo demo = new LambdaDemo();
        String something = "I am Lambda";
        demo.printSomething(something, val -> System.out.println(val)); */


        //after - with method references
        LambdaDemo demo = new LambdaDemo();
        String something = "I am Lambda";
        demo.printSomething(something, System.out::println);

    }
}
