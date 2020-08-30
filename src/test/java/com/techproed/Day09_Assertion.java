package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

        private static WebDriver driver;

        @BeforeClass
        public static void setUp() {
            WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @Test // bu annotation Test method'larin calismasini saglamak icin

        public void test1() {
            driver.get("http://google.com");

            String title = driver.getTitle();

            Assert.assertEquals("Google Arama Sayfasi","title");
        }

        @Test
        public void test2() {
            driver.get("http://amazon.com");
            String title = driver.getTitle();

            boolean iceriyorMu = title.contains("Amazon"); //"true" ya da "false"

            //boolean veri type inde bir deger giriyoruz
            Assert.assertTrue(iceriyorMu);//bunun true oldugunu dogrula
        }

        @Test
        public void test3() {
            driver.get("http://facebook.com");
            String title = driver.getTitle();

            //Facebook.com'un title'i Youtube kelimesini icermesin

            boolean iceriyorMu = title.contains("Youtube");
            Assert.assertFalse(iceriyorMu);//False oldugunu dogrula
           // Assert.assertTrue(title.contains("YouTube")?false:true);  ==> ternary ile

        }

        @Test
        public void test4 () {
            driver.get("http://google.com");

            String title = driver.getTitle();

            System.out.println("MERHABALAR....");

            Assert.assertEquals("Google Arama Sayfasi","title");

            //eger test basarisizsa  testin icersinde kalan kismi calistirmiyor==> bir sonraki teste geciyor.
            System.out.println("TEST DOGRULAMA ISLEMI BITTI...");
        }

        @AfterClass
        public static void tearDown() {
            driver.quit();
        }

}
