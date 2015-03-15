== Mustache That Just Works

```java
import com.nabriski.mustacheeasy;

String tmplStr = "Hi {{name}}";
String json = "{\"name\":\"Harry\"}";
System.out.println(MustacheEasy.execute(tmplStr,json)); // "Hi Harry"

```
