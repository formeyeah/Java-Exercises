package ir.freeland.annotation.define;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.TYPE) // This annotation can be applied to classes
public @interface Info {
    String author();
    String date();
    String version();
}