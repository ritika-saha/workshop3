import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.store.BookListing;
import com.store.DuplicateUserException;
import com.store.InvalidInputException;
import com.store.OrderException;
import com.store.OrderProcessing;
import com.store.UserReg;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @BeforeAll
    public static void beforeall(){
        System.out.println("Started Testing");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Ended Testing");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Testcase start");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Testcase end");   
    }

    @Test
    public void registerUserTestDuplicate() throws InvalidInputException{
        UserReg user=new UserReg();
        try {
            user.registerUser("rr123", "SecurePwd123$", "riti1@gmail.com", "91 9292929292");
            user.registerUser("rr123", "SecurePwd123$", "riti1@gmail.com", "91 9292929292");
        } catch (DuplicateUserException e) {
            fail("DUPLICATE USER :"+e.getMessage());
            e.printStackTrace();
        }
    }

    //test for passwords
    @Test
    public void registerUserTestPassword() throws DuplicateUserException{
        UserReg user=new UserReg();
        try {
            user.registerUser("rr13", "SecurePwd123$", "riti1@gmail.com", "91 9191919191");
        } catch (InvalidInputException e) {
            fail("Invalid input : "+e.getMessage());
            e.printStackTrace();
        }
    }
     @Test
    public void registerUserTestPasswordSad() throws DuplicateUserException{
        UserReg user=new UserReg();
        try {
            user.registerUser("rr13", "Secure", "riti1@gmail.com", "91 9191919191");
        } catch (InvalidInputException e) {
            fail("Invalid input : "+e.getMessage());
            e.printStackTrace();
        }
    }

    //for email
    @Test
    public void registerUserTestEmail() throws DuplicateUserException{
         UserReg user=new UserReg();
        try {
            user.registerUser("rr13", "SecurePwd123$", "riti1@gmail.com", "91 9191919191");
        } catch (InvalidInputException e) {
            fail("Invalid input : "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void registerUserTestEmailSad() throws DuplicateUserException{
         UserReg user=new UserReg();
        try {
            user.registerUser("rr13", "SecurePwd123$", "riti1@gmail", "91 9191919191");
        } catch (InvalidInputException e) {
            fail("Invalid input : "+e.getMessage());
            e.printStackTrace();
        }
    }

    //for phone number
    @ParameterizedTest
    @ValueSource(strings = {"91 3939393939","91 4848484848","914040404040","4949494949","91 696969","91 0919191919","uu 3838383838","91 939393939r"})
    public void registerUserTestPhone(String data) throws DuplicateUserException{
        UserReg user=new UserReg();
        try {
            user.registerUser("rr13", "SecurePwd123$", "riti1@gmail.com", data);
        } catch (InvalidInputException e) {
            fail("Invalid input : "+e.getMessage());
            e.printStackTrace();
        }
    }


    //ISBN testing
    @ParameterizedTest
    @ValueSource(strings={"978-0-306-40615-7","252"})
    public void testBookListing(String data){
        BookListing book=new BookListing();
        try{
            //String title,String author,String ISBN,String price,String quantity
            book.enterBook("sfsf", "sdfs", data, "323", "2323");
        }catch(InvalidInputException e){
            fail("invalid book : "+e.getMessage());
            e.printStackTrace();
        }
    }

    //null value testing
    @Test
    public void testBookListingNull(String data){
        BookListing book=new BookListing();
        try{
            //String title,String author,String ISBN,String price,String quantity
            book.enterBook("sfsf", null, "978-0-306-40615-7", "323", "2323");
        }catch(InvalidInputException e){
            fail("invalid book : "+e.getMessage());
            e.printStackTrace();
        }
    }

    //book availability testing
     @ParameterizedTest
    @ValueSource(strings={"978-0-306-40615-7","978-0-306-40615-6"})
    public void testOrderProcessingISBN(String data) throws InvalidInputException{
        OrderProcessing order=new OrderProcessing();
        try{
            order.processOrder(data, "5");
        }catch(OrderException e){
            fail("invalid : "+e.getMessage());
            e.printStackTrace();
        }
    }


    //quantity testing
     @ParameterizedTest
    @ValueSource(strings={"500","2"})
    public void testOrderProcessingQuant(String data) throws InvalidInputException{
        OrderProcessing order=new OrderProcessing();
        try{
            order.processOrder("978-0-306-40615-7", data);
            order.processOrder("978-0-306-40615-9", data);
        }catch(OrderException e){
            fail("invalid : "+e.getMessage());
            e.printStackTrace();
        }
    }
    

    
}
