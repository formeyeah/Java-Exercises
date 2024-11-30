package ir.freeland.annotation.realworld;

@Service
public class MyService {
    
    @Autowired
    private MyRepository myRepository;

    public void performAction() {
        // Business logic here
    }
}
