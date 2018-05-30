package com.starpath.smart.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import javax.xml.crypto.dsig.CanonicalizationMethod;

@RunWith(BlockJUnit4ClassRunner.class)
public class AppTest {

    private static App testClass;

    @BeforeClass
    public static void doThisBeforeRunning(){
        testClass = new App();
        System.out.print("BeforeClass\n");
    }

    @Before
    public void doThisBeforeRunningTest(){
        System.out.print("BeforeTest\n");
    }
    @Test
    public void testMultiplyWorks(){
        System.out.print("Running Test 1\n");
        Assert.assertEquals("Multiply is working",27,testClass.multiple(3,9));
    }

    @Test
    public void testMultiplyNotWorks(){
        System.out.print("Running Test 2\n");
        Assert.assertNotEquals("Multiply is working",27,testClass.multiple(2,7));
    }


    @After
    public void doThisAfterRunningTest(){
        System.out.print("AfterTest\n");
    }

    @AfterClass
    public static void doThisAfterRunning(){
        testClass = null;
        System.out.print("AfterClass\n");
    }





}
