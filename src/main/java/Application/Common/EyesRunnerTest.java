package Application.Common;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

public class EyesRunnerTest {


   protected EyesRunner runner;
    private static EyesRunnerTest eyesInstance = new EyesRunnerTest();
    private  EyesRunnerTest(){
    }

    public static EyesRunnerTest getInstance() {
        return eyesInstance;
    }


    ThreadLocal<Eyes> eyes = new ThreadLocal<Eyes>() {
        @Override
        protected Eyes initialValue() {

             runner = new ClassicRunner();

            // Initialize the eyes SDK
            Eyes eyes = new Eyes(runner);

            return eyes;
        }
    };



    public Eyes getEyes() {
        return eyes.get();
    }
}
