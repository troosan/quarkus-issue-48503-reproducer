# Reproduces error described in issue https://github.com/quarkusio/quarkus/issues/48503

to reproduce:

the following works fine
```
mvn package
```

but in dev mode, then run tests
```
mvn quarkus:dev
```

you'll get
```
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
2025-08-08 14:26:41,301 INFO  [io.quarkus] (Quarkus Main Thread) tester-rest 0.0.1-SNAPSHOT on JVM (powered by Quarkus 3.24.1) started in 1.070s. Listening on: http://localhost:8080

2025-08-08 14:26:41,303 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2025-08-08 14:26:41,303 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, rest, rest-jackson, smallrye-context-propagation, vertx]
2025-08-08 14:26:43,944 ERROR [io.qua.test] (Test runner thread) ==================== TEST REPORT #1 ====================
2025-08-08 14:26:43,944 ERROR [io.qua.test] (Test runner thread) Test ServiceTest failed 
: org.junit.jupiter.engine.execution.ConditionEvaluationException: Failed to evaluate condition [io.quarkus.test.junit.QuarkusTestExtension]: Internal error: Test class was loaded with an unexpected classloader or the thread context classloader was incorrect.
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1685)
	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
	at java.base/java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.IllegalStateException: Internal error: Test class was loaded with an unexpected classloader or the thread context classloader was incorrect.
	at io.quarkus.test.junit.AbstractJvmQuarkusTestExtension.evaluateExecutionCondition(AbstractJvmQuarkusTestExtension.java:201)
	... 14 more
Caused by: java.util.NoSuchElementException: SRCFG00027: Could not find a mapping for io.quarkus.deployment.dev.testing.TestConfig
	at io.smallrye.config.SmallRyeConfig.getConfigMapping(SmallRyeConfig.java:647)
	at io.smallrye.config.SmallRyeConfig.getConfigMapping(SmallRyeConfig.java:637)
	at io.quarkus.test.junit.AbstractJvmQuarkusTestExtension.evaluateExecutionCondition(AbstractJvmQuarkusTestExtension.java:161)
	... 14 more


2025-08-08 14:26:43,945 ERROR [io.qua.test] (Test runner thread) Test testGet() failed 
: org.junit.jupiter.engine.execution.ConditionEvaluationException: Failed to evaluate condition [io.quarkus.test.junit.QuarkusTestExtension]: Internal error: Test class was loaded with an unexpected classloader or the thread context classloader was incorrect.
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1685)
	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
	at java.base/java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
Caused by: java.lang.IllegalStateException: Internal error: Test class was loaded with an unexpected classloader or the thread context classloader was incorrect.
	at io.quarkus.test.junit.AbstractJvmQuarkusTestExtension.evaluateExecutionCondition(AbstractJvmQuarkusTestExtension.java:201)
	... 14 more
Caused by: java.util.NoSuchElementException: SRCFG00027: Could not find a mapping for io.quarkus.deployment.dev.testing.TestConfig
	at io.smallrye.config.SmallRyeConfig.getConfigMapping(SmallRyeConfig.java:647)
	at io.smallrye.config.SmallRyeConfig.getConfigMapping(SmallRyeConfig.java:637)
	at io.quarkus.test.junit.AbstractJvmQuarkusTestExtension.evaluateExecutionCondition(AbstractJvmQuarkusTestExtension.java:161)
	... 14 more


2025-08-08 14:26:43,946 ERROR [io.qua.test] (Test runner thread) >>>>>>>>>>>>>>>>>>>> Summary: <<<<<<<<<<<<<<<<<<<<
ServiceTest Failed to evaluate condition [io.quarkus.test.junit.QuarkusTestExtension]: Internal error: Test class was loaded with an unexpected classloader or the thread context classloader was incorrect.
testGet() Failed to evaluate condition [io.quarkus.test.junit.QuarkusTestExtension]: Internal error: Test class was loaded with an unexpected classloader or the thread context classloader was incorrect.

2025-08-08 14:26:43,946 ERROR [io.qua.test] (Test runner thread) >>>>>>>>>>>>>>>>>>>> 1 TEST FAILED <<<<<<<<<<<<<<<<<<<<
2025-08-08 14:27:03,080 INFO  [io.quarkus] (Quarkus Main Thread) tester-rest stopped in 0.013s
```
