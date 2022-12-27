package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //это Аспект-класс, то есть сквозная функциональность
public class LoggingAndSecurityAspect {

    /*@Pointcut("execution(* aop.UniLibrary.*(..))") //для всех методов из UniLibrary
    private void allMethodsFromUniLibrary(){}
    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())") // для метода public void returnMagazine()
    private void returnMagazineFromUniLibrary(){}
    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")//для всех методов, кроме returnMagazine()
    private void allMethodsExceptReturnMagazineFromUniLibrary(){}

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")//Advice для всех методов, кроме returnMagazine()
    public void beforeAllMethodsExceptReturnMagazineAdvice(){
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
    }*/


    /*@Pointcut("execution(* aop.UniLibrary.get*())") //return type любой, метод из UniLibrary начинается на get, без параметров
    private void allGetMethodsFromUniLibrary(){}
    @Pointcut("execution(* aop.UniLibrary.return*())") //return type любой, метод из UniLibrary начинается на return, без параметров
    private void allReturnMethodsFromUniLibrary(){}
    //Создадим Pointcut как комбинацию первых двух Pointcut-ов, то есть и для методов get...  для return...
    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary(){}

    @Before("allGetMethodsFromUniLibrary()") //для методов getBook и getMagazine
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log #1");
    }
    @Before("allReturnMethodsFromUniLibrary()") //для методов returnBook и returnMagazine
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
    }
    @Before("allGetAndReturnMethodsFromUniLibrary()") //для методов getBook, getMagazine, returnBook и returnMagazine
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
    }*/




    @Pointcut("execution(* get*())") //объявляем Pointcut с выражением execution(* get*())
    private void allGetMethods(){}

    //метод, который будет выполнять перед методом getBook
    //@Before("execution(public void get*())") //для всех методов с именем на GET
    //@Before("execution(public void aop.UniLibrary.getBook())")//для методов из класса UniLibrary с именем getBook
    //@Before("execution(public void getBook())")//для всех методов с именем getBook
    //@Before("execution(public void getBook(String))")//для всех методов с именем getBook и параметром String
    //@Before("execution(public void *(*))")//для всех методов с любым именем и любым ОДНИМ параметром
    //@Before("execution(public void *(..))")//для всех методов с любым именем и любым количеством параметром любого типа
    //@Before("execution(public void getBook(aop.Book))")//в качестве переметра объект класса aop.Book, необходимо указывать путь
    //@Before("execution(* *(..))")// для всех методов с любым именем и количеством (0 и более) параметров любого типа
    //@Before("execution(* get*())") //подходит getBook и getMagazine
    @Before("allGetMethods()") //используем объявление Pointcut
    public void beforeGetLoggingAdvice(){
        //Advice - это меод, который находится в Аспект классе
        // и определяет, что должно произойти при вызове метода(getBook)
        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
    }

    //добавим Advice по проверке прав,кто может брать книгу/журнал (Security)
    //@Before("execution(* get*())")
    @Before("allGetMethods()") //используем объявление Pointcut
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
    }


    //@Before("execution(public void returnBook())") //для всех методов с именем returnBook с типом void
    /*@Before("execution(* returnBook())") //для всех методов с именем на returnBook с любым возвращаемым типом
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
    }*/
}
