# yay

<p>
    <img src="/docs/icon.jpeg" width="256" height="256" />
</p>

Minimal HTTP library for Scala with functional programming.

## Getting yay
Right now, yay is not a published project. If you want to use the library,
you should clone the project and publish it locally as on the following command:
```bash
# on interactive sbt shell
sbt:yay> publishLocal
...
[info]  published ivy to /home/USER/.ivy2/local/io.github.kattulib/yay_3/0.1.0-SNAPSHOT

# on bash
$ sbt publishLocal
...
[info]  published ivy to /home/USER/.ivy2/local/io.github.kattulib/yay_3/0.1.0-SNAPSHOT
```

Then you can add the library in the library dependencies as others.
```scala
libraryDependencies += "io.github.kattulib" %% "yay" % "0.1.0-SNAPSHOT"
```

## Run Tests
You can run all tests as on the following command:
```bash
# on interactive sbt shell
sbt:yay> tests/test

# on bash
$ sbt tests/test
```

If you want to run specific test:
```bash
# on interactive sbt shell
sbt:yay> tests/testOnly *<SPECIFIC_TEST>

# on bash
$ sbt "tests/testOnly *<SPECIFIC_TEST"
```
