This project reproduce issue in [spring-cloud-contract](https://github.com/spring-cloud/spring-cloud-contract/).

If you run:
```shell script
./gradlew publishToMavenLocal --debug
```

Now search in output for: `AAAAAAAA` then you see only: `AAAAAAAA groovy`, but you should also see `AAAAAAAA java` 
as defined in contractGenerator class.
Another log output confirmed a bug:

```text
2020-07-07T15:23:41.205+0200 [INFO] [org.gradle.api.Task] Stubs output dir [/Users/marcinstachniuk/code/scc-generate-from-java-issue/producer/build/stubs
2020-07-07T15:23:41.205+0200 [INFO] [org.gradle.api.Task] Spring Cloud Contract Verifier Plugin: Invoking DSL to client stubs conversion
2020-07-07T15:23:41.205+0200 [INFO] [org.gradle.api.Task] Contracts dir is [/Users/marcinstachniuk/code/scc-generate-from-java-issue/producer/build/stubs/META-INF/com.example/producer/1.0.0/contracts] output stubs dir is [/Users/marcinstachniuk/code/scc-generate-from-java-issue/producer/build/stubs/META-INF/com.example/producer/1.0.0/mappings]
2020-07-07T15:23:41.205+0200 [DEBUG] [org.springframework.cloud.contract.verifier.file.ContractFileScanner] File [/Users/marcinstachniuk/code/scc-generate-from-java-issue/producer/build/stubs/META-INF/com.example/producer/1.0.0/contracts/com/contractGenerator.java] wasn't ignored but no converter was applicable. The file is a directory [false]
2020-07-07T15:23:41.219+0200 [QUIET] [system.out] AAAAAAAA groovy
2020-07-07T15:23:41.225+0200 [DEBUG] [org.springframework.cloud.contract.verifier.file.ContractFileScanner] Creating a contract entry for path [/Users/marcinstachniuk/code/scc-generate-from-java-issue/producer/build/stubs/META-INF/com.example/producer/1.0.0/contracts/com/shouldGenerateStubs.groovy] and metadata [org.springframework.cloud.contract.verifier.file.ContractMetadata(/Users/marcinstachniuk/code/scc-generate-from-java-issue/producer/build/stubs/META-INF/com.example/producer/1.0.0/contracts/com/shouldGenerateStubs.groovy, false, 2, null, [Contract(priority:null, request:Request(property:Request$ClientPatternValueDslProperty(), httpMethods:HttpMethods(), method:DslProperty(clientValue:GET, serverValue:GET), url:null, urlPath:UrlPath(super:Url(queryParameters:null, super:DslProperty(clientValue:/abc, serverValue:/abc))), headers:Request$RequestHeaders(), cookies:null, body:null, multipart:null, bodyMatchers:null), response:Response(Response$ServerPatternValueDslProperty(), org.springframework.cloud.contract.spec.internal.HttpStatus@7f, DslProperty(clientValue:200, serverValue:200), null, null, null, null, false, null), label:null, description:description, name:gen from groovy, input:null, outputMessage:null, ignored:false)])]
```

So in the same default setup the Groovy files are processed normally, but Java files not.