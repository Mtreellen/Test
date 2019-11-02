package basic;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest extends SuperClass {
    @Override
    public void test() throws FileNotFoundException {

    }
}

class SuperClass{
    public void test() throws IOException{

    }
}