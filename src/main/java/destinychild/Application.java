package destinychild;

        import com.github.saphyra.authservice.EnableAuthService;
        import com.github.saphyra.exceptionhandling.EnableExceptionHandler;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAuthService
@EnableExceptionHandler
public class Application {
    public static void main(String[] arg) {
        SpringApplication.run(Application.class, arg);
    }
}